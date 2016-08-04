package offic.htk.com.officproject.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.utils.FontUtils;

public class CustomFontEditText extends EditText {
    String ttfName;

    public CustomFontEditText(Context context) {
        super(context);
        init();
    }

    public CustomFontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.TextFont, 0, 0);
        ttfName = a.getString(R.styleable.TextFont_font);
        init();
        try {
            a.recycle();
        } catch (Exception ex) {
        }
        init();
    }

    public CustomFontEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.TextFont, defStyle, 0);
        ttfName = a.getString(R.styleable.TextFont_font);
        init();
        try {
            a.recycle();
        } catch (Exception ex) {
        }
        init();
    }


    private void init() {
        setGravity(Gravity.CENTER_VERTICAL);
        if (null == this.ttfName) {
            this.ttfName = "helveticaneue.ttf";
        }
        try {
            setTypeface(FontUtils.getTypeface(getContext(), "fonts/" + this.ttfName));

        } catch (Exception e) {
        }
    }
}