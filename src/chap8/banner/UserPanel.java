package chap8.banner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import chap8.users.User;
import chap8.users.Student;
import chap8.users.Staff;
import chap8.users.Admin;
import chap8.users.Faculty;

public class UserPanel extends JPanel {
    private JTextField nameBox;
    private JTextField idBox;
    private JTextField usernameBox;
    private JTextField passwordBox;
    private JComboBox<String> typeDropdown;
    private JButton addButton;
    private JButton saveButton;
    private JButton loadButton;
    private UserListPanel userListPanel;
    private ArrayList<User> allusers;

    public UserPanel(UserListPanel userListPanel, ArrayList<User> allusers) {
        this.userListPanel = userListPanel;
        this.allusers = allusers;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Name: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        nameBox = new JTextField(15);
        add(nameBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("ID (9#): "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        idBox = new JTextField(15);
        add(idBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Username: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        usernameBox = new JTextField(15);
        add(usernameBox, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Password: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        passwordBox = new JTextField(15);
        add(passwordBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Type: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        typeDropdown = new JComboBox<>(Main.userTypes);
        add(typeDropdown, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        addButton = new JButton("Add User");
        saveButton = new JButton("Save Users");
        loadButton = new JButton("Load Users");
        buttonPanel.add(addButton, gbc);
        buttonPanel.add(saveButton, gbc);
        buttonPanel.add(loadButton, gbc);
        add(buttonPanel, gbc);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveUsers();
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadUsers();
                userListPanel.updateUserList(allusers);
            }
        });
        
    }

    private void saveUsers() {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                FileOutputStream fo = new FileOutputStream(chooser.getSelectedFile());
                ObjectOutputStream so = new ObjectOutputStream(fo);
                so.writeObject(allusers);
                so.flush();
                so.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void loadUsers() {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream fi = new FileInputStream(chooser.getSelectedFile());
                ObjectInputStream si = new ObjectInputStream(fi);
                ArrayList<User> tmpusers = (ArrayList<User>) si.readObject();
                allusers.clear();
                for (User u : tmpusers) {
                    allusers.add(u);
                }
                si.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void addUser() {
        String name = nameBox.getText();
        String type = (String) typeDropdown.getSelectedItem();
        if (!name.isEmpty() && type != null) {
            if (type.equals("Student")) {
                allusers.add(new Student(name, type));
            } else if (type.equals("Faculty")) {
                allusers.add(new Faculty(name, type));
            } else if (type.equals("Staff")) {
                allusers.add(new Staff(name, type));
            } else if (type.equals("Admin")) {
                allusers.add(new Admin(name, type));
            }
            nameBox.setText("");
            userListPanel.updateUserList(allusers);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a name and select a type.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadUser(User u) {
        // we must be editing a user ... change what is displayed in the addButton
        addButton.setText("Save Changes");
        nameBox.setText(u.getName());
        idBox.setText(u.getId());
        // finish loading the boxes        
    }
}