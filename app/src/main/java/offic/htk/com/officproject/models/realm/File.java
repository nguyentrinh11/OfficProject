package offic.htk.com.officproject.models.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Mai Trinh on 8/1/2016.
 */
public class File extends RealmObject {

    String cdContentType;
    String cdCreateAt;
    @PrimaryKey
    @Required
    String cdID;
    String cdName;
    String PermidStatus;
    String cdThumbnailUrl;
    String cdUrl;
    Comment comment;
    Note note;

    public File() {
    }

    public File(String cdContentType, String cdCreateAt, String cdID, String cdName, String permidStatus, String cdThumbnailUrl, String cdUrl, Comment comment, Note note) {
        this.cdContentType = cdContentType;
        this.cdCreateAt = cdCreateAt;
        this.cdID = cdID;
        this.cdName = cdName;
        PermidStatus = permidStatus;
        this.cdThumbnailUrl = cdThumbnailUrl;
        this.cdUrl = cdUrl;
        this.comment = comment;
        this.note = note;
    }

    public String getCdContentType() {
        return cdContentType;
    }

    public void setCdContentType(String cdContentType) {
        this.cdContentType = cdContentType;
    }

    public String getCdCreateAt() {
        return cdCreateAt;
    }

    public void setCdCreateAt(String cdCreateAt) {
        this.cdCreateAt = cdCreateAt;
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

    public String getPermidStatus() {
        return PermidStatus;
    }

    public void setPermidStatus(String permidStatus) {
        PermidStatus = permidStatus;
    }

    public String getCdThumbnailUrl() {
        return cdThumbnailUrl;
    }

    public void setCdThumbnailUrl(String cdThumbnailUrl) {
        this.cdThumbnailUrl = cdThumbnailUrl;
    }

    public String getCdUrl() {
        return cdUrl;
    }

    public void setCdUrl(String cdUrl) {
        this.cdUrl = cdUrl;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
