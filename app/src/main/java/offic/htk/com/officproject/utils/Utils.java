package offic.htk.com.officproject.utils;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by nguyen on 28/07/2016.
 */
public class Utils {
    public static void showToastShort(AppCompatActivity appCompatActivity, int resId) {
        Toast.makeText(appCompatActivity, resId, Toast.LENGTH_SHORT).show();
    }

    public static void showToastShortString(AppCompatActivity appCompatActivity, String txt) {
        Toast.makeText(appCompatActivity, txt, Toast.LENGTH_SHORT).show();
    }


}
