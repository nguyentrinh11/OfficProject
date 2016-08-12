package offic.htk.com.officproject.activities;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.adapters.ChooseTypeAdapter;
import offic.htk.com.officproject.base.BaseActivity;
import offic.htk.com.officproject.models.Choose;

public class ChooseCountryActivity extends BaseActivity implements ChooseTypeAdapter.senData, View.OnClickListener {
    private String TAG = "ChooseCountryActivity";
    private ChooseTypeAdapter adapter;
    private List<Choose> mListChoose;
    private RecyclerView recyclerView;
    private TextView mTvCancel, mTvDone;


    @Override
    protected void onCreate() {

    }

    public void ScrollAphabet(View v) {
        String firstLetter = (String) v.getTag();
        Log.d(TAG, "alphabet clicked " + firstLetter);

        if (mListChoose != null) {
            int index = -1;
            for (Choose choose : mListChoose) {
                if (choose.getName_choose().toLowerCase().startsWith(firstLetter.toLowerCase())) {

                    index = mListChoose.indexOf(choose);
                    Log.d(TAG, "index item cliked " + index + "");
                    break;
                }
            }
            if (index >= 0) {
                recyclerView.scrollToPosition(index);
            }

        }

    }

    @Override
    protected void initComponents() {
        recyclerView = (RecyclerView) findViewById(R.id.rc_choose_type_country);
        mTvCancel = (TextView) findViewById(R.id.tv_cancel);
        mTvDone = (TextView) findViewById(R.id.tv_done);
        mTvCancel.setOnClickListener(this);
        mTvDone.setOnClickListener(this);
        Choose[] array = new Choose[]{new Choose("Afghanistan", true), new Choose("Albania", false), new Choose("Algeria", false)
                , new Choose("Andorra", false), new Choose("Angola", false), new Choose("Antarctica", false), new Choose("Antigua and Barbuda", false)
                , new Choose("Argentina", false), new Choose("Armenia", false), new Choose("Australia", false), new Choose("Austria", false)
                , new Choose("Azerbaijan", false), new Choose("Bahamas", false), new Choose("Bahrain", false), new Choose("Bangladesh", false), new Choose("Barbados", false)
                , new Choose("Belarus", false), new Choose("Belgium", false), new Choose("Belize", false), new Choose("Benin", false), new Choose("Bermuda", false)
                , new Choose("Bhutan", false), new Choose("Bolivia", false), new Choose("Bosnia and Herzegovina", false), new Choose("Botswana", false), new Choose("Brazil", false)
                , new Choose("Brunei", false), new Choose("Bulgaria", false), new Choose("Burkina Faso", false), new Choose("Burma", false), new Choose("Burundi", false)
                , new Choose("Cambodia", false), new Choose("Cameroon", false), new Choose("Canada", false), new Choose("Cape Verde", false), new Choose("Central African Republic", false)
                , new Choose("Chad", false), new Choose("Chile", false), new Choose("China", false), new Choose("Colombia", false), new Choose("Comoros", false)
                , new Choose("Congo, Democratic Republic", false), new Choose("Congo, Republic of the", false), new Choose("Costa Rica", false), new Choose("Cote d'Ivoire", false), new Choose("Croatia", false)
                , new Choose("Cuba", false), new Choose("Cyprus", false), new Choose("Czech Republic", false), new Choose("Denmark", false), new Choose("Djibouti", false)
                , new Choose("Dominica", false), new Choose("Dominican Republic", false), new Choose("East Timor", false), new Choose("Ecuado", false), new Choose("Egypt", false)
                , new Choose("El Salvador", false), new Choose("Equatorial Guinea", false), new Choose("Eritrea", false), new Choose("Estonia", false), new Choose("Ethiopia", false)
                , new Choose("Fiji", false), new Choose("Finland", false), new Choose("France", false), new Choose("Gabon", false), new Choose("Gambia", false)
                , new Choose("Georgia", false), new Choose("Germany", false), new Choose("Ghana", false), new Choose("Greece", false), new Choose("Greenland", false)
                , new Choose("Grenada", false), new Choose("Guatemala", false), new Choose("Guinea", false), new Choose("Guinea-Bissau", false), new Choose("Guyana", false)
                , new Choose("Haiti", false), new Choose("Honduras", false), new Choose("Hong Kong", false), new Choose("Hungary", false), new Choose("Iceland", false)
                , new Choose("India", false), new Choose("Indonesia", false), new Choose("Iran", false), new Choose("Iraq", false), new Choose("Ireland", false)
                , new Choose("Israel", false), new Choose("Italy", false), new Choose("Jamaica", false), new Choose("Japan", false), new Choose("Jordan", false)
                , new Choose("Kenya", false), new Choose("Kiribati", false), new Choose("Korea, North", false), new Choose("Korea, South", false), new Choose("Kuwait", false)
                , new Choose("Kyrgyzstan", false), new Choose("Laos", false), new Choose("Latvia", false), new Choose("Lebanon", false), new Choose("Lesotho", false)
                , new Choose("Liberia", false), new Choose("Libya", false), new Choose("Liechtenstein", false), new Choose("Lithuania", false), new Choose("Luxembourg", false)
                , new Choose("Macedonia", false), new Choose("Madagascar", false), new Choose("Malawi", false), new Choose("Malaysia", false), new Choose("Maldives", false)
                , new Choose("Mali", false), new Choose("Malta", false), new Choose("Marshall Islands", false), new Choose("Mauritania", false), new Choose("Mauritius", false)
                , new Choose("Mexico", false), new Choose("Micronesia", false), new Choose("Moldova", false), new Choose("Mongolia", false), new Choose("Morocco", false)
                , new Choose("Monaco", false), new Choose("Mozambique", false), new Choose("Namibia", false), new Choose("Nauru", false), new Choose("Nepal", false)
                , new Choose("Netherlands", false), new Choose("New Zealand", false), new Choose("Nicaragua", false), new Choose("Niger", false), new Choose("Nigeria", false)
                , new Choose("Norway", false), new Choose("Oman", false), new Choose("Pakistan", false), new Choose("Panama", false), new Choose("Papua New Guinea", false)
                , new Choose("Paraguay", false), new Choose("Peru", false), new Choose("Philippines", false), new Choose("Poland", false), new Choose("Portugal", false)
                , new Choose("Qatar", false), new Choose("Romania", false), new Choose("Russia", false), new Choose("Rwanda", false), new Choose("Samoa", false)
                , new Choose("San Marino", false), new Choose("Sao Tome", false), new Choose("Saudi Arabia", false), new Choose("Senegal", false), new Choose("erbia and Montenegro", false)
                , new Choose("Seychelles", false), new Choose("Sierra Leone", false), new Choose("Singapore", false), new Choose("Slovakia", false), new Choose("Slovenia", false)
                , new Choose("Solomon Islands", false), new Choose("Somalia", false), new Choose("South Africa", false), new Choose("Spain", false), new Choose("Sri Lanka", false)
                , new Choose("Sudan", false), new Choose("Suriname", false), new Choose("Swaziland", false), new Choose("Sweden", false), new Choose("Switzerland", false)
                , new Choose("Syria", false), new Choose("Taiwan", false), new Choose("Tajikistan", false), new Choose("Tanzania", false), new Choose("Thailand", false)
                , new Choose("Togo", false), new Choose("Tonga", false), new Choose("Trinidad and Tobago", false), new Choose("Tunisia", false), new Choose("Turkey", false)
                , new Choose("Turkmenistan", false), new Choose("Uganda", false), new Choose("Ukraine", false), new Choose("United Arab Emirates", false), new Choose("United Kingdom", false)
                , new Choose("United States", false), new Choose("Uruguay", false), new Choose("Uzbekistan", false), new Choose("Vanuatu", false), new Choose("Venezuela", false)
                , new Choose("Vietnam", false), new Choose("Yemen", false), new Choose("Zambia", false), new Choose("Zimbabwe", false)};
        mListChoose = new ArrayList<>(Arrays.asList(array));
        adapter = new ChooseTypeAdapter(ChooseCountryActivity.this, mListChoose, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_choose_country;
    }

    @Override
    public void sendName(String name) {
        Log.d(TAG, " get data adapter " + name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                ChooseCountryActivity.this.finish();
                break;
            case R.id.tv_done:
                break;
        }
    }
}
