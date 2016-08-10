package offic.htk.com.officproject.models.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Mai Trinh on 8/1/2016.
 */
public class User extends RealmObject {

    boolean cdActive;
    String cdAvatar;
    String cdCompanyID;
    String cdEmail;
    String cdExtendsion;
    String cdFirstName;
    String cdHasExport;
    @PrimaryKey
    @Required
    String cdID;
    String cdInviteAt;
    String cdInviteBy;
    String cdLastName;
    ;
    String cdNew;
    String cdRole;
    String cdUserID;
    String cdUserName;
    RealmList<Box> boxListWithPermit = new RealmList<>();
    RealmList<Comment> commentList = new RealmList<>();
    Contact contact;
    Deal deal;
    Deal dealPermission;
    RealmList<Group> groupCreateBy = new RealmList<>();
    RealmList<Group> groupList = new RealmList<>();
    Note note;
    RealmList<Note> noteListeCreateBy = new RealmList<>();
    Note noteNotify;
    Setting setting;
    Task task;

    public User() {
    }

    public User(boolean cdActive, String cdAvatar, String cdCompanyID, String cdEmail, String cdExtendsion, String cdFirstName, String cdHasExport, String cdID, String cdInviteAt, String cdInviteBy, String cdLastName, String cdNew, String cdRole, String cdUserID, String cdUserName, RealmList<Box> boxListWithPermit, RealmList<Comment> commentList, Contact contact, Deal deal, Deal dealPermission, RealmList<Group> groupCreateBy, RealmList<Group> groupList, Note note, RealmList<Note> noteListeCreateBy, Note noteNotify, Setting setting, Task task) {
        this.cdActive = cdActive;
        this.cdAvatar = cdAvatar;
        this.cdCompanyID = cdCompanyID;
        this.cdEmail = cdEmail;
        this.cdExtendsion = cdExtendsion;
        this.cdFirstName = cdFirstName;
        this.cdHasExport = cdHasExport;
        this.cdID = cdID;
        this.cdInviteAt = cdInviteAt;
        this.cdInviteBy = cdInviteBy;
        this.cdLastName = cdLastName;
        this.cdNew = cdNew;
        this.cdRole = cdRole;
        this.cdUserID = cdUserID;
        this.cdUserName = cdUserName;
        this.boxListWithPermit = boxListWithPermit;
        this.commentList = commentList;
        this.contact = contact;
        this.deal = deal;
        this.dealPermission = dealPermission;
        this.groupCreateBy = groupCreateBy;
        this.groupList = groupList;
        this.note = note;
        this.noteListeCreateBy = noteListeCreateBy;
        this.noteNotify = noteNotify;
        this.setting = setting;
        this.task = task;
    }

    public boolean isCdActive() {
        return cdActive;
    }

    public void setCdActive(boolean cdActive) {
        this.cdActive = cdActive;
    }

    public String getCdAvatar() {
        return cdAvatar;
    }

    public void setCdAvatar(String cdAvatar) {
        this.cdAvatar = cdAvatar;
    }

    public String getCdCompanyID() {
        return cdCompanyID;
    }

    public void setCdCompanyID(String cdCompanyID) {
        this.cdCompanyID = cdCompanyID;
    }

    public String getCdEmail() {
        return cdEmail;
    }

    public void setCdEmail(String cdEmail) {
        this.cdEmail = cdEmail;
    }

    public String getCdExtendsion() {
        return cdExtendsion;
    }

    public void setCdExtendsion(String cdExtendsion) {
        this.cdExtendsion = cdExtendsion;
    }

    public String getCdFirstName() {
        return cdFirstName;
    }

    public void setCdFirstName(String cdFirstName) {
        this.cdFirstName = cdFirstName;
    }

    public String getCdHasExport() {
        return cdHasExport;
    }

    public void setCdHasExport(String cdHasExport) {
        this.cdHasExport = cdHasExport;
    }

    public String getCdID() {
        return cdID;
    }

    public void setCdID(String cdID) {
        this.cdID = cdID;
    }

    public String getCdInviteAt() {
        return cdInviteAt;
    }

    public void setCdInviteAt(String cdInviteAt) {
        this.cdInviteAt = cdInviteAt;
    }

    public String getCdInviteBy() {
        return cdInviteBy;
    }

    public void setCdInviteBy(String cdInviteBy) {
        this.cdInviteBy = cdInviteBy;
    }

    public String getCdLastName() {
        return cdLastName;
    }

    public void setCdLastName(String cdLastName) {
        this.cdLastName = cdLastName;
    }

    public String getCdNew() {
        return cdNew;
    }

    public void setCdNew(String cdNew) {
        this.cdNew = cdNew;
    }

    public String getCdRole() {
        return cdRole;
    }

    public void setCdRole(String cdRole) {
        this.cdRole = cdRole;
    }

    public String getCdUserID() {
        return cdUserID;
    }

    public void setCdUserID(String cdUserID) {
        this.cdUserID = cdUserID;
    }

    public String getCdUserName() {
        return cdUserName;
    }

    public void setCdUserName(String cdUserName) {
        this.cdUserName = cdUserName;
    }

    public RealmList<Box> getBoxListWithPermit() {
        return boxListWithPermit;
    }

    public void setBoxListWithPermit(RealmList<Box> boxListWithPermit) {
        this.boxListWithPermit = boxListWithPermit;
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

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public Deal getDealPermission() {
        return dealPermission;
    }

    public void setDealPermission(Deal dealPermission) {
        this.dealPermission = dealPermission;
    }

    public RealmList<Group> getGroupCreateBy() {
        return groupCreateBy;
    }

    public void setGroupCreateBy(RealmList<Group> groupCreateBy) {
        this.groupCreateBy = groupCreateBy;
    }

    public RealmList<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(RealmList<Group> groupList) {
        this.groupList = groupList;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public RealmList<Note> getNoteListeCreateBy() {
        return noteListeCreateBy;
    }

    public void setNoteListeCreateBy(RealmList<Note> noteListeCreateBy) {
        this.noteListeCreateBy = noteListeCreateBy;
    }

    public Note getNoteNotify() {
        return noteNotify;
    }

    public void setNoteNotify(Note noteNotify) {
        this.noteNotify = noteNotify;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}