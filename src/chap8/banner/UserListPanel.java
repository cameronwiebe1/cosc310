package chap8.banner;

import javax.swing.*;
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
    }

    public void updateUserList(ArrayList<User> users) {
        listModel.clear();
        for (User user : users) {
            listModel.addElement(user.getName() + " - " + user.getType());
        }
    }
}