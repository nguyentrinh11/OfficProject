package offic.htk.com.officproject.models;

/**
 * Created by nguyen on 04/08/2016.
 */
public class Choose {
    public Choose() {
    }

    private String name_choose;
    private Boolean isChecked;

    public Choose(String name_choose, Boolean isChecked) {
        this.name_choose = name_choose;
        this.isChecked = isChecked;
    }

    public String getName_choose() {
        return name_choose;
    }

    public void setName_choose(String name_choose) {
        this.name_choose = name_choose;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
}
