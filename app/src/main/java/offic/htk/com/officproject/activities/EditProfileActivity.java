package offic.htk.com.officproject.activities;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.base.BaseActivity;

public class EditProfileActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "EditProfileActivity";
    private TextView mTvCancelProfile, mTvDoneProfile, mTvTitle;
    private LinearLayout mToolbarEditProfile;

    @Override
    protected void onCreate() {
    }

    @Override
    protected void initComponents() {
        mToolbarEditProfile = (LinearLayout) findViewById(R.id.toolbar_edit_profile);
        mTvCancelProfile = (TextView) mToolbarEditProfile.findViewById(R.id.tv_cancel);
        mTvDoneProfile = (TextView) mToolbarEditProfile.findViewById(R.id.tv_done);
        mTvTitle = (TextView) mToolbarEditProfile.findViewById(R.id.tv_title);
        mTvTitle.setText("Edit");
        mTvCancelProfile.setOnClickListener(this);
        mTvDoneProfile.setOnClickListener(this);

    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_edit_profile;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                EditProfileActivity.this.finish();
                break;
            case R.id.tv_done:
                break;
        }
    }
}
