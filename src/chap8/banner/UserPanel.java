package chap8.banner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import chap8.users.User;
import chap8.users.Student;
import chap8.users.Staff;
import chap8.users.Admin;
import chap8.users.Faculty;

public class UserPanel extends JPanel {
    private JTextField nameBox;
    private JComboBox<String> typeDropdown;
    private JButton addButton;
    private UserListPanel userListPanel;
    private ArrayList<User> allUsers;

    public UserPanel(UserListPanel userListPanel, ArrayList<User> allUsers) {
        this.userListPanel = userListPanel;
        this.allUsers = allUsers;
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
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Type: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        typeDropdown = new JComboBox<>(Main.userTypes);
        add(typeDropdown, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        addButton = new JButton("Add User");
        add(addButton, gbc);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });
    }

    private void addUser() {
        String name = nameBox.getText();
        String type = (String) typeDropdown.getSelectedItem();
        if (!name.isEmpty() && type != null) {
            if (type.equals("Student")) {
                allUsers.add(new Student(name, type));
            } else if (type.equals("Faculty")) {
                allUsers.add(new Faculty(name, type));
            } else if (type.equals("Staff")) {
                allUsers.add(new Staff(name, type));
            } else if (type.equals("Admin")) {
                allUsers.add(new Admin(name, type));
            }
            nameBox.setText("");
            userListPanel.updateUserList(allUsers);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a name and select a type.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}