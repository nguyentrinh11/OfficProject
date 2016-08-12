package offic.htk.com.officproject.activities;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import offic.htk.com.officproject.R;
import offic.htk.com.officproject.base.BaseActivity;
import offic.htk.com.officproject.models.forgotpassword.Email;
import offic.htk.com.officproject.rest.UtilsRest;
import offic.htk.com.officproject.rest.method.APIInterface;
import offic.htk.com.officproject.rest.response.ForgotPasswordResponse;
import offic.htk.com.officproject.utils.EmailValidator;
import offic.htk.com.officproject.utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends BaseActivity implements View.OnClickListener {
    private String TAG = "ForgotPassWordActivity";
    private EditText mEdtEmailForgotPassword;
    private Button mBtnSendEmail;
    private TextView mTvSignIn;

    @Override
    protected void onCreate() {
    }

    @Override
    protected void initComponents() {
        mEdtEmailForgotPassword = (EditText) findViewById(R.id.edt_email_forgot_password);
        mBtnSendEmail = (Button) findViewById(R.id.btn_send_email);
        mTvSignIn = (TextView) findViewById(R.id.tv_sign_in);
        mBtnSendEmail.setOnClickListener(this);
        mTvSignIn.setOnClickListener(this);

    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_fogot_password;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send_email:
                sendEmail();
                break;
            case R.id.tv_sign_in:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            default:
                break;
        }
    }

    private void sendEmail() {
        String email = mEdtEmailForgotPassword.getText().toString().trim();
        EmailValidator emailValidator = new EmailValidator();
        if (email.equals("")) {
            mEdtEmailForgotPassword.setError("Please enter your email");
        } else if (!emailValidator.validate(email)) {
            mEdtEmailForgotPassword.setError("Email Invalid");
        } else {
            Email emailsend = new Email();
            emailsend.setEmail(email);
            APIInterface apiInterface = UtilsRest.getInterfaceService();
            Call<ForgotPasswordResponse> forgotPasswordResponseCall = apiInterface.getMessageForgotPassword(emailsend);
            forgotPasswordResponseCall.enqueue(new Callback<ForgotPasswordResponse>() {
                @Override
                public void onResponse(Call<ForgotPasswordResponse> call, Response<ForgotPasswordResponse> response) {
                    Log.d(TAG, "code " + response.code());
                    if (response.isSuccessful() && response.errorBody() == null) {
                        Utils.showToastShort(ForgotPasswordActivity.this, R.string.forgot_password_success);
                        mEdtEmailForgotPassword.setText("");
                    }
                    if (response.code() == 404) {
                        Utils.showToastShort(ForgotPasswordActivity.this, R.string.forgot_password_error);
                    }
                }

                @Override
                public void onFailure(Call<ForgotPasswordResponse> call, Throwable t) {

                }
            });
        }


    }
}
