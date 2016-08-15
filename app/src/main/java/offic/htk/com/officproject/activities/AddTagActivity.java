package offic.htk.com.officproject.activities;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.tagview.OnTagClickListener;
import offic.htk.com.officproject.tagview.OnTagDeleteListener;
import offic.htk.com.officproject.tagview.Tag;
import offic.htk.com.officproject.tagview.TagView;
import offic.htk.com.officproject.base.BaseActivity;
import offic.htk.com.officproject.utils.Utils;

public class AddTagActivity extends BaseActivity implements View.OnClickListener {

    private static String TAG = "AddTagActivity";
    private TagView tagView;
    private EditText editText;
    private TextView mTvCancel, mTvDone;
    private LinearLayout mToolbarAddTag;

    @Override
    protected void onCreate() {

    }

    @Override
    protected void initComponents() {
        findViewById(R.id.ln_add_tags).setOnClickListener(this);
        mToolbarAddTag = (LinearLayout) findViewById(R.id.toolbar_add_tags);
        mTvCancel = (TextView) mToolbarAddTag.findViewById(R.id.tv_cancel);
        mTvDone = (TextView) mToolbarAddTag.findViewById(R.id.tv_done);
        mTvCancel.setOnClickListener(this);
        mTvDone.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.edt_add_tags);
        tagView = (TagView) this.findViewById(R.id.tagview);
        tagView.setOnTagClickListener(new OnTagClickListener() {

            @Override
            public void onTagClick(int position, Tag tag) {
                Toast.makeText(AddTagActivity.this, "click tag id = " + tag.id + " position = " + position, Toast.LENGTH_SHORT).show();
            }
        });
        tagView.setOnTagDeleteListener(new OnTagDeleteListener() {

            @Override
            public void onTagDeleted(int position, Tag tag) {
                Toast.makeText(AddTagActivity.this, "delete tag id = " + tag.id + " position =" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_add_tag;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ln_add_tags:
                addNewTag();
                break;
            case R.id.tv_cancel:
                AddTagActivity.this.finish();
                break;
            case R.id.tv_done:
                for (int i = 0; i < tagView.getChildCount(); i++) {
                    Log.d(TAG, "list tags:" + tagView.getTags().get(i).text);
                }

                break;
            default:
                break;

        }
    }

    private void addNewTag() {
        String tag_new = editText.getText().toString().trim();
        if (tag_new.equals("")) {
            Utils.showToastShort(AddTagActivity.this, R.string.error_add_tags);
        } else {
            Tag tag = new Tag(tag_new);
            tag.isDeletable = true;
            tag.layoutBorderSize = 1f;
            tag.tagTextColor = Color.parseColor(AddTagActivity.this.getResources().getStringArray(R.array.colors)[2]);
            tag.layoutColor = Color.parseColor(AddTagActivity.this.getResources().getStringArray(R.array.colors)[0]);
            tag.layoutBorderColor = Color.parseColor(AddTagActivity.this.getResources().getStringArray(R.array.colors)[1]);
            tag.layoutColorPress = Color.parseColor(AddTagActivity.this.getResources().getStringArray(R.array.colors)[0]);
            tagView.addTag(tag);
            editText.setText("");
        }
    }
}
