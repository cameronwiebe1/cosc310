package chap8.users;

public class Faculty extends Employee {

    public Faculty(String name, String id) {
        super(name, id);
    }

    @Override
    public String getType() {
        return "FACULTY";
    }
}
