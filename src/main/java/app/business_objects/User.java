package app.business_objects;

/**
 * Created by User on 08.07.2017.
 */
public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
