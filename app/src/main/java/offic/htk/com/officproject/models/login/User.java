package offic.htk.com.officproject.models.login;

/**
 * Created by nguyen on 28/07/2016.
 */
public class User {
    public User() {
    }

    private String username, password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }
}
