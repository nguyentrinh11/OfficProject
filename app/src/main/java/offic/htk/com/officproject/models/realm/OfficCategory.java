package offic.htk.com.officproject.models.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by Mai Trinh on 8/1/2016.
 */
public class OfficCategory extends RealmObject {

    String cdColor;
    @Required
    String cdCompanyID;
    @Required
    String cdID;
    String cdName;
    RealmList<Task> taskList = new RealmList<>();

    public OfficCategory() {
    }

    public OfficCategory(String cdColor, String cdCompanyID, String cdID, String cdName, RealmList<Task> taskList) {
        this.cdColor = cdColor;
        this.cdCompanyID = cdCompanyID;
        this.cdID = cdID;
        this.cdName = cdName;
        this.taskList = taskList;
    }

    public String getCdColor() {
        return cdColor;
    }

    public void setCdColor(String cdColor) {
        this.cdColor = cdColor;
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

    public RealmList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(RealmList<Task> taskList) {
        this.taskList = taskList;
    }
}