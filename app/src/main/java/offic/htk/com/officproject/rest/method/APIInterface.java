package offic.htk.com.officproject.rest.method;

/**
 * Created by nguyen on 27/07/2016.
 */


import offic.htk.com.officproject.models.forgotpassword.Email;
import offic.htk.com.officproject.models.login.User;
import offic.htk.com.officproject.rest.response.ForgotPasswordResponse;
import offic.htk.com.officproject.rest.response.ListOrganizations.ListOrganizations;
import offic.htk.com.officproject.rest.response.LoginResponse;
import offic.htk.com.officproject.rest.response.LogoutResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface APIInterface {
    //    @Headers({
    //      "Content-Type: application/json",
    //            "Accept: application/json"
    //    })


    // TODO AUTHOR
    @POST("login/")
    Call<LoginResponse> authenticateLogin(@Body User user);


    @GET("api/v1/organizations")
    Call<ListOrganizations> getListOrganizations(@Header("x-access-token") String token);

    // TODO GET RESPONSE LOGOUT
    @GET("logout")
    Call<LogoutResponse> getMessageLogout(@Header("x-access-token") String token);

    // TODO POST SEND EMAIL FORGOT PASSWORD
    @POST("forgot-password/")
    Call<ForgotPasswordResponse> getMessageForgotPassword(@Body Email email);


}
