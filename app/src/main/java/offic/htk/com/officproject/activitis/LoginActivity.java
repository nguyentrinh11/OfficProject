package offic.htk.com.officproject.activitis;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import offic.htk.com.officproject.R;
import offic.htk.com.officproject.base.BaseActivity;
import offic.htk.com.officproject.models.login.User;
import offic.htk.com.officproject.rest.UtilsRest;
import offic.htk.com.officproject.rest.method.APIInterface;
import offic.htk.com.officproject.rest.response.APIErrors;
import offic.htk.com.officproject.rest.response.ErrorUtils;
import offic.htk.com.officproject.rest.response.LoginResponse;
import offic.htk.com.officproject.utils.SessionManager;
import offic.htk.com.officproject.utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private String TAG = "Login Activity";
    private TextView mTvErrorLogin, mTvForgotPassWord, mTvSignUp;
    private EditText mEdtUserName, mEdtPassWord;
    private Button mBtnLogin;
    private SessionManager mSessionManager;


    @Override
    protected void onCreate() {
        mSessionManager = new SessionManager(getApplicationContext());
        mSessionManager.checkLogin();
    }

    @Override
    protected void initComponents() {
        mTvErrorLogin = (TextView) findViewById(R.id.tv_error_login);
        mTvForgotPassWord = (TextView) findViewById(R.id.tv_forgot_password);
        mTvSignUp = (TextView) findViewById(R.id.tv_sign_up);
        mEdtUserName = (EditText) findViewById(R.id.edt_username);
        mEdtPassWord = (EditText) findViewById(R.id.edt_password);
        mBtnLogin = (Button) findViewById(R.id.btn_sign_in);
        mBtnLogin.setOnClickListener(this);
        mTvSignUp.setOnClickListener(this);
        mTvForgotPassWord.setOnClickListener(this);
    }

    private void getInfoLogin() {
        String username = mEdtUserName.getText().toString().trim();
        String password = mEdtPassWord.getText().toString().trim();
        if (kiemTraThongTin(username, password)) {
            APIInterface apiInterface = UtilsRest.getInterfaceService();
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            Call<LoginResponse> responseCall = apiInterface.authenticateLogin(user);
            responseCall.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    Log.d(TAG, " code: " + response.code());
                    if (response.isSuccessful() && response.errorBody() == null) {
                        if (response.body() != null) {
                            Utils.showToastShort(LoginActivity.this, R.string.login_success);
                            String token = response.raw().headers("x-access-token").get(0);
                            Log.d(TAG, " token: " + token);
                            SessionManager sessionManager = new SessionManager(LoginActivity.this);
                            sessionManager.createLoginSession(response.body().getUsername(), response.body().getEmail(), response.body().getId(), token);
                            startActivity(new Intent(LoginActivity.this, SplashActivity.class));
                            LoginActivity.this.finish();
                        }

                    } else {
                        APIErrors error = ErrorUtils.parseError(response);
                        if (error != null) {
                            mTvErrorLogin.setVisibility(View.VISIBLE);
                            mTvErrorLogin.setText(error.isSuccess() + error.getError_message());
                        }


                    }

                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {

                }
            });
        }
    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_login;
    }

    private boolean kiemTraThongTin(String username, String password) {
        if (username.equals("") || password.equals("")) {
            mTvErrorLogin.setVisibility(View.VISIBLE);
            mTvErrorLogin.setText(R.string.login_field_non_data);
            return false;
        }
        if (password.length() < 6) {
            mTvErrorLogin.setVisibility(View.VISIBLE);
            mTvErrorLogin.setText(R.string.login_error_password);
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_in:
                getInfoLogin();
                break;
            case R.id.tv_sign_up:
                break;
            case R.id.tv_forgot_password:
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }


}
