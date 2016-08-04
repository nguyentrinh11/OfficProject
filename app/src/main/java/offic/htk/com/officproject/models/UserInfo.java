package offic.htk.com.officproject.models;

/**
 * Created by nguyen on 02/08/2016.
 */
public class UserInfo {
    private String url, username;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserInfo() {

    }

    public UserInfo(String url, String username) {
        this.url = url;
        this.username = username;
    }
}
