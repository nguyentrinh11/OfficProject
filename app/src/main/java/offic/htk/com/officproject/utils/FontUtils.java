package offic.htk.com.officproject.utils;

/**
 * Created by nguyen on 27/07/2016.
 */

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

public class FontUtils {

    private static Map<String, Typeface> ourCache = new HashMap<String, Typeface>();
    private static AssetManager ourAssetManager;

    public static Typeface getTypeface(Context context, String fontName) {
        if (!ourCache.containsKey(fontName)) {
            Typeface typeface = Typeface.createFromAsset(getAssetManager(context), fontName);
            ourCache.put(fontName, typeface);
        }
        return ourCache.get(fontName);
    }

    private static AssetManager getAssetManager(Context context) {
        if (ourAssetManager == null) {
            ourAssetManager = context.getAssets();
        }
        return ourAssetManager;
    }
}

