package chap8.courses;

import java.util.ArrayList;
import chap8.users.Faculty;
import chap8.users.Student;

public class Section {
    Term term;
    String number;
    String schedule;
    String room;
    Course course;
    Faculty instructor;
    ArrayList<Student> students;

    public Section(Term term, String number, String schedule, String room, Course course, Faculty instructor, ArrayList<Student> students) {
        this.term = term;
        this.number = number;
        this.schedule = schedule;
        this.room = room;
        this.course = course;
        this.instructor = instructor;
        this.students = students;
    }

    @Override
    public String toString() {
        return course.number + "-" + number + ": " + schedule + ", " + room + ", " + instructor.getName() + ", " + students.size() + " student(s)";
    }
}