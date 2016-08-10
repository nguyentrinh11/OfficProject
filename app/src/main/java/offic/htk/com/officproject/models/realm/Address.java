package offic.htk.com.officproject.models.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Mai Trinh on 8/1/2016.
 */
public class Address extends RealmObject {

    String cdCity;
    String cdCountry;
    @PrimaryKey
    @Required
    String cdID;
    String cdLocation;
    String cdState;
    String cdStreet;
    String cdZip;
    Contact contact;

    public Address() {
    }

    public Address(String cdCity, String cdCountry, String cdID, String cdLocation, String cdState, String cdStreet, String cdZip, Contact contact) {
        this.cdCity = cdCity;
        this.cdCountry = cdCountry;
        this.cdID = cdID;
        this.cdLocation = cdLocation;
        this.cdState = cdState;
        this.cdStreet = cdStreet;
        this.cdZip = cdZip;
        this.contact = contact;
    }

    public String getCdCity() {
        return cdCity;
    }

    public void setCdCity(String cdCity) {
        this.cdCity = cdCity;
    }

    public String getCdCountry() {
        return cdCountry;
    }

    public void setCdCountry(String cdCountry) {
        this.cdCountry = cdCountry;
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

    public String getCdState() {
        return cdState;
    }

    public void setCdState(String cdState) {
        this.cdState = cdState;
    }

    public String getCdStreet() {
        return cdStreet;
    }

    public void setCdStreet(String cdStreet) {
        this.cdStreet = cdStreet;
    }

    public String getCdZip() {
        return cdZip;
    }

    public void setCdZip(String cdZip) {
        this.cdZip = cdZip;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}