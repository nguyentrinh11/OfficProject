package offic.htk.com.officproject.models.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Mai Trinh on 8/1/2016.
 */
public class Tag extends RealmObject {

    @PrimaryKey
    @Required
    String cdID;
    String cdName;
    String cdSort;
    RealmList<Contact> contactList = new RealmList<>();

    public Tag() {
    }

    public Tag(String cdID, String cdName, String cdSort, RealmList<Contact> contactList) {
        this.cdID = cdID;
        this.cdName = cdName;
        this.cdSort = cdSort;
        this.contactList = contactList;
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

    public String getCdSort() {
        return cdSort;
    }

    public void setCdSort(String cdSort) {
        this.cdSort = cdSort;
    }

    public RealmList<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(RealmList<Contact> contactList) {
        this.contactList = contactList;
    }
}
