package offic.htk.com.officproject.models;

/**
 * Created by nguyen on 12/08/2016.
 */
public class ChooseLanguage {
    private String name_language;
    private String title_language;
    private Boolean isChecked;

    public ChooseLanguage() {
    }

    public ChooseLanguage(String name_language, String title_language, Boolean isChecked) {
        this.name_language = name_language;
        this.title_language = title_language;
        this.isChecked = isChecked;
    }

    public String getName_language() {
        return name_language;
    }

    public void setName_language(String name_language) {
        this.name_language = name_language;
    }

    public String getTitle_language() {
        return title_language;
    }

    public void setTitle_language(String title_language) {
        this.title_language = title_language;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
}
