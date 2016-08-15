package offic.htk.com.officproject.activitis;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.base.BaseActivity;

public class SynchroniseContactsActivity extends BaseActivity implements View.OnClickListener {
    private String TAG = "SynchroniseContactsActivity";
    private LinearLayout mToolbarSyncContacts;
    private TextView mTvBack, mTvTitle;
    private Switch mSwitchSyncContacts;


    @Override
    protected void onCreate() {

    }

    @Override
    protected void initComponents() {
        mToolbarSyncContacts = (LinearLayout) findViewById(R.id.toolbar_sync_contacts);
        mTvBack = (TextView) mToolbarSyncContacts.findViewById(R.id.tv_cancel);
        mTvTitle = (TextView) mToolbarSyncContacts.findViewById(R.id.tv_title);
        mSwitchSyncContacts = (Switch) findViewById(R.id.switch_sync_contacts);
        mTvTitle.setText("Contacts");
        mTvBack.setOnClickListener(this);
        mSwitchSyncContacts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, isChecked + "");
                if (isChecked) {
                    createDialog();
                } else {

                }
            }
        });
    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_synchronise_contacts;
    }

    private void createDialog() {
        TextView tvOk, tvDontAllow;
        LayoutInflater inflater = LayoutInflater.from(this);
        final View yourCustomView = inflater.inflate(R.layout.dialog_sync_contacts, null);

        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(yourCustomView).create();
        dialog.setCancelable(false);
        tvOk = (TextView) yourCustomView.findViewById(R.id.tv_ok);
        tvDontAllow = (TextView) yourCustomView.findViewById(R.id.tv_dont_allow);
        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tvDontAllow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwitchSyncContacts.setChecked(false);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                SynchroniseContactsActivity.this.finish();
                break;
        }
    }
}
