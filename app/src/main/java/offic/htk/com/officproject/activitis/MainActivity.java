package offic.htk.com.officproject.activitis;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.adapters.MenuAdapter;
import offic.htk.com.officproject.base.BaseActivity;
import offic.htk.com.officproject.fragments.FragmentContacts;
import offic.htk.com.officproject.fragments.FragmentFavorite;
import offic.htk.com.officproject.fragments.FragmentGroups;
import offic.htk.com.officproject.fragments.FragmentProfile;
import offic.htk.com.officproject.fragments.FragmentSettings;
import offic.htk.com.officproject.fragments.FragmentTags;
import offic.htk.com.officproject.fragments.FragmentUsers;
import offic.htk.com.officproject.models.UserInfo;
import offic.htk.com.officproject.rest.UtilsRest;
import offic.htk.com.officproject.rest.method.APIInterface;
import offic.htk.com.officproject.rest.response.LogoutResponse;
import offic.htk.com.officproject.utils.SessionManager;
import offic.htk.com.officproject.utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements SlidingPaneLayout.PanelSlideListener, View.OnClickListener {
    private ListView leftListView;
    private MenuAdapter adapter;
    private List<String> mList = new ArrayList<>();
    private String TAG = MainActivity.class.getSimpleName();
    private Toolbar toolbar;
    private UserInfo userInfo = new UserInfo();
    private ImageView imgMenu;
    private SlidingPaneLayout slidingPaneLayout;
    private TextView tvDetails;
    private FrameLayout fmMain;
    private FragmentTabHost mTabHost;
    private SessionManager sessionManager;
    private String token;
    private String[] listName;

    @Override
    protected void onCreate() {
        sessionManager = new SessionManager(MainActivity.this);
        token = new SessionManager(this).getUserDetails().get(SessionManager.KEY_TOKEN);
        Log.d(TAG, "token " + token);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        userInfo.setUsername("Van Trinh");
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.main_list);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab1").setIndicator(null, getResources().getDrawable(R.drawable.my_selector_contact)),
                FragmentContacts.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab2").setIndicator(null, getResources().getDrawable(R.drawable.my_selector_bookmarks)),
                FragmentFavorite.class, null);
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if ("tab1".equals(tabId)) {
                    replaceFragment(R.id.main_list, new FragmentContacts(), false);
                }
                if ("tab2".equals(tabId)) {
                    replaceFragment(R.id.main_list, new FragmentFavorite(), false);
                }
            }
        });
        for (int i = 0; i < 2; i++) {
            mTabHost.getTabWidget().getChildAt(i).getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
        }

    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComponents() {
        int[] listImage = {R.drawable.menu_contacts, R.drawable.menu_user, R.drawable.menu_tags, R.drawable.menu_groups, R.drawable.menu_settings, R.drawable.menu_switch_company, R.drawable.menu_logout};
        listName = getResources().getStringArray(R.array.content);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fmMain = (FrameLayout) findViewById(R.id.main_list);
        tvDetails = (TextView) findViewById(R.id.tv_details);
        imgMenu = (ImageView) findViewById(R.id.img_menu);
        imgMenu.setOnClickListener(this);
        leftListView = (ListView) findViewById(R.id.left_list);
        for (int i = 0; i < 9; i++) {
            mList.add(String.valueOf(i));
        }
        adapter = new MenuAdapter(MainActivity.this, mList, userInfo, "Mit", listImage, listName);
        leftListView.setAdapter(adapter);

        slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.sliding_pane_layout);
        assert slidingPaneLayout != null;
        slidingPaneLayout.setPanelSlideListener(this);
        slidingPaneLayout.setSliderFadeColor(Color.TRANSPARENT);
        leftListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
                switch (position) {
                    case 1:
                        replaceFragment(R.id.main_list, new FragmentProfile(), false);
                        tvDetails.setText("Details User");
                        parent.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        for (int i = 2; i < 9; i++) {
                            parent.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.navigation_bg_listview));
                        }

                        slidingPaneLayout.closePane();
                        break;
                    case 2:
                        replaceFragment(R.id.main_list, new FragmentContacts(), false);
                        tvDetails.setText("All Contacts");
                        parent.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.navigation_bg_item_avatar));
                        parent.getChildAt(2).setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        for (int i = 3; i < 9; i++) {
                            parent.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.navigation_bg_listview));
                        }
                        slidingPaneLayout.closePane();
                        break;
                    case 3:
                        replaceFragment(R.id.main_list, new FragmentUsers(), false);
                        tvDetails.setText("Users");
                        parent.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.navigation_bg_item_avatar));
                        parent.getChildAt(2).setBackgroundColor(getResources().getColor(R.color.navigation_bg_listview));
                        parent.getChildAt(3).setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        for (int i = 4; i < 9; i++) {
                            parent.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.navigation_bg_listview));
                        }
                        slidingPaneLayout.closePane();
                        break;
                    case 4:
                        replaceFragment(R.id.main_list, new FragmentTags(), false);
                        tvDetails.setText("Tags");
                        parent.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.navigation_bg_item_avatar));
                        for (int i = 2; i < 4; i++) {
                            parent.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.navigation_bg_listview));
                        }
                        parent.getChildAt(4).setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        for (int i = 5; i < 9; i++) {
                            parent.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.navigation_bg_listview));
                        }
                        slidingPaneLayout.closePane();
                        break;
                    case 5:
                        replaceFragment(R.id.main_list, new FragmentGroups(), false);
                        tvDetails.setText("Groups");
                        parent.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.navigation_bg_item_avatar));
                        for (int i = 2; i < 5; i++) {
                            parent.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.navigation_bg_listview));
                        }
                        parent.getChildAt(5).setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        for (int i = 6; i < 9; i++) {
                            parent.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.navigation_bg_listview));
                        }
                        slidingPaneLayout.closePane();
                        break;
                    case 6:
                        replaceFragment(R.id.main_list, new FragmentSettings(), false);
                        tvDetails.setText("Settings");
                        parent.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.navigation_bg_item_avatar));
                        for (int i = 2; i < 6; i++) {
                            parent.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.navigation_bg_listview));
                        }
                        parent.getChildAt(6).setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        for (int i = 7; i < 9; i++) {
                            parent.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.navigation_bg_listview));
                        }
                        slidingPaneLayout.closePane();
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this, SplashActivity.class));
                        tvDetails.setText("Swich company");
                        parent.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.navigation_bg_item_avatar));
                        for (int i = 2; i < 7; i++) {
                            parent.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.navigation_bg_listview));
                        }
                        parent.getChildAt(7).setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        for (int i = 8; i < 9; i++) {
                            parent.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.navigation_bg_listview));
                        }
                        slidingPaneLayout.closePane();
                        break;
                    case 8:
                        if (!token.equals("")) {
                            requestLogoutApi(token);
                        }
                        slidingPaneLayout.closePane();
                        return;
                    default:
                        break;
                }
            }
        });

    }


    @Override
    public void onPanelSlide(View panel, float slideOffset) {
    }

    @Override
    public void onPanelOpened(View panel) {
    }

    @Override
    public void onPanelClosed(View panel) {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_menu:
                slidingPaneLayout.openPane();
                break;
        }
    }

    private void requestLogoutApi(String token) {
        APIInterface apiInterface = UtilsRest.getInterfaceServiceWithAuth();
        Call<LogoutResponse> logoutResponseCall = apiInterface.getMessageLogout(token);
        logoutResponseCall.enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                Log.d(TAG, "logout code: " + response.code());
                if (response.isSuccessful() && response.errorBody() == null) {
                    Utils.showToastShort(MainActivity.this, R.string.splash_log_out_success);
                    sessionManager.logoutUser();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    MainActivity.this.finish();
                }
                if (response.errorBody() != null) {
                    Utils.showToastShort(MainActivity.this, R.string.splash_log_out_failure);
                }

            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {
                Log.d("TAG:" + TAG, " onFailure ");
            }
        });
    }

    public FragmentTabHost getFragmentTabHost() {
        return (FragmentTabHost) findViewById(android.R.id.tabhost);
    }

}
