package offic.htk.com.officproject.models.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Mai Trinh on 8/1/2016.
 */
public class Box extends RealmObject {

    @PrimaryKey
    @Required
    String cdAccountID;
    String cdAvartar;
    String cdBgInfo;
    String cdCloseAt;
    String cdCompanyID;
    String cdCreateBy;
    String cdID;
    String cdName;
    String cdOrg;
    String cdPermitStatus;
    String cdSort;
    String cdStatus;
    String cdUpAt;
    RealmList<Contact> contactList = new RealmList<>();
    RealmList<Group> permitGroupList = new RealmList<>();
    RealmList<User> permitUserList = new RealmList<>();
    RealmList<Task> taskList = new RealmList<>();

    public Box() {
    }

    public Box(String cdAccountID, String cdAvartar, String cdBgInfo, String cdCloseAt, String cdCompanyID, String cdCreateBy, String cdID, String cdName, String cdOrg, String cdPermitStatus, String cdSort, String cdStatus, String cdUpAt, RealmList<Contact> contactList, RealmList<Group> permitGroupList, RealmList<User> permitUserList, RealmList<Task> taskList) {
        this.cdAccountID = cdAccountID;
        this.cdAvartar = cdAvartar;
        this.cdBgInfo = cdBgInfo;
        this.cdCloseAt = cdCloseAt;
        this.cdCompanyID = cdCompanyID;
        this.cdCreateBy = cdCreateBy;
        this.cdID = cdID;
        this.cdName = cdName;
        this.cdOrg = cdOrg;
        this.cdPermitStatus = cdPermitStatus;
        this.cdSort = cdSort;
        this.cdStatus = cdStatus;
        this.cdUpAt = cdUpAt;
        this.contactList = contactList;
        this.permitGroupList = permitGroupList;
        this.permitUserList = permitUserList;
        this.taskList = taskList;
    }

    public String getCdAccountID() {
        return cdAccountID;
    }

    public void setCdAccountID(String cdAccountID) {
        this.cdAccountID = cdAccountID;
    }

    public String getCdAvartar() {
        return cdAvartar;
    }

    public void setCdAvartar(String cdAvartar) {
        this.cdAvartar = cdAvartar;
    }

    public String getCdBgInfo() {
        return cdBgInfo;
    }

    public void setCdBgInfo(String cdBgInfo) {
        this.cdBgInfo = cdBgInfo;
    }

    public String getCdCloseAt() {
        return cdCloseAt;
    }

    public void setCdCloseAt(String cdCloseAt) {
        this.cdCloseAt = cdCloseAt;
    }

    public String getCdCompanyID() {
        return cdCompanyID;
    }

    public void setCdCompanyID(String cdCompanyID) {
        this.cdCompanyID = cdCompanyID;
    }

    public String getCdCreateBy() {
        return cdCreateBy;
    }

    public void setCdCreateBy(String cdCreateBy) {
        this.cdCreateBy = cdCreateBy;
    }

    public String getCdID() {
        return cdID;
    }

    public void setCdID(String cdID) {
        this.cdID = cdID;
    }

    public String getCdName() {
        return cdName;
    }

    public void setCdName(String cdName) {
        this.cdName = cdName;
    }

    public String getCdOrg() {
        return cdOrg;
    }

    public void setCdOrg(String cdOrg) {
        this.cdOrg = cdOrg;
    }

    public String getCdPermitStatus() {
        return cdPermitStatus;
    }

    public void setCdPermitStatus(String cdPermitStatus) {
        this.cdPermitStatus = cdPermitStatus;
    }

    public String getCdSort() {
        return cdSort;
    }

    public void setCdSort(String cdSort) {
        this.cdSort = cdSort;
    }

    public String getCdStatus() {
        return cdStatus;
    }

    public void setCdStatus(String cdStatus) {
        this.cdStatus = cdStatus;
    }

    public String getCdUpAt() {
        return cdUpAt;
    }

    public void setCdUpAt(String cdUpAt) {
        this.cdUpAt = cdUpAt;
    }

    public RealmList<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(RealmList<Contact> contactList) {
        this.contactList = contactList;
    }

    public RealmList<Group> getPermitGroupList() {
        return permitGroupList;
    }

    public void setPermitGroupList(RealmList<Group> permitGroupList) {
        this.permitGroupList = permitGroupList;
    }

    public RealmList<User> getPermitUserList() {
        return permitUserList;
    }

    public void setPermitUserList(RealmList<User> permitUserList) {
        this.permitUserList = permitUserList;
    }

    public RealmList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(RealmList<Task> taskList) {
        this.taskList = taskList;
    }
}