package offic.htk.com.officproject.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.utils.FontUtils;

public class CustomFontTextView extends TextView {
    public CustomFontTextView(Context context) {
        super(context);
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.TextFont, defStyle, 0);
        fontName = a.getString(R.styleable.TextFont_font);
        init();
        try {
            a.recycle();
        } catch (Exception ex) {
        }
    }

    String fontName = null;

    private void init() {
        if (fontName != null) {
            try {
                setTypeface(FontUtils.getTypeface(getContext(), "fonts/"
                        + this.fontName));
            } catch (Exception e) {
            }
        }
    }
}