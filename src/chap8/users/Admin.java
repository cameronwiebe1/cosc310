package chap8.users;

public class Admin extends User {
    
    public Admin(String name, String id) {
        super(name, id, "", "");
    }

    @Override
    public String getType() {
        return "ADMIN";
    }
}
