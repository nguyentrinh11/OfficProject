package offic.htk.com.officproject.rest.response;

/**
 * Created by nguyen on 28/07/2016.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LoginResponse {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("belongOrgs")
    @Expose
    private List<Object> belongOrgs = new ArrayList<Object>();
    @SerializedName("ownOrgs")
    @Expose
    private List<String> ownOrgs = new ArrayList<String>();
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The belongOrgs
     */
    public List<Object> getBelongOrgs() {
        return belongOrgs;
    }

    /**
     * @param belongOrgs The belongOrgs
     */
    public void setBelongOrgs(List<Object> belongOrgs) {
        this.belongOrgs = belongOrgs;
    }

    /**
     * @return The ownOrgs
     */
    public List<String> getOwnOrgs() {
        return ownOrgs;
    }

    /**
     * @param ownOrgs The ownOrgs
     */
    public void setOwnOrgs(List<String> ownOrgs) {
        this.ownOrgs = ownOrgs;
    }

    /**
     * @return The avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar The avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return The lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname The lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return The firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname The firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

}