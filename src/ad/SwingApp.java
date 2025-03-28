package ad;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SwingApp {

    // JDBC connection settings
    static String DB_URL = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres?user=postgres.uzfqtmeirzyioxrfjniw&password=Hjxbc4hiHc8u9Jjq";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowLoginFrame());
    }

    private static void createAndShowLoginFrame() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        // Create login panel with GridLayout
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel lblUsername = new JLabel("Username:");
        JTextField txtUsername = new JTextField("wendys");
        JLabel lblPassword = new JLabel("Password:");
        JPasswordField txtPassword = new JPasswordField("test1111");
        JButton btnLogin = new JButton("Login");

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(new JLabel()); // Empty cell for layout spacing
        panel.add(btnLogin);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            String role = authenticateUser(username, password);

            if (role != null) {
                // If authentication succeeds, dispose of the login frame and show the appropriate dashboard
                frame.dispose();
                showDashboard(role);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // This method connects to the database, executes the query, and returns the user's role
    private static String authenticateUser(String username, String password) {
        String role = null;
        // SQL query joining the users and roles tables
        String query = "SELECT r.name " +
                       "FROM users u JOIN roles r ON u.role_id = r.id " +
                       "WHERE u.username = ? AND u.password = crypt(?, u.password)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                role = rs.getString("name");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return role;
    }

    // This method displays a new dashboard frame based on the user's role.
    private static void showDashboard(String role) {
        JFrame dashboardFrame = new JFrame("Dashboard - " + role);
        dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboardFrame.setSize(600, 400);
        dashboardFrame.setLocationRelativeTo(null);

        JPanel dashboardPanel;
        // Show different dashboards based on role
        if ("ADMIN".equalsIgnoreCase(role)) {
            dashboardPanel = new AdminDashboardPanel();
        } else if ("SALES".equalsIgnoreCase(role)) {
            dashboardPanel = new UserDashboardPanel();
        } else if ("BUSINESSCUSTOMER".equalsIgnoreCase(role)) {
            dashboardPanel = new BusinessCustomerDashboardPanel();
        } else {
            dashboardPanel = new DefaultDashboardPanel();
        }
        dashboardFrame.getContentPane().add(dashboardPanel);
        dashboardFrame.setVisible(true);
    }

    // Dashboard panel for ADMIN role
    static class AdminDashboardPanel extends JPanel {
        public AdminDashboardPanel() {
            setLayout(new BorderLayout());
            add(new JLabel("Welcome, Admin!"), BorderLayout.NORTH);
            // Additional admin-specific components can be added here
        }
    }

    // Dashboard panel for USER role
    static class UserDashboardPanel extends JPanel {
        public UserDashboardPanel() {
            setLayout(new BorderLayout());
            add(new JLabel("Welcome, User!"), BorderLayout.NORTH);
            // Additional user-specific components can be added here
        }
    }

    static class BusinessCustomerDashboardPanel extends JPanel {
        public BusinessCustomerDashboardPanel() {
            setLayout(new BorderLayout());
            add(new JLabel("Welcome, Business Customer!"), BorderLayout.NORTH);
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout()); // You can change the layout as needed

            // Add buttons to the panel
            JButton btnAds = new JButton("Ads");
            JButton btnBilling = new JButton("Billing");
            JButton btnLogout = new JButton("Logout");

            buttonPanel.add(btnAds);
            buttonPanel.add(btnBilling);
            buttonPanel.add(btnLogout);

            JPanel adsPanel = new JPanel(new BorderLayout());
            adsPanel.add(new JLabel("Ads Section"), BorderLayout.NORTH);
            JTextArea currentads = new JTextArea(10, 30);
            JTextArea oldads = new JTextArea(10, 30);
            adsPanel.add(new JScrollPane(currentads), BorderLayout.CENTER);
            adsPanel.add(new JScrollPane(oldads), BorderLayout.SOUTH);
            buttonPanel.add(adsPanel);
            adsPanel.setVisible(false); // Initially hide the ads panel

            btnAds.addActionListener(e -> {
                // Action for Ads button
                adsPanel.setVisible(true); // Show the ads panel
            });

            // Add the button panel to the center of the UserDashboardPanel
            add(buttonPanel, BorderLayout.CENTER);
        }
    }

    // Default dashboard panel for any other role
    static class DefaultDashboardPanel extends JPanel {
        public DefaultDashboardPanel() {
            setLayout(new BorderLayout());
            add(new JLabel("Welcome!"), BorderLayout.NORTH);
            // Additional components for a generic dashboard can be added here
        }
    }
}
