package chap8.banner;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.util.ArrayList;
import chap8.users.User;

public class UserListPanel extends JPanel {
    private JList<String> userList;
    private DefaultListModel<String> listModel;

    public UserListPanel() {
        setLayout(new BorderLayout());
        listModel = new DefaultListModel<>();
        userList = new JList<>(listModel);
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(userList);
        add(scrollPane, BorderLayout.CENTER);
        userList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                editUser();
            }
            
        });
    }

    public void editUser() {
        System.out.println(userList.getSelectedValue());
        
    }

    public void updateUserList(ArrayList<User> users) {
        listModel.clear();
        for (User user : users) {
            listModel.addElement(user.toString());
        }
    }
}