package chap8.degreeworks;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import chap8.courses.Course;
import chap8.courses.Section;
import chap8.courses.Term;
import chap8.users.User;

public class SectionsActionPanel extends ActionPanel {
    public SectionsActionPanel(Main main, ArrayList<User> allusers, ArrayList<Course> allcourses, ArrayList<Section> allsections, ArrayList<Term> allterms) {
        super(main, allusers, allcourses, allsections, allterms);
    }

    public void loadSection(Section s) {
    }

    @Override
    protected JPanel setupGUI() {
        JPanel panel = new JPanel();
        
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
        northPanel.add(new JLabel("SECTIONS ACTION PANEL"), BorderLayout.NORTH);
        panel.add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());

        // fill in the rest of your code here to add all the necessary components to the centerPanel

        panel.add(centerPanel, BorderLayout.CENTER);
        return panel;
    }

}
