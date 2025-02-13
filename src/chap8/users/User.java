package chap8.users;

import java.io.Serializable;

public abstract class User implements Serializable {

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
        return String.format("%s - %s: 9xxxx%s", getType(), name, id.length()>6?id.substring(5):id);
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password; 
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    abstract public String getType();
}
