package offic.htk.com.officproject.activities;

import android.view.View;
import android.widget.TextView;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.base.BaseActivity;

public class EditProfileActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "EditProfileActivity";
    private TextView mTvCancelProfile, mTvDoneProfile;

    @Override
    protected void onCreate() {
    }

    @Override
    protected void initComponents() {
        mTvCancelProfile = (TextView) findViewById(R.id.tv_cancel_profile);
        mTvDoneProfile = (TextView) findViewById(R.id.tv_done_profile);
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
            case R.id.tv_cancel_profile:
                EditProfileActivity.this.finish();
                break;
            case R.id.tv_done_profile:
                break;
        }
    }
}
