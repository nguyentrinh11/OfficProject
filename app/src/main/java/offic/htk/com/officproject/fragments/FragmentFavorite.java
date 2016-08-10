package offic.htk.com.officproject.fragments;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.base.BaseFragment;

/**
 * Created by nguyen on 02/08/2016.
 */
public class FragmentFavorite extends BaseFragment {
    private Toolbar toolbar;
    private ImageView mImgAddNewContacts;
    private TextView mTvEditProfile;

    @Override
    protected void onCreate() {

    }

    @Override
    protected void initComponents(View view) {
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        mImgAddNewContacts = (ImageView) toolbar.findViewById(R.id.img_action_add);
        mTvEditProfile = (TextView) toolbar.findViewById(R.id.tv_action_edit);
        mImgAddNewContacts.setVisibility(View.GONE);
        mTvEditProfile.setVisibility(View.GONE);

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_favorite;
    }
}
