package offic.htk.com.officproject.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import offic.htk.com.officproject.activitis.AddNewCompanyActivity;
import offic.htk.com.officproject.activitis.MainActivity;
import offic.htk.com.officproject.activitis.SplashActivity;


/**
 * Created by nguyen on 28/07/2016.
 */
public class SessionManager {
    /**
     * SharedPreferences
     */
    SharedPreferences sharedPreferences;

    /**
     * Editor for SharedPreferences
     */
    SharedPreferences.Editor editor;

    /**
     * Context
     */
    Context mContext;

    /**
     * SharedPreferences mode
     */
    int PRIVATE_MODE = 0;

    /**
     * SharedPreferences file name
     */
    private static final String PREF_NAME = "sessionManager";

    /**
     * All Shared Preferences Keys
     */
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_Id = "id";

    /**
     * Constructor
     */
    public SessionManager(Context context) {
        this.mContext = context;
        sharedPreferences = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    /**
     * Create login session
     */
    public void createLoginSession(String username, String email, String id, String token) {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);


        // Storing information user
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_Id, id);
        editor.putString(KEY_TOKEN, token);


        // commit changes
        editor.commit();
    }

    /**
     * Get Login State
     */
    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }


    /**
     * Check Login method
     */
    public void checkLogin() {

        // Check login status
        if (this.isLoggedIn()) {
            Intent intent = new Intent(mContext, SplashActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }

    }

    /**
     * Get stored session data
     */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        // user username
        user.put(KEY_USERNAME, sharedPreferences.getString(KEY_USERNAME, null));

        // user email
        user.put(KEY_EMAIL, sharedPreferences.getString(KEY_EMAIL, null));

        // user id
        user.put(KEY_Id, sharedPreferences.getString(KEY_Id, null));

        // user token
        user.put(KEY_TOKEN, sharedPreferences.getString(KEY_TOKEN, null));

        return user;
    }

    /**
     * Clear session details
     */
    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }
}
