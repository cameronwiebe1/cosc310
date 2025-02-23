package chap8.degreeworks;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import chap8.courses.Course;
import chap8.courses.Section;
import chap8.courses.Term;
import chap8.users.User;

public class CatalogPanel extends JPanel {

    protected Main main; // reference back to main so we can push all events back up there to distribute to our other UI components. the IDEA behind listeners is to avoid this, but then we are going to have listeners everywhere.
    protected DefaultListModel<String> courselistModel;
    protected DefaultListModel<String> sectionlistModel;
    protected DefaultListModel<String> termlistModel;
    protected JList<String> coursesList;
    protected JList<String> sectionsList;
    protected JList<String> termsList;
    protected ArrayList<User> allusers;
    protected ArrayList<Course> allcourses;
    protected ArrayList<Section> allsections;
    protected ArrayList<Term> allterms;
                        
    public CatalogPanel(Main main, ArrayList<User> allusers, ArrayList<Course> allcourses, ArrayList<Section> allsections, ArrayList<Term> allterms) {
        this.main = main;
        this.allusers = allusers;
        this.allcourses = allcourses;
        this.allsections = allsections;
        this.allterms = allterms;
        setupLists();
    }

    protected void setupLists() {
        termlistModel = new DefaultListModel<>();
        courselistModel = new DefaultListModel<>();
        sectionlistModel = new DefaultListModel<>();
        termsList = new JList<>(termlistModel);
        termsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        coursesList = new JList<>(courselistModel);
        coursesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sectionsList = new JList<>(sectionlistModel);
        sectionsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // need a scrollable pane for the list so we also need a jpanel to hold the lists
        add(new JScrollPane(termsList));
        add(new JScrollPane(coursesList));
        add(new JScrollPane(sectionsList));

        // setup all the click listeners just to pass the relevant data back to Main
        termsList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && termsList.getSelectedIndex() != -1) {
                main.handleTermClick(allterms.get(termsList.getSelectedIndex()));
            }
        });
        coursesList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && coursesList.getSelectedIndex() != -1) {
                main.handleCourseClick(allcourses.get(coursesList.getSelectedIndex()));
            }
        });
        sectionsList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && sectionsList.getSelectedIndex() != -1) {
                main.handleSectionClick(allsections.get(sectionsList.getSelectedIndex()));
            }
        });

        // clear and load all lists
        updateAllLists();
    }
        
    protected void updateAllLists() {
        termlistModel.clear();
        courselistModel.clear();
        sectionlistModel.clear();
        for (Term t : allterms) {
            termlistModel.addElement(t.toString());
        }
        for (Course c : allcourses) {
            courselistModel.addElement(c.toString());
        }
        for (Section s : allsections) {
            sectionlistModel.addElement(s.toString());
        }
    }
        
    public void loadCourse(Course c) {
    }
    
}
