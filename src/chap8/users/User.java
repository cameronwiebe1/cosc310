package chap8.users;

public abstract class User {

    protected String name;
    protected String id; // nine #
    protected String username;
    protected String password;

    public User() {
        // nothing to do here
    }

    public User(String name, String id, String username, String password) {
        this.name = name;
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String name) {
        this(name, "901010103", "", "");
    }

    @Override
    public String toString() {
        return String.format("%s - %s: 9xxxx%s", getType(), name, id.substring(5));
    }

    public String getName() {
        return name;
    }

    abstract public String getType();
}
