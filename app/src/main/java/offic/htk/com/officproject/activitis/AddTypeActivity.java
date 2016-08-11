package offic.htk.com.officproject.activitis;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.adapters.ChooseTypeAdapter;
import offic.htk.com.officproject.base.BaseActivity;
import offic.htk.com.officproject.models.Choose;

public class AddTypeActivity extends BaseActivity implements ChooseTypeAdapter.senData {
    private String TAG = "AddTypeActivity";
    private ChooseTypeAdapter adapter;
    private List<Choose> mListChoose;
    private RecyclerView recyclerView;
    private int style = 0;


    @Override
    protected void onCreate() {
        Intent intent = getIntent();
        style = Integer.parseInt(intent.getStringExtra("type"));

    }

    @Override
    protected void initComponents() {
        recyclerView = (RecyclerView) findViewById(R.id.rc_choose_type);
        mListChoose = new ArrayList<>();
        switch (style) {
            case 1:
                setChooseTypeAddPhone();
                break;
            case 2:
                setChooseTypeAddAddressOrEmail();
                break;
            case 3:
                setChooseTypeAddIMOrWebsite();
                break;
            case 4:
                setChooseTypeAddIMOrWebsite();
                break;
            case 5:
                setChooseTypeAddAddressOrEmail();
                break;
            case 6:
                setChooseTypeIMProtocol();
                break;
            default:
                break;
        }
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChooseTypeAdapter(this, mListChoose, this);
        recyclerView.setAdapter(adapter);

    }


    private void setChooseTypeAddIMOrWebsite() {
        Choose[] array = new Choose[]{new Choose("Work", true), new Choose("Personal", false), new Choose("Other", false)};
        mListChoose = new ArrayList<>(Arrays.asList(array));
    }

    private void setChooseTypeAddAddressOrEmail() {
        Choose[] array = new Choose[]{new Choose("Work", true), new Choose("Home", false), new Choose("Other", false)};
        mListChoose = new ArrayList<>(Arrays.asList(array));

    }

    private void setChooseTypeAddPhone() {
        Choose[] array = new Choose[]{new Choose("Work", true), new Choose("Mobile", false),
                new Choose("Fax", false), new Choose("Paper", false), new Choose("Home", false),
                new Choose("Skype", false), new Choose("Other", false)};
        mListChoose = new ArrayList<>(Arrays.asList(array));
    }

    private void setChooseTypeIMProtocol() {
        Choose[] array = new Choose[]{new Choose("Facebook", true), new Choose("Skype", false),
                new Choose("Google Talk", false), new Choose("Yahoo", false), new Choose("Jabber", false),
                new Choose("MSN", false), new Choose("Other", false)};
        mListChoose = new ArrayList<>(Arrays.asList(array));
    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_add_type;
    }


    @Override
    public void sendName(String name) {
        Log.d(TAG, " get data adapter " + name);
    }
}
