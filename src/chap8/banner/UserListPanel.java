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
    private ArrayList<User> allusers;
    public UserPanel userPanel;

    public UserListPanel(ArrayList<User> allusers) {
        this.allusers = allusers;
        setLayout(new BorderLayout());
        listModel = new DefaultListModel<>();
        userList = new JList<>(listModel);
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(userList);
        add(scrollPane, BorderLayout.CENTER);
        userList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    loadUser();
                }
            }
        });
    }

    public void loadUser() {
        User u = allusers.get(userList.getSelectedIndex());
        userPanel.loadUser(u);
        System.out.println(userList.getSelectedValue());        
    }

    public void updateUserList(ArrayList<User> users) {
        listModel.clear();
        for (User user : users) {
            listModel.addElement(user.toString());
        }
    }
}