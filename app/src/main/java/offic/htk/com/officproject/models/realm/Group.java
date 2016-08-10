package offic.htk.com.officproject.models.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Mai Trinh on 8/1/2016.
 */
public class Group extends RealmObject {
    @Required
    String cdAccountID;
    @Required
    String cdCompanyID;
    @PrimaryKey
    @Required
    String cdID;
    String cdName;
    Box box;
    Contact contact;
    Deal deal;
    Note note;
    Task task;
    User userCreate;
    RealmList<User> userList = new RealmList<>();

    public Group() {
    }

    public Group(String cdAccountID, String cdCompanyID, String cdID, String cdName, Box box, Contact contact, Deal deal, Note note, Task task, User userCreate, RealmList<User> userList) {
        this.cdAccountID = cdAccountID;
        this.cdCompanyID = cdCompanyID;
        this.cdID = cdID;
        this.cdName = cdName;
        this.box = box;
        this.contact = contact;
        this.deal = deal;
        this.note = note;
        this.task = task;
        this.userCreate = userCreate;
        this.userList = userList;
    }

    public String getCdAccountID() {
        return cdAccountID;
    }

    public void setCdAccountID(String cdAccountID) {
        this.cdAccountID = cdAccountID;
    }

    public String getCdCompanyID() {
        return cdCompanyID;
    }

    public void setCdCompanyID(String cdCompanyID) {
        this.cdCompanyID = cdCompanyID;
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

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
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

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(User userCreate) {
        this.userCreate = userCreate;
    }

    public RealmList<User> getUserList() {
        return userList;
    }

    public void setUserList(RealmList<User> userList) {
        this.userList = userList;
    }
}