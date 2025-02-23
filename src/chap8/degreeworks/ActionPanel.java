package chap8.degreeworks;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import chap8.courses.Course;
import chap8.courses.Section;
import chap8.courses.Term;
import chap8.users.User;

public abstract class ActionPanel extends JPanel {

    // references to the global data ... NOTE: since this is in the base class we don't need to declare and init these in the derived classes!
    protected ArrayList<User> allusers = new ArrayList<>();
    protected ArrayList<Course> allcourses = new ArrayList<>();
    protected ArrayList<Section> allsections = new ArrayList<>();
    protected ArrayList<Term> allterms = new ArrayList<>();

    // rather than passing a reference to each of the panels with the associated lists so that we can notify them when something happens, we can instead pass a reference to Main which has a reference to all of our "ActionPanel"s
    // and can call the appropriate method on the appropriate panel (or all the panels for each of implementation)
    protected Main main;

    public ActionPanel(Main main, ArrayList<User> allusers, ArrayList<Course> allcourses, ArrayList<Section> allsections, ArrayList<Term> allterms) {
        this.main = main;
        this.allusers = allusers;
        this.allcourses = allcourses;
        this.allsections = allsections;
        this.allterms = allterms;
        setupPanel(); // setup the top area with the name of the person who has logged in
    }

    // this method is called by the constructor to setup the top area with the name of the person who has logged in
    protected void setupPanel() {
        // setup the common components (title label, login label, and help button)
        // this is the same for all the panels so we can put it here
        this.setLayout(new BorderLayout());
        JPanel topArea = new JPanel();
        JLabel titleLabel = new JLabel("Welcome " + main.currentuser.getName(), JLabel.CENTER);
        JButton helpButton = new JButton("HELP");
        topArea.add(titleLabel);
        topArea.add(helpButton);
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.handleHelpClick();
            }
        });
        this.add(topArea, BorderLayout.NORTH);

        // now call the abstract method to allow the derived class to setup the rest of the GUI ... note that this is an example of polymorphism
        JPanel mainGUI = setupGUI(); 
        this.add(mainGUI, BorderLayout.CENTER);
    }

    abstract protected JPanel setupGUI();
    
}
