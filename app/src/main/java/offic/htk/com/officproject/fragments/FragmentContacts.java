package offic.htk.com.officproject.fragments;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.activitis.MainActivity;
import offic.htk.com.officproject.base.BaseFragment;

/**
 * Created by nguyen on 02/08/2016.
 */
public class FragmentContacts extends BaseFragment {
    private FragmentTabHost fragmentTabHost;

    @Override
    protected void onCreate() {
        MainActivity mainActivity = (MainActivity) getActivity();
        fragmentTabHost = mainActivity.getFragmentTabHost();
        fragmentTabHost.setVisibility(View.VISIBLE);

    }


    @Override
    protected void initComponents(View view) {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_contacts;
    }

    private void createDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View yourCustomView = inflater.inflate(R.layout.dialog_add_new, null);

//        final TextView etName = (EditText) yourCustomView.findViewById(R.id.EditZip);
        final AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setView(yourCustomView).create();
        dialog.show();
    }
}
