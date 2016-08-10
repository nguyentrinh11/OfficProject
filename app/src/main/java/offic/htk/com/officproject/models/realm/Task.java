package offic.htk.com.officproject.models.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by Mai Trinh on 8/1/2016.
 */
public class Task extends RealmObject {

    @Required
    String cdAccountID;
    @Required
    String cdAssignedAccountID;
    String cdBody;
    String cdCompany;
    String cdDueAt;
    String cdDuetype;
    String cdPermitStatus;
    String cdStatus;
    Box box;
    Contact contact;
    Deal deal;
    RealmList<Group> groupPermitList = new RealmList<>();
    Note note;
    OfficCategory officCategory;
    RealmList<User> userPermitList = new RealmList<>();

    public Task() {
    }

    public Task(String cdAccountID, String cdAssignedAccountID, String cdBody, String cdCompany, String cdDueAt, String cdDuetype, String cdPermitStatus, String cdStatus, Box box, Contact contact, Deal deal, RealmList<Group> groupPermitList, Note note, OfficCategory officCategory, RealmList<User> userPermitList) {
        this.cdAccountID = cdAccountID;
        this.cdAssignedAccountID = cdAssignedAccountID;
        this.cdBody = cdBody;
        this.cdCompany = cdCompany;
        this.cdDueAt = cdDueAt;
        this.cdDuetype = cdDuetype;
        this.cdPermitStatus = cdPermitStatus;
        this.cdStatus = cdStatus;
        this.box = box;
        this.contact = contact;
        this.deal = deal;
        this.groupPermitList = groupPermitList;
        this.note = note;
        this.officCategory = officCategory;
        this.userPermitList = userPermitList;
    }

    public String getCdAccountID() {
        return cdAccountID;
    }

    public void setCdAccountID(String cdAccountID) {
        this.cdAccountID = cdAccountID;
    }

    public String getCdAssignedAccountID() {
        return cdAssignedAccountID;
    }

    public void setCdAssignedAccountID(String cdAssignedAccountID) {
        this.cdAssignedAccountID = cdAssignedAccountID;
    }

    public String getCdBody() {
        return cdBody;
    }

    public void setCdBody(String cdBody) {
        this.cdBody = cdBody;
    }

    public String getCdCompany() {
        return cdCompany;
    }

    public void setCdCompany(String cdCompany) {
        this.cdCompany = cdCompany;
    }

    public String getCdDueAt() {
        return cdDueAt;
    }

    public void setCdDueAt(String cdDueAt) {
        this.cdDueAt = cdDueAt;
    }

    public String getCdDuetype() {
        return cdDuetype;
    }

    public void setCdDuetype(String cdDuetype) {
        this.cdDuetype = cdDuetype;
    }

    public String getCdPermitStatus() {
        return cdPermitStatus;
    }

    public void setCdPermitStatus(String cdPermitStatus) {
        this.cdPermitStatus = cdPermitStatus;
    }

    public String getCdStatus() {
        return cdStatus;
    }

    public void setCdStatus(String cdStatus) {
        this.cdStatus = cdStatus;
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

    public RealmList<Group> getGroupPermitList() {
        return groupPermitList;
    }

    public void setGroupPermitList(RealmList<Group> groupPermitList) {
        this.groupPermitList = groupPermitList;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public OfficCategory getOfficCategory() {
        return officCategory;
    }

    public void setOfficCategory(OfficCategory officCategory) {
        this.officCategory = officCategory;
    }

    public RealmList<User> getUserPermitList() {
        return userPermitList;
    }

    public void setUserPermitList(RealmList<User> userPermitList) {
        this.userPermitList = userPermitList;
    }
}