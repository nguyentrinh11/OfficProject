package offic.htk.com.officproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import offic.htk.com.officproject.R;

/**
 * Created by nguyen on 02/08/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRescource());
        overridePendingTransition(R.anim.in_from_right, R.anim.out_from_left);
        setupToolbar();
        onCreate();
        initComponents();
    }

    protected abstract void onCreate();

    protected abstract void initComponents();

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    protected void replaceFragment(int cotainerId, BaseFragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        String TAG = fragment.getClass().getSimpleName();
        fragmentTransaction.replace(cotainerId, fragment, TAG);
        if (addToBackStack) fragmentTransaction.addToBackStack(TAG);
        else fragmentTransaction.disallowAddToBackStack();
        fragmentTransaction.commit();
    }

    protected abstract int getLayoutRescource();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.in_from_left, R.anim.out_from_right);
    }
}
