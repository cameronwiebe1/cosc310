package chap8.banner;

import java.util.ArrayList;

import chap8.users.Admin;
import chap8.users.Faculty;
import chap8.users.Staff;
import chap8.users.Student;
import chap8.users.User; 

import javax.swing.*;

import java.awt.BorderLayout;

public class Main {

    // Data attribute
    ArrayList<User> allusers = new ArrayList<>(100);
    public static String[] userTypes = new String[] {"Student","Faculty","Staff","Admin"};

    public Main() {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }


    public void createAndShowGUI() {
        JFrame frame = new JFrame("User Management");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the panels
        UserListPanel userListPanel = new UserListPanel(allusers);
        UserPanel userPanel = new UserPanel(userListPanel, allusers);
        userListPanel.userPanel = userPanel;

        frame.add(userPanel, BorderLayout.NORTH);
        frame.add(userListPanel, BorderLayout.CENTER);
        userListPanel.updateUserList(allusers);
        frame.setVisible(true);
    }

}
