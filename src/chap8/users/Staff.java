package chap8.users;

public class Staff extends Employee {
    public Staff(String name, String id) {
        super(name, id);
    }

    @Override
    public String getType() {
        return "STAFF";
    }
}
