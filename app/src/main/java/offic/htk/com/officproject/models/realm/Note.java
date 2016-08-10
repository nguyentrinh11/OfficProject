package offic.htk.com.officproject.models.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Mai Trinh on 8/1/2016.
 */
public class Note extends RealmObject {

    @Required
    String cdAccountID;
    String cdBody;
    @Required
    String cdBoxID;
    @Required
    String cdCompanyID;
    @Required
    String cdContactID;
    @Required
    String cdDealID;
    String cdHappen;
    @PrimaryKey
    @Required
    String cdID;
    @Required
    String cdOrgID;
    String cdPermiStatus;
    RealmList<Comment> commentList = new RealmList<>();
    Contact contact;
    RealmList<File> fileList = new RealmList<>();
    RealmList<User> notifyUserList = new RealmList<>();
    RealmList<Group> permitGroupList = new RealmList<>();
    RealmList<User> permitUserList = new RealmList<>();
    RealmList<Task> taskList = new RealmList<>();
    User userCreated;

    public Note() {
    }

    public Note(String cdAccountID, String cdBody, String cdBoxID, String cdCompanyID, String cdContactID, String cdDealID, String cdHappen, String cdID, String cdOrgID, String cdPermiStatus, RealmList<Comment> commentList, Contact contact, RealmList<File> fileList, RealmList<User> notifyUserList, RealmList<Group> permitGroupList, RealmList<User> permitUserList, RealmList<Task> taskList, User userCreated) {
        this.cdAccountID = cdAccountID;
        this.cdBody = cdBody;
        this.cdBoxID = cdBoxID;
        this.cdCompanyID = cdCompanyID;
        this.cdContactID = cdContactID;
        this.cdDealID = cdDealID;
        this.cdHappen = cdHappen;
        this.cdID = cdID;
        this.cdOrgID = cdOrgID;
        this.cdPermiStatus = cdPermiStatus;
        this.commentList = commentList;
        this.contact = contact;
        this.fileList = fileList;
        this.notifyUserList = notifyUserList;
        this.permitGroupList = permitGroupList;
        this.permitUserList = permitUserList;
        this.taskList = taskList;
        this.userCreated = userCreated;
    }

    public String getCdAccountID() {
        return cdAccountID;
    }

    public void setCdAccountID(String cdAccountID) {
        this.cdAccountID = cdAccountID;
    }

    public String getCdBody() {
        return cdBody;
    }

    public void setCdBody(String cdBody) {
        this.cdBody = cdBody;
    }

    public String getCdBoxID() {
        return cdBoxID;
    }

    public void setCdBoxID(String cdBoxID) {
        this.cdBoxID = cdBoxID;
    }

    public String getCdCompanyID() {
        return cdCompanyID;
    }

    public void setCdCompanyID(String cdCompanyID) {
        this.cdCompanyID = cdCompanyID;
    }

    public String getCdContactID() {
        return cdContactID;
    }

    public void setCdContactID(String cdContactID) {
        this.cdContactID = cdContactID;
    }

    public String getCdDealID() {
        return cdDealID;
    }

    public void setCdDealID(String cdDealID) {
        this.cdDealID = cdDealID;
    }

    public String getCdHappen() {
        return cdHappen;
    }

    public void setCdHappen(String cdHappen) {
        this.cdHappen = cdHappen;
    }

    public String getCdID() {
        return cdID;
    }

    public void setCdID(String cdID) {
        this.cdID = cdID;
    }

    public String getCdOrgID() {
        return cdOrgID;
    }

    public void setCdOrgID(String cdOrgID) {
        this.cdOrgID = cdOrgID;
    }

    public String getCdPermiStatus() {
        return cdPermiStatus;
    }

    public void setCdPermiStatus(String cdPermiStatus) {
        this.cdPermiStatus = cdPermiStatus;
    }

    public RealmList<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(RealmList<Comment> commentList) {
        this.commentList = commentList;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public RealmList<File> getFileList() {
        return fileList;
    }

    public void setFileList(RealmList<File> fileList) {
        this.fileList = fileList;
    }

    public RealmList<User> getNotifyUserList() {
        return notifyUserList;
    }

    public void setNotifyUserList(RealmList<User> notifyUserList) {
        this.notifyUserList = notifyUserList;
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

    public User getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(User userCreated) {
        this.userCreated = userCreated;
    }
}
