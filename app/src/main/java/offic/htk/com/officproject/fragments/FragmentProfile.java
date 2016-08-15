package offic.htk.com.officproject.fragments;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.activitis.EditProfileActivity;
import offic.htk.com.officproject.activitis.MainActivity;
import offic.htk.com.officproject.activitis.SettingsLanguageActivity;
import offic.htk.com.officproject.activitis.SynchroniseContactsActivity;
import offic.htk.com.officproject.base.BaseFragment;

/**
 * Created by nguyen on 02/08/2016.
 */
public class FragmentProfile extends BaseFragment implements View.OnClickListener {
    private String TAG = "FragmentProfile";
    private FragmentTabHost fragmentTabHost;
    private Toolbar toolbar;
    private TextView mTvEditProfile, mTvLanguage;
    private ImageView mImgAddNewContacts, mImgChooseLanguage, mImgSynchorinseContacts;

    @Override
    protected void onCreate() {
        MainActivity mainActivity = (MainActivity) getActivity();
        fragmentTabHost = mainActivity.getFragmentTabHost();
        fragmentTabHost.setVisibility(View.GONE);

    }

    @Override
    protected void initComponents(View view) {
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        mImgAddNewContacts = (ImageView) toolbar.findViewById(R.id.img_action_add);
        mTvEditProfile = (TextView) toolbar.findViewById(R.id.tv_action_edit);
        mImgChooseLanguage = (ImageView) view.findViewById(R.id.img_choose_language_profile);
        mImgSynchorinseContacts = (ImageView) view.findViewById(R.id.img_synchronise_contacts);
        mTvLanguage = (TextView) view.findViewById(R.id.tv_language);
        mImgAddNewContacts.setVisibility(View.GONE);
        mTvEditProfile.setVisibility(View.VISIBLE);
        mTvEditProfile.setOnClickListener(this);
        mImgChooseLanguage.setOnClickListener(this);
        mImgSynchorinseContacts.setOnClickListener(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_profile;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_action_edit:
                startActivity(new Intent(getContext(), EditProfileActivity.class));
                break;
            case R.id.img_choose_language_profile:
                Intent intent = new Intent(getContext(), SettingsLanguageActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.img_synchronise_contacts:
                startActivity(new Intent(getContext(), SynchroniseContactsActivity.class));
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String value = data.getStringExtra("value");
                Log.d(TAG, "value language : " + value);
                mTvLanguage.setText(value);
            } else {
            }
        }
    }
}
