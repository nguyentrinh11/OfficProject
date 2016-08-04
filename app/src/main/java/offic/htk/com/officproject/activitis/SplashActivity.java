package offic.htk.com.officproject.activitis;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.adapters.ListNameCompanyAdapter;
import offic.htk.com.officproject.base.BaseActivity;
import offic.htk.com.officproject.rest.UtilsRest;
import offic.htk.com.officproject.rest.method.APIInterface;
import offic.htk.com.officproject.rest.response.APIErrors;
import offic.htk.com.officproject.rest.response.ErrorUtils;
import offic.htk.com.officproject.rest.response.ListOrganizations.ListOrganizations;
import offic.htk.com.officproject.rest.response.ListOrganizations.Organization;
import offic.htk.com.officproject.rest.response.LogoutResponse;
import offic.htk.com.officproject.utils.SessionManager;
import offic.htk.com.officproject.utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends BaseActivity implements View.OnClickListener {
    private String TAG = "Splash Activity";
    private ListNameCompanyAdapter adapter;
    private List<Organization> mListCompanyResponse = new ArrayList<>();
    private RecyclerView recyclerView;
    private String token;
    private Button mBtnSignout;
    private SessionManager sessionManager;

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate() {

        sessionManager = new SessionManager(SplashActivity.this);
    }

    @Override
    protected void initComponents() {
        mBtnSignout = (Button) findViewById(R.id.btn_sign_out);
        recyclerView = (RecyclerView) findViewById(R.id.rc_list_company);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mBtnSignout.setOnClickListener(this);
        getListOrganizations();


    }


    private void getListOrganizations() {
        token = new SessionManager(this).getUserDetails().get(SessionManager.KEY_TOKEN);
        Log.d(TAG, "token " + token);
        APIInterface apiInterface = UtilsRest.getInterfaceServiceWithAuth();
        Call<ListOrganizations> listCompanyResponseCall = apiInterface.getListOrganizations(token);
        listCompanyResponseCall.enqueue(new Callback<ListOrganizations>() {
            @Override
            public void onResponse(Call<ListOrganizations> call, Response<ListOrganizations> response) {
                Log.d(TAG, "code " + response.code());
                if (response.isSuccessful() && response.errorBody() == null) {
                    mListCompanyResponse.clear();
                    if (response.body() != null) {
                        mListCompanyResponse.addAll(response.body().getResults());
                        Log.d(TAG, "size list company: " + mListCompanyResponse.size());
                        adapter = new ListNameCompanyAdapter(SplashActivity.this, mListCompanyResponse);
                        recyclerView.setAdapter(adapter);
                    }
                } else if (response.code() == 401) {
                    Utils.showToastShortString(SplashActivity.this, "Unauthorized");
                } else {
                    if (response.errorBody() != null) {
                        APIErrors error = ErrorUtils.parseError(response);
                        if (error != null)
                            Utils.showToastShortString(SplashActivity.this, error.getError_message());
                    }

                }
            }

            @Override
            public void onFailure(Call<ListOrganizations> call, Throwable t) {

            }


        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_out:
                if (!token.equals("")) {
                    requestLogoutApi(token);
                }
                return;
            default:
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
                    Utils.showToastShort(SplashActivity.this, R.string.splash_log_out_success);
                    sessionManager.logoutUser();
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    SplashActivity.this.finish();
                }
                if (response.errorBody() != null) {
                    Utils.showToastShort(SplashActivity.this, R.string.splash_log_out_failure);
                }

            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {
                Log.d("TAG:" + TAG, " onFailure ");
            }
        });
    }
}
