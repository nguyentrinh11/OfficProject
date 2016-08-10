package offic.htk.com.officproject.models.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Mai Trinh on 8/1/2016.
 */
public class Contact extends RealmObject {

    String cdAvartar;
    String cdBgInfo;
    String cdCompany;
    String cdCompanyBelong;
    String cdCreateAt;
    String cdCreateBy;
    String cdFacebook;
    boolean cdFavorites;
    @PrimaryKey
    @Required
    String cdID;
    String cdIm;
    String cdImgUpdateAt;
    String cdKind;
    String cdLastName;
    String Linkedin;
    String cdName;
    String cdNoteAt;
    String cdPermitStatus;
    String cdSort;
    String cdTitle;
    String cdTwitter;
    RealmList<Address> addressList = new RealmList<>();
    RealmList<Box> boxList = new RealmList<>();
    RealmList<CustomField> customFieldList = new RealmList<>();
    RealmList<Deal> dealList = new RealmList<>();
    RealmList<Email> emailList = new RealmList<>();
    RealmList<Group> groupList = new RealmList<>();
    RealmList<IM> imList = new RealmList<>();
    RealmList<Note> noteList = new RealmList<>();
    RealmList<Phone> phoneList = new RealmList<>();
    RealmList<Tag> tagList = new RealmList<>();
    RealmList<Task> taskList = new RealmList<>();
    RealmList<User> userList = new RealmList<>();
    RealmList<Website> websiteList = new RealmList<>();

    public Contact() {
    }

    public Contact(String cdAvartar, String cdBgInfo, String cdCompany, String cdCompanyBelong, String cdCreateAt, String cdCreateBy, String cdFacebook, boolean cdFavorites, String cdID, String cdIm, String cdImgUpdateAt, String cdKind, String cdLastName, String linkedin, String cdName, String cdNoteAt, String cdPermitStatus, String cdSort, String cdTitle, String cdTwitter, RealmList<Address> addressList, RealmList<Box> boxList, RealmList<CustomField> customFieldList, RealmList<Deal> dealList, RealmList<Email> emailList, RealmList<Group> groupList, RealmList<IM> imList, RealmList<Note> noteList, RealmList<Phone> phoneList, RealmList<Tag> tagList, RealmList<Task> taskList, RealmList<User> userList, RealmList<Website> websiteList) {
        this.cdAvartar = cdAvartar;
        this.cdBgInfo = cdBgInfo;
        this.cdCompany = cdCompany;
        this.cdCompanyBelong = cdCompanyBelong;
        this.cdCreateAt = cdCreateAt;
        this.cdCreateBy = cdCreateBy;
        this.cdFacebook = cdFacebook;
        this.cdFavorites = cdFavorites;
        this.cdID = cdID;
        this.cdIm = cdIm;
        this.cdImgUpdateAt = cdImgUpdateAt;
        this.cdKind = cdKind;
        this.cdLastName = cdLastName;
        Linkedin = linkedin;
        this.cdName = cdName;
        this.cdNoteAt = cdNoteAt;
        this.cdPermitStatus = cdPermitStatus;
        this.cdSort = cdSort;
        this.cdTitle = cdTitle;
        this.cdTwitter = cdTwitter;
        this.addressList = addressList;
        this.boxList = boxList;
        this.customFieldList = customFieldList;
        this.dealList = dealList;
        this.emailList = emailList;
        this.groupList = groupList;
        this.imList = imList;
        this.noteList = noteList;
        this.phoneList = phoneList;
        this.tagList = tagList;
        this.taskList = taskList;
        this.userList = userList;
        this.websiteList = websiteList;
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

    public String getCdCompany() {
        return cdCompany;
    }

    public void setCdCompany(String cdCompany) {
        this.cdCompany = cdCompany;
    }

    public String getCdCompanyBelong() {
        return cdCompanyBelong;
    }

    public void setCdCompanyBelong(String cdCompanyBelong) {
        this.cdCompanyBelong = cdCompanyBelong;
    }

    public String getCdCreateAt() {
        return cdCreateAt;
    }

    public void setCdCreateAt(String cdCreateAt) {
        this.cdCreateAt = cdCreateAt;
    }

    public String getCdCreateBy() {
        return cdCreateBy;
    }

    public void setCdCreateBy(String cdCreateBy) {
        this.cdCreateBy = cdCreateBy;
    }

    public String getCdFacebook() {
        return cdFacebook;
    }

    public void setCdFacebook(String cdFacebook) {
        this.cdFacebook = cdFacebook;
    }

    public boolean isCdFavorites() {
        return cdFavorites;
    }

    public void setCdFavorites(boolean cdFavorites) {
        this.cdFavorites = cdFavorites;
    }

    public String getCdID() {
        return cdID;
    }

    public void setCdID(String cdID) {
        this.cdID = cdID;
    }

    public String getCdIm() {
        return cdIm;
    }

    public void setCdIm(String cdIm) {
        this.cdIm = cdIm;
    }

    public String getCdImgUpdateAt() {
        return cdImgUpdateAt;
    }

    public void setCdImgUpdateAt(String cdImgUpdateAt) {
        this.cdImgUpdateAt = cdImgUpdateAt;
    }

    public String getCdKind() {
        return cdKind;
    }

    public void setCdKind(String cdKind) {
        this.cdKind = cdKind;
    }

    public String getCdLastName() {
        return cdLastName;
    }

    public void setCdLastName(String cdLastName) {
        this.cdLastName = cdLastName;
    }

    public String getLinkedin() {
        return Linkedin;
    }

    public void setLinkedin(String linkedin) {
        Linkedin = linkedin;
    }

    public String getCdName() {
        return cdName;
    }

    public void setCdName(String cdName) {
        this.cdName = cdName;
    }

    public String getCdNoteAt() {
        return cdNoteAt;
    }

    public void setCdNoteAt(String cdNoteAt) {
        this.cdNoteAt = cdNoteAt;
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

    public String getCdTitle() {
        return cdTitle;
    }

    public void setCdTitle(String cdTitle) {
        this.cdTitle = cdTitle;
    }

    public String getCdTwitter() {
        return cdTwitter;
    }

    public void setCdTwitter(String cdTwitter) {
        this.cdTwitter = cdTwitter;
    }

    public RealmList<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(RealmList<Address> addressList) {
        this.addressList = addressList;
    }

    public RealmList<Box> getBoxList() {
        return boxList;
    }

    public void setBoxList(RealmList<Box> boxList) {
        this.boxList = boxList;
    }

    public RealmList<CustomField> getCustomFieldList() {
        return customFieldList;
    }

    public void setCustomFieldList(RealmList<CustomField> customFieldList) {
        this.customFieldList = customFieldList;
    }

    public RealmList<Deal> getDealList() {
        return dealList;
    }

    public void setDealList(RealmList<Deal> dealList) {
        this.dealList = dealList;
    }

    public RealmList<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(RealmList<Email> emailList) {
        this.emailList = emailList;
    }

    public RealmList<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(RealmList<Group> groupList) {
        this.groupList = groupList;
    }

    public RealmList<IM> getImList() {
        return imList;
    }

    public void setImList(RealmList<IM> imList) {
        this.imList = imList;
    }

    public RealmList<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(RealmList<Note> noteList) {
        this.noteList = noteList;
    }

    public RealmList<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(RealmList<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public RealmList<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(RealmList<Tag> tagList) {
        this.tagList = tagList;
    }

    public RealmList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(RealmList<Task> taskList) {
        this.taskList = taskList;
    }

    public RealmList<User> getUserList() {
        return userList;
    }

    public void setUserList(RealmList<User> userList) {
        this.userList = userList;
    }

    public RealmList<Website> getWebsiteList() {
        return websiteList;
    }

    public void setWebsiteList(RealmList<Website> websiteList) {
        this.websiteList = websiteList;
    }
}