package offic.htk.com.officproject.fragments;

import android.content.Intent;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.activitis.AddTagActivity;
import offic.htk.com.officproject.activitis.MainActivity;
import offic.htk.com.officproject.base.BaseFragment;

/**
 * Created by nguyen on 02/08/2016.
 */
public class FragmentTags extends BaseFragment implements View.OnClickListener {
    private FragmentTabHost fragmentTabHost;
    private Toolbar toolbar;
    private ImageView mImgAddNewContacts;
    private TextView mTvEditProfile;

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
        mImgAddNewContacts.setVisibility(View.VISIBLE);
        mTvEditProfile.setVisibility(View.GONE);
        mImgAddNewContacts.setOnClickListener(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_tags;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_action_add:
                startActivity(new Intent(getContext(), AddTagActivity.class));
                break;
        }
    }
}
