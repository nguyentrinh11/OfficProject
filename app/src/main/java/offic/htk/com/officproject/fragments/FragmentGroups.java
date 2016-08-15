package offic.htk.com.officproject.fragments;

import android.content.Intent;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.swipe.util.Attributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.activities.AddNewGroupActivity;
import offic.htk.com.officproject.activities.MainActivity;
import offic.htk.com.officproject.adapters.CustomSwipeGroupsAdapter;
import offic.htk.com.officproject.base.BaseFragment;
import offic.htk.com.officproject.utils.RecyclerViewDividerItemDecoration;

/**
 * Created by nguyen on 02/08/2016.
 */
public class FragmentGroups extends BaseFragment implements View.OnClickListener {
    private FragmentTabHost fragmentTabHost;
    private Toolbar toolbar;
    private TextView mTvEditProfile;
    private ImageView mImgAddNewContacts;
    private Button mBtnAddNewGroup;
    private RecyclerView recyclerView;
    private List<String> mListGroups;

    @Override
    protected void onCreate() {
        MainActivity mainActivity = (MainActivity) getActivity();
        fragmentTabHost = mainActivity.getFragmentTabHost();
        fragmentTabHost.setVisibility(View.GONE);
    }

    @Override
    protected void initComponents(View view) {
        mListGroups = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.rc_list_groups);
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        mImgAddNewContacts = (ImageView) toolbar.findViewById(R.id.img_action_add);
        mImgAddNewContacts.setVisibility(View.VISIBLE);
        mTvEditProfile = (TextView) toolbar.findViewById(R.id.tv_action_edit);
//        mBtnAddNewGroup = (Button) view.findViewById(R.id.btn_create_your_first_groups);
        mTvEditProfile.setVisibility(View.GONE);
        mImgAddNewContacts.setOnClickListener(this);
//        mBtnAddNewGroup.setOnClickListener(this);
        setUpListGroups();
    }

    private void setUpListGroups() {
        for (int i = 0; i < 20; i++) {
            mListGroups.add("Nguyen Trinh");
        }
        Collections.sort(mListGroups, new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.compareToIgnoreCase(rhs);
            }

        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new RecyclerViewDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        CustomSwipeGroupsAdapter adapter = new CustomSwipeGroupsAdapter(getContext(), mListGroups);
        ((CustomSwipeGroupsAdapter) adapter).setMode(Attributes.Mode.Single);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_groups;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_action_add:
                startActivity(new Intent(getContext(), AddNewGroupActivity.class));
                break;
//            case R.id.btn_create_your_first_groups:
//                Intent intent = new Intent(getContext(), ChooseCountryActivity.class);
//                intent.putExtra("type", "3");
//                startActivity(intent);
//                break;
        }
    }
}
