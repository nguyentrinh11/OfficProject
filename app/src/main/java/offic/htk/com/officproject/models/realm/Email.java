package offic.htk.com.officproject.models.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Mai Trinh on 8/1/2016.
 */
public class Email extends RealmObject {

    @PrimaryKey
    @Required
    String cdID;
    String cdLocation;
    String cdValue;
    Contact contact;

    public Email() {
    }

    public Email(String cdID, String cdLocation, String cdValue, Contact contact) {
        this.cdID = cdID;
        this.cdLocation = cdLocation;
        this.cdValue = cdValue;
        this.contact = contact;
    }

    public String getCdID() {
        return cdID;
    }

    public void setCdID(String cdID) {
        this.cdID = cdID;
    }

    public String getCdLocation() {
        return cdLocation;
    }

    public void setCdLocation(String cdLocation) {
        this.cdLocation = cdLocation;
    }

    public String getCdValue() {
        return cdValue;
    }

    public void setCdValue(String cdValue) {
        this.cdValue = cdValue;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
