package chap8.degreeworks;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import chap8.courses.Course;
import chap8.courses.Section;
import chap8.courses.Term;
import chap8.users.User;

public class TermsActionPanel extends ActionPanel {
    public TermsActionPanel(Main main, ArrayList<User> allusers, ArrayList<Course> allcourses, ArrayList<Section> allsections, ArrayList<Term> allterms) {
        super(main, allusers, allcourses, allsections, allterms);
    }
    
    @Override
    protected JPanel setupGUI() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Terms"));
        return panel;
    }

    public void loadTerm(Term t) {
    }

}
