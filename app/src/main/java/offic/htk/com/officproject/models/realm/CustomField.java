package offic.htk.com.officproject.models.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Mai Trinh on 8/1/2016.
 */
public class CustomField extends RealmObject{

    @PrimaryKey
    @Required
    String cdID;
    String cdValue;
    Contact contact;

    public CustomField() {
    }

    public CustomField(String cdID, String cdValue, Contact contact) {
        this.cdID = cdID;
        this.cdValue = cdValue;
        this.contact = contact;
    }

    public String getCdID() {
        return cdID;
    }

    public void setCdID(String cdID) {
        this.cdID = cdID;
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
