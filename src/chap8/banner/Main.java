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
        // go ahead and populate all the data first
        populateUsers();

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
        UserListPanel userListPanel = new UserListPanel();
        UserPanel userPanel = new UserPanel(userListPanel, allusers);

        frame.add(userPanel, BorderLayout.NORTH);
        frame.add(userListPanel, BorderLayout.CENTER);
        userListPanel.updateUserList(allusers);
        frame.setVisible(true);
    }

    public void populateUsers() {
        System.out.println(allusers.size());
        allusers.add(new Student("Alice Johnson", "912345678"));
        allusers.add(new Faculty("Bob Smith", "923456789"));
        allusers.add(new Staff("Charlie Brown", "934567890"));
        allusers.add(new Student("David Miller", "945678901"));
        allusers.add(new Faculty("Emma Wilson", "956789012"));
        allusers.add(new Staff("Frank Taylor", "967890123"));
        allusers.add(new Student("Grace Anderson", "978901234"));
        allusers.add(new Faculty("Henry Thomas", "989012345"));
        allusers.add(new Staff("Isla Moore", "990123456"));
        allusers.add(new Student("Jack White", "901234567"));
        allusers.add(new Faculty("Katie Harris", "912398765"));
        allusers.add(new Staff("Liam Martin", "923487651"));
        allusers.add(new Student("Mia Thompson", "934576842"));
        allusers.add(new Faculty("Noah Lewis", "945665432"));
        allusers.add(new Staff("Olivia Walker", "956754321"));
        allusers.add(new Student("Peter Hall", "967843210"));
        allusers.add(new Faculty("Quinn Allen", "978932109"));
        allusers.add(new Staff("Ryan Young", "989021908"));
        allusers.add(new Student("Sophia King", "990110897"));
        allusers.add(new Faculty("Thomas Scott", "901299786"));
        allusers.add(new Staff("Uma Carter", "912388675"));
        allusers.add(new Student("Victor Evans", "923477564"));
        allusers.add(new Faculty("Wendy Green", "934566453"));
        allusers.add(new Staff("Xavier Adams", "945655342"));
        allusers.add(new Student("Yasmine Baker", "956744231"));
        allusers.add(new Faculty("Zachary Nelson", "967833120"));
        allusers.add(new Staff("Ava Reed", "978922019"));
        allusers.add(new Student("Benjamin Turner", "989011908"));
        allusers.add(new Faculty("Chloe Collins", "990100897"));
        allusers.add(new Staff("Daniel Stewart", "901289786"));
        allusers.add(new Student("Ella Morris", "912378675"));
        allusers.add(new Faculty("Felix Rogers", "923467564"));
        allusers.add(new Staff("Gabriella Murphy", "934556453"));
        allusers.add(new Student("Harrison Cooper", "945645342"));
        allusers.add(new Faculty("Isabella Bailey", "956734231"));
        allusers.add(new Staff("Jacob Hughes", "967823120"));
        allusers.add(new Student("Kaitlyn Price", "978912019"));
        allusers.add(new Faculty("Leo Russell", "989001908"));
        allusers.add(new Staff("Madison Foster", "990090897"));
        allusers.add(new Student("Nathaniel Barnes", "901279786"));
        allusers.add(new Faculty("Olive Simmons", "912368675"));
        allusers.add(new Staff("Patrick Wright", "923457564"));
        allusers.add(new Student("Quincy Butler", "934546453"));
        allusers.add(new Faculty("Rebecca Ward", "945635342"));
        allusers.add(new Staff("Samuel Peterson", "956724231"));
        allusers.add(new Student("Tessa Long", "967813120"));
        allusers.add(new Faculty("Ulysses Carter", "978902019"));
        allusers.add(new Staff("Violet Sanders", "989091908"));
        allusers.add(new Student("William Bell", "990080897"));
        allusers.add(new Faculty("Xena Mitchell", "901269786"));
        allusers.add(new Staff("Yosef Patterson", "912358675"));
        allusers.add(new Student("Zoe Jenkins", "923447564"));
        allusers.add(new Faculty("Aaron Coleman", "934536453"));
        allusers.add(new Staff("Brittany Perry", "945625342"));
        allusers.add(new Student("Caleb Hughes", "956714231"));
        allusers.add(new Faculty("Diana Jordan", "967803120"));
        allusers.add(new Staff("Ethan Bryant", "978892019"));
        allusers.add(new Student("Faith Butler", "989081908"));
        allusers.add(new Faculty("George Henderson", "990070897"));
        allusers.add(new Staff("Hannah Fisher", "901259786"));
        allusers.add(new Student("Ian Griffin", "912348675"));
        allusers.add(new Faculty("Jasmine Woods", "923437564"));
        allusers.add(new Staff("Kevin Shaw", "934526453"));
        allusers.add(new Student("Lily Hudson", "945615342"));
        allusers.add(new Faculty("Mason Gibson", "956704231"));
        allusers.add(new Staff("Natalie Harper", "967793120"));
        allusers.add(new Student("Oscar Dean", "978882019"));
        allusers.add(new Faculty("Paige West", "989071908"));
        allusers.add(new Staff("Quentin Stone", "990060897"));
        allusers.add(new Student("Riley Brooks", "901249786"));
        allusers.add(new Faculty("Sarah Ford", "912338675"));
        allusers.add(new Staff("Tristan Kennedy", "923427564"));
        allusers.add(new Student("Ursula Graham", "934516453"));
        allusers.add(new Faculty("Vincent Elliott", "945605342"));
        allusers.add(new Staff("Whitney Cunningham", "956694231"));
        allusers.add(new Student("Xander Wells", "967783120"));
        allusers.add(new Faculty("Yvette Spencer", "978872019"));
        allusers.add(new Staff("Zander Matthews", "989061908"));
        allusers.add(new Student("Amber Flores", "990050897"));
        allusers.add(new Faculty("Blake Simmons", "901239786"));
        allusers.add(new Staff("Cameron Maxwell", "912328675"));
        allusers.add(new Student("Delilah Hawkins", "923417564"));
        allusers.add(new Faculty("Elijah Bishop", "934506453"));
        allusers.add(new Staff("Fiona Paul", "945595342"));
        allusers.add(new Student("Gideon Parker", "956684231"));
        allusers.add(new Faculty("Harper Lane", "967773120"));
        allusers.add(new Staff("Isaac Reynolds", "978862019"));
        allusers.add(new Student("Julia Dixon", "989051908"));
        allusers.add(new Faculty("Kyle Richards", "990040897"));
        allusers.add(new Staff("Luna Beck", "901229786"));
        allusers.add(new Student("Micah Lawson", "912318675"));
        allusers.add(new Faculty("Nina Freeman", "923407564"));
        allusers.add(new Staff("Owen Curtis", "934496453"));
        allusers.add(new Student("Peyton Marshall", "945585342"));
        allusers.add(new Faculty("Quinn Elliott", "956674231"));
        allusers.add(new Staff("Ronan Pierce", "967763120"));
        allusers.add(new Student("Savannah Burke", "978852019"));
        allusers.add(new Faculty("Theo Harmon", "989041908"));
        allusers.add(new Staff("Uriah Baldwin", "990030897"));
        allusers.add(new Student("Vanessa Lowe", "901219786"));
        allusers.add(new Admin("Admin Smith", "999999999"));
        System.out.println(allusers.size());
        for (User user : allusers) {
            System.out.println(user.toString());
        }
    }

}
