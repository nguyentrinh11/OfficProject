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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.base.BaseActivity;
import offic.htk.com.officproject.models.Choose;
import offic.htk.com.officproject.models.ChooseLanguage;

public class SettingsLanguageActivity extends BaseActivity implements View.OnClickListener {
    private String TAG = "SettingsLanguageActivity";
    private List<ChooseLanguage> mListLanguage;
    private ChooseTypeAdapter chooseTypeAdapter;
    private RecyclerView recyclerView;
    private String mNameChoose;
    private LinearLayout linearLayout;
    private TextView mTvBack;


    @Override
    protected void onCreate() {

    }

    @Override
    protected void initComponents() {
        linearLayout = (LinearLayout) findViewById(R.id.toolbar_language);
        mTvBack = (TextView) linearLayout.findViewById(R.id.tv_cancel);
        recyclerView = (RecyclerView) findViewById(R.id.rc_settings_language);
        ChooseLanguage[] array = new ChooseLanguage[]{new ChooseLanguage("English", "English", true), new ChooseLanguage("Tiếng Việt", "Vietnammese", false)};
        mListLanguage = new ArrayList<>(Arrays.asList(array));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        chooseTypeAdapter = new ChooseTypeAdapter(this, mListLanguage);
        recyclerView.setAdapter(chooseTypeAdapter);
        mTvBack.setOnClickListener(this);

    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_settings_language;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                SettingsLanguageActivity.this.finish();
                break;
        }
    }

    public class ChooseTypeAdapter extends RecyclerView.Adapter<ChooseTypeAdapter.ChooseHoler> {
        private Context mContext;
        private List<ChooseLanguage> mList = new ArrayList<>();

        public ChooseTypeAdapter(Context mContext, List<ChooseLanguage> mList) {
            this.mContext = mContext;
            this.mList = mList;
        }

        @Override
        public ChooseHoler onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_row_choose_language, parent, false);
            return new ChooseHoler(view);
        }

        @Override
        public void onBindViewHolder(ChooseHoler holder, int position) {
            if (mList.get(position).getChecked()) {
                holder.imgChoose.setVisibility(View.VISIBLE);
                holder.imgChoose.setImageResource(R.drawable.ic_choose_type);
            } else {
                holder.imgChoose.setVisibility(View.GONE);
            }
            ChooseLanguage choose = mList.get(position);
            holder.tvTypeNameLanguage.setText(choose.getName_language());
            holder.tvTitleLanguage.setText(choose.getTitle_language());
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        public class ChooseHoler extends RecyclerView.ViewHolder {
            private TextView tvTypeNameLanguage, tvTitleLanguage;
            private ImageView imgChoose;

            public ChooseHoler(View itemView) {
                super(itemView);
                tvTypeNameLanguage = (TextView) itemView.findViewById(R.id.tv_type_name_language);
                imgChoose = (ImageView) itemView.findViewById(R.id.img_choose_language);
                tvTitleLanguage = (TextView) itemView.findViewById(R.id.tv_title_language);
                itemView.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    if (!mList.get(getAdapterPosition()).getChecked()) {
                                                        for (int i = 0; i < mList.size(); i++) {
                                                            mList.get(i).setChecked(false);
                                                        }
                                                        mNameChoose = mList.get(getAdapterPosition()).getName_language();
                                                        Log.d(TAG + " Name choose", mNameChoose);
                                                        mList.get(getAdapterPosition()).setChecked(true);
                                                        notifyDataSetChanged();
                                                        Intent intent = new Intent();
                                                        intent.putExtra("value", mNameChoose);
                                                        setResult(RESULT_OK, intent);
                                                    }
                                                }
                                            }

                );
            }
        }


    }
}
