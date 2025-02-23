package chap8.degreeworks;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import chap8.courses.Course;
import chap8.courses.Section;
import chap8.courses.Term;
import chap8.users.User;

public class CoursesActionPanel extends ActionPanel {
    public CoursesActionPanel(Main main, ArrayList<User> allusers, ArrayList<Course> allcourses, ArrayList<Section> allsections, ArrayList<Term> allterms) {
        super(main, allusers, allcourses, allsections, allterms);
    }

    public void loadCourse(Course c) {
    }

    @Override
    protected JPanel setupGUI() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Courses"));
        return panel;
    }


}
