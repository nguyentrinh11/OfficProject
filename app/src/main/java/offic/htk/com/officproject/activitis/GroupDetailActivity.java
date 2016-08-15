package offic.htk.com.officproject.activitis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.base.BaseActivity;

public class GroupDetailActivity extends BaseActivity implements View.OnClickListener {
    private String TAG = "GroupDetailActivity";
    private TextView mTvBack, mTvTitle, mTvNameGroup;
    private LinearLayout mToolbarGroupDetail;
    private String mGroupName;

    @Override
    protected void onCreate() {
        Intent intent = getIntent();
        mGroupName = intent.getStringExtra("groupname");
    }

    @Override
    protected void initComponents() {
        mToolbarGroupDetail = (LinearLayout) findViewById(R.id.toolbar_group_detail);
        mTvBack = (TextView) mToolbarGroupDetail.findViewById(R.id.tv_cancel);
        mTvTitle = (TextView) mToolbarGroupDetail.findViewById(R.id.tv_title);
        mTvNameGroup = (TextView) findViewById(R.id.tv_name_group);
        mTvNameGroup.setText(mGroupName);
        mTvTitle.setText("Group detail");
        mTvBack.setOnClickListener(this);

    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_group_detail;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                GroupDetailActivity.this.finish();
                break;
        }
    }
}
