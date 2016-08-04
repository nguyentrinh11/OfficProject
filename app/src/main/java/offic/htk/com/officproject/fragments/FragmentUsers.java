package offic.htk.com.officproject.fragments;

import android.support.v4.app.FragmentTabHost;
import android.view.View;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.activitis.MainActivity;
import offic.htk.com.officproject.base.BaseFragment;

/**
 * Created by nguyen on 02/08/2016.
 */
public class FragmentUsers extends BaseFragment {
    private FragmentTabHost fragmentTabHost;

    @Override
    protected void onCreate() {
        MainActivity mainActivity = (MainActivity) getActivity();
        fragmentTabHost = mainActivity.getFragmentTabHost();
        fragmentTabHost.setVisibility(View.GONE);
    }

    @Override
    protected void initComponents(View view) {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_users;
    }
}
