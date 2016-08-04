
package offic.htk.com.officproject.rest.response.ListOrganizations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Organization {

    @SerializedName("subdomain")
    @Expose
    private String subdomain;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("settings")
    @Expose
    private List<Object> settings = new ArrayList<Object>();
    @SerializedName("users")
    @Expose
    private List<Object> users = new ArrayList<Object>();
    @SerializedName("features")
    @Expose
    private List<Object> features = new ArrayList<Object>();
    @SerializedName("plan")
    @Expose
    private String plan;

    /**
     * 
     * @return
     *     The subdomain
     */
    public String getSubdomain() {
        return subdomain;
    }

    /**
     * 
     * @param subdomain
     *     The subdomain
     */
    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 
     * @param createdBy
     *     The createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 
     * @return
     *     The logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 
     * @param logo
     *     The logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 
     * @return
     *     The settings
     */
    public List<Object> getSettings() {
        return settings;
    }

    /**
     * 
     * @param settings
     *     The settings
     */
    public void setSettings(List<Object> settings) {
        this.settings = settings;
    }

    /**
     * 
     * @return
     *     The users
     */
    public List<Object> getUsers() {
        return users;
    }

    /**
     * 
     * @param users
     *     The users
     */
    public void setUsers(List<Object> users) {
        this.users = users;
    }

    /**
     * 
     * @return
     *     The features
     */
    public List<Object> getFeatures() {
        return features;
    }

    /**
     * 
     * @param features
     *     The features
     */
    public void setFeatures(List<Object> features) {
        this.features = features;
    }

    /**
     * 
     * @return
     *     The plan
     */
    public String getPlan() {
        return plan;
    }

    /**
     * 
     * @param plan
     *     The plan
     */
    public void setPlan(String plan) {
        this.plan = plan;
    }

}
