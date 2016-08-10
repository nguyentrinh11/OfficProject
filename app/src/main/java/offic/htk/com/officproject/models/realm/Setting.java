package offic.htk.com.officproject.models.realm;

import io.realm.RealmObject;

/**
 * Created by Mai Trinh on 8/1/2016.
 */
public class Setting extends RealmObject{

    String cdDueTaskNotify;
    String cdls24Hour;
    String cdLanguage;
    String cdTimezome;
    String cdTodayTaskNotify;

    public Setting() {
    }

    public Setting(String cdDueTaskNotify, String cdls24Hour, String cdLanguage, String cdTimezome, String cdTodayTaskNotify) {
        this.cdDueTaskNotify = cdDueTaskNotify;
        this.cdls24Hour = cdls24Hour;
        this.cdLanguage = cdLanguage;
        this.cdTimezome = cdTimezome;
        this.cdTodayTaskNotify = cdTodayTaskNotify;
    }

    public String getCdDueTaskNotify() {
        return cdDueTaskNotify;
    }

    public void setCdDueTaskNotify(String cdDueTaskNotify) {
        this.cdDueTaskNotify = cdDueTaskNotify;
    }

    public String getCdls24Hour() {
        return cdls24Hour;
    }

    public void setCdls24Hour(String cdls24Hour) {
        this.cdls24Hour = cdls24Hour;
    }

    public String getCdLanguage() {
        return cdLanguage;
    }

    public void setCdLanguage(String cdLanguage) {
        this.cdLanguage = cdLanguage;
    }

    public String getCdTimezome() {
        return cdTimezome;
    }

    public void setCdTimezome(String cdTimezome) {
        this.cdTimezome = cdTimezome;
    }

    public String getCdTodayTaskNotify() {
        return cdTodayTaskNotify;
    }

    public void setCdTodayTaskNotify(String cdTodayTaskNotify) {
        this.cdTodayTaskNotify = cdTodayTaskNotify;
    }
}
