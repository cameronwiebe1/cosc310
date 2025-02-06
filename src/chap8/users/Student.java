package chap8.users;

public class Student extends User {
    public Student(String name, String id) {
        super(name, id, "", "");
    }

    //@Override
    //public String toString() {
    //    return "STUDENT - " + super.toString();
    //}

    @Override
    public String getType() {
        return "STUDENT";
    }
}
