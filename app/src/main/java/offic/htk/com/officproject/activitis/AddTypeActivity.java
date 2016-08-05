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
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.base.BaseActivity;
import offic.htk.com.officproject.models.Choose;

public class AddTypeActivity extends BaseActivity {

    private String mNameChoose;
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
                setChooseTypeAddEmail();
                break;
            case 3:
                setChooseTypeAddIM();
                break;
            case 4:
                setChooseTypeAddWebsite();
                break;
            case 5:
                setChooseTypeAddAddress();
                break;
            default:
                break;
        }
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChooseTypeAdapter(this, mListChoose);
        recyclerView.setAdapter(adapter);

    }

    private void setChooseTypeAddAddress() {
        Choose choose1 = new Choose();
        choose1.setName_choose("Work");
        choose1.setChecked(true);
        Choose choose2 = new Choose();
        choose2.setName_choose("Home");
        choose2.setChecked(false);
        Choose choose3 = new Choose();
        choose3.setName_choose("Other");
        choose3.setChecked(false);
        mListChoose.add(choose1);
        mListChoose.add(choose2);
        mListChoose.add(choose3);

    }

    private void setChooseTypeAddWebsite() {
        Choose choose1 = new Choose();
        choose1.setName_choose("Work");
        choose1.setChecked(true);
        Choose choose2 = new Choose();
        choose2.setName_choose("Personal");
        choose2.setChecked(false);
        Choose choose3 = new Choose();
        choose3.setName_choose("Other");
        choose3.setChecked(false);
        mListChoose.add(choose1);
        mListChoose.add(choose2);
        mListChoose.add(choose3);

    }

    private void setChooseTypeAddIM() {
        Choose choose1 = new Choose();
        choose1.setName_choose("Work");
        choose1.setChecked(true);
        Choose choose2 = new Choose();
        choose2.setName_choose("Personal");
        choose2.setChecked(false);
        Choose choose3 = new Choose();
        choose3.setName_choose("Other");
        choose3.setChecked(false);
        mListChoose.add(choose1);
        mListChoose.add(choose2);
        mListChoose.add(choose3);
    }

    private void setChooseTypeAddEmail() {
        Choose choose1 = new Choose();
        choose1.setName_choose("Work");
        choose1.setChecked(true);
        Choose choose2 = new Choose();
        choose2.setName_choose("Home");
        choose2.setChecked(false);
        Choose choose3 = new Choose();
        choose3.setName_choose("Other");
        choose3.setChecked(false);
        mListChoose.add(choose1);
        mListChoose.add(choose2);
        mListChoose.add(choose3);

    }

    private void setChooseTypeAddPhone() {
        Choose choose1 = new Choose();
        choose1.setChecked(true);
        choose1.setName_choose("Work");
        Choose choose2 = new Choose();
        choose2.setChecked(false);
        choose2.setName_choose("Mobile");
        Choose choose3 = new Choose();
        choose3.setChecked(false);
        choose3.setName_choose("Fax");
        Choose choose4 = new Choose();
        choose4.setChecked(false);
        choose4.setName_choose("Paper");
        Choose choose5 = new Choose();
        choose5.setChecked(false);
        choose5.setName_choose("Home");
        Choose choose6 = new Choose();
        choose6.setChecked(false);
        choose6.setName_choose("Skype");
        Choose choose7 = new Choose();
        choose7.setChecked(false);
        choose7.setName_choose("Other");
        mListChoose.add(choose1);
        mListChoose.add(choose2);
        mListChoose.add(choose3);
        mListChoose.add(choose4);
        mListChoose.add(choose5);
        mListChoose.add(choose6);
        mListChoose.add(choose7);
    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_add_type;
    }

    public class ChooseTypeAdapter extends RecyclerView.Adapter<ChooseTypeAdapter.ChooseHoler> {
        private Context mContext;
        private List<Choose> mList = new ArrayList<>();

        public ChooseTypeAdapter(Context mContext, List<Choose> mList) {
            this.mContext = mContext;
            this.mList = mList;
        }

        @Override
        public ChooseHoler onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_row_choose_type, parent, false);
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
            Choose choose = mList.get(position);
            holder.tvTypeName.setText(choose.getName_choose());
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        public class ChooseHoler extends RecyclerView.ViewHolder {
            private TextView tvTypeName;
            private ImageView imgChoose;

            public ChooseHoler(View itemView) {
                super(itemView);
                tvTypeName = (TextView) itemView.findViewById(R.id.tv_type_name);
                imgChoose = (ImageView) itemView.findViewById(R.id.img_choose);
                itemView.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    if (!mList.get(getAdapterPosition()).getChecked()) {
                                                        for (int i = 0; i < mList.size(); i++) {
                                                            mList.get(i).setChecked(false);
                                                        }
                                                        mNameChoose = mList.get(getAdapterPosition()).getName_choose();
                                                        Log.d("Name choose", mNameChoose);
                                                        mList.get(getAdapterPosition()).setChecked(true);
                                                        notifyDataSetChanged();
                                                    }
                                                }
                                            }

                );
            }
        }
    }
}
