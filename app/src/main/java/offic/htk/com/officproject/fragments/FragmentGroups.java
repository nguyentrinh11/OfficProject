package offic.htk.com.officproject.fragments;

import android.content.Intent;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.activitis.AddNewGroupActivity;
import offic.htk.com.officproject.activitis.AddTypeActivity;
import offic.htk.com.officproject.activitis.ChooseCountryActivity;
import offic.htk.com.officproject.activitis.MainActivity;
import offic.htk.com.officproject.base.BaseFragment;

/**
 * Created by nguyen on 02/08/2016.
 */
public class FragmentGroups extends BaseFragment implements View.OnClickListener {
    private FragmentTabHost fragmentTabHost;
    private Toolbar toolbar;
    private TextView mTvEditProfile;
    private ImageView mImgAddNewContacts;
    private Button mBtnAddNewGroup;

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
        mImgAddNewContacts.setVisibility(View.VISIBLE);
        mTvEditProfile = (TextView) toolbar.findViewById(R.id.tv_action_edit);
        mBtnAddNewGroup = (Button) view.findViewById(R.id.btn_create_your_first_groups);
        mTvEditProfile.setVisibility(View.GONE);
        mImgAddNewContacts.setOnClickListener(this);
        mBtnAddNewGroup.setOnClickListener(this);

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_create_your_first_groups;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_action_add:
                startActivity(new Intent(getContext(), AddNewGroupActivity.class));
                break;
            case R.id.btn_create_your_first_groups:
                Intent intent = new Intent(getContext(), ChooseCountryActivity.class);
                intent.putExtra("type", "3");
                startActivity(intent);
                break;
        }
    }
}
