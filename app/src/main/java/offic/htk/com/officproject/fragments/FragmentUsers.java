package offic.htk.com.officproject.fragments;

import android.content.Intent;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.activitis.AddNewCompanyActivity;
import offic.htk.com.officproject.activitis.MainActivity;
import offic.htk.com.officproject.base.BaseFragment;

/**
 * Created by nguyen on 02/08/2016.
 */
public class FragmentUsers extends BaseFragment implements View.OnClickListener {
    private FragmentTabHost fragmentTabHost;
    private Button mBtnAddYourFirstContacts;
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
        mBtnAddYourFirstContacts = (Button) view.findViewById(R.id.btn_add_new_contacts);
        mBtnAddYourFirstContacts.setOnClickListener(this);
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        mImgAddNewContacts = (ImageView) toolbar.findViewById(R.id.img_action_add);
        mTvEditProfile = (TextView) toolbar.findViewById(R.id.tv_action_edit);
        mImgAddNewContacts.setVisibility(View.VISIBLE);
        mTvEditProfile.setVisibility(View.GONE);
        mImgAddNewContacts.setOnClickListener(this);

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_create_your_first_contacts;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_new_contacts:
                createDialog();
                break;
            case R.id.img_action_add:
                break;
            default:
                break;
        }
    }

    private void createDialog() {
        TextView tvAddNewPerson, tvAddNewCompany, tvCancelDialog;
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View yourCustomView = inflater.inflate(R.layout.dialog_add_new, null);
        final AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setView(yourCustomView).create();
        tvAddNewPerson = (TextView) yourCustomView.findViewById(R.id.tv_add_new_person);
        tvAddNewCompany = (TextView) yourCustomView.findViewById(R.id.tv_add_new_company);
        tvCancelDialog = (TextView) yourCustomView.findViewById(R.id.tv_cancel_dialog);
        tvAddNewCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AddNewCompanyActivity.class));
            }
        });
        tvCancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(wlp);
        dialog.show();

    }
}
