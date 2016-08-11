package offic.htk.com.officproject.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.utils.FontUtils;

/**
 * Created by Mai Trinh on 8/8/2016.
 */
public class NewEditText extends EditText {
//    NewEditText et = NewEditText.this;
    String ttfName;

    //The image we are going to use for the Clear button
    private Drawable imgCloseButton = getResources().getDrawable(R.drawable.deletetag);

    public NewEditText(Context context) {
        super(context);
        init();
    }

    public NewEditText(Context context, AttributeSet attrs, int defStyle) {
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

    public NewEditText(Context context, AttributeSet attrs) {
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

    void init() {
        //set font for edittext
        setGravity(Gravity.CENTER_VERTICAL);
        if (null == this.ttfName) {
            this.ttfName = "helveticaneue.ttf";
        }
        try {
            setTypeface(FontUtils.getTypeface(getContext(), "fonts/" + this.ttfName));

        } catch (Exception e) {
        }

        // Set bounds of the Clear button so it will look ok
        imgCloseButton.setBounds(0, 0, imgCloseButton.getIntrinsicWidth(), imgCloseButton.getIntrinsicHeight());

        // There may be initial text in the field, so we may need to display the  button
        handleClearButton();

        //if the Close image is displayed and the user remove his finger from the button, clear it. Otherwise do nothing
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                NewEditText et = NewEditText.this;

                if (et.getCompoundDrawables()[2] == null)
                    return false;

                if (event.getAction() != MotionEvent.ACTION_UP)
                    return false;

                if (event.getX() > et.getWidth() - et.getPaddingRight() - imgCloseButton.getIntrinsicWidth()) {
                    et.setText("");
                    NewEditText.this.handleClearButton();
                }
                return false;
            }
        });

        this.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                NewEditText et = NewEditText.this;
                if (hasFocus && et.getText().toString().length() > 0){
                    Log.d("edit","image");
                    NewEditText.this.setCompoundDrawables(NewEditText.this.getCompoundDrawables()[0], NewEditText.this.getCompoundDrawables()[1], imgCloseButton, NewEditText.this.getCompoundDrawables()[3]);
                }
                else{
                    Log.d("edit","null");
                    NewEditText.this.setCompoundDrawables(NewEditText.this.getCompoundDrawables()[0], NewEditText.this.getCompoundDrawables()[1], null, NewEditText.this.getCompoundDrawables()[3]);
                }
            }
        });

        //if text changes, take care of the button
        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                NewEditText.this.handleClearButton();
            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
        });
    }

    //intercept Typeface change and set it with our custom font
    public void setTypeface(Typeface tf, int style) {
        if (style == Typeface.BOLD) {
            super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Vegur-B 0.602.otf"));
        } else {
            super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Vegur-R 0.602.otf"));
        }
    }

    void handleClearButton() {
        if (this.getText().toString().equals(""))
        {
            // add the clear button
            this.setCompoundDrawables(this.getCompoundDrawables()[0], this.getCompoundDrawables()[1], null, this.getCompoundDrawables()[3]);
        }
        else if(this.hasFocus())
        {
            //remove clear button
            this.setCompoundDrawables(this.getCompoundDrawables()[0], this.getCompoundDrawables()[1], imgCloseButton, this.getCompoundDrawables()[3]);
        }
    }

}