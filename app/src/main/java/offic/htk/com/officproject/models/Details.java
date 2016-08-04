package offic.htk.com.officproject.models;

import android.widget.ImageView;

/**
 * Created by nguyen on 02/08/2016.
 */
public class Details {
    private int imgDetais;
    private String tvDetais;

    public Details(int imgDetais, String tvDetais) {
        this.imgDetais = imgDetais;
        this.tvDetais = tvDetais;
    }

    public Details() {
    }

    public int getImgDetais() {
        return imgDetais;
    }

    public void setImgDetais(int imgDetais) {
        this.imgDetais = imgDetais;
    }

    public String getTvDetais() {
        return tvDetais;
    }

    public void setTvDetais(String tvDetais) {
        this.tvDetais = tvDetais;
    }
}
