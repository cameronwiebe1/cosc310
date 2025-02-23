package chap8.degreeworks;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import chap8.courses.Course;
import chap8.courses.Section;
import chap8.courses.Term;
import chap8.users.User;

public class HelpActionPanel extends ActionPanel {
    public HelpActionPanel(Main main, ArrayList<User> allusers, ArrayList<Course> allcourses, ArrayList<Section> allsections, ArrayList<Term> allterms) {
        super(main, allusers, allcourses, allsections, allterms);
    }

    @Override
    protected JPanel setupGUI() {
        JPanel panel = new JPanel();
        String htmlWelcome = "<html><center><font size='9'>Welcome to DegreeWorks</font><br />Start clicking!</center></html>";
        JLabel label = new JLabel(htmlWelcome);
        panel.add(label);
        return panel;
    }

}
