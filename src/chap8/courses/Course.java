package chap8.courses;

public class Course {
    String department;
    String number;
    String title; 
    int credits;

    public Course(String department, String number, String title, int credits) {
        this.department = department;
        this.number = number;
        this.title = title;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return department + " " + number + " - " + title + " (" + credits + " credits)";
    }
}