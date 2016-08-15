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

public class AddMoreMembersActivity extends BaseActivity {
    private String TAG = "AddMoreMembersActivity";
    private List<Choose> mListAddMore;
    private RecyclerView recyclerView;
    private ChooseTypeAdapter adapter;
    private String mNameChoose;
    private LinearLayout mToolbarAddMoreMembers;
    private TextView mTvTitle;


    @Override
    protected void onCreate() {

    }

    @Override
    protected void initComponents() {
        recyclerView = (RecyclerView) findViewById(R.id.rc_add_more_members);
        mToolbarAddMoreMembers = (LinearLayout) findViewById(R.id.toolbar_add_more_members);
        mTvTitle = (TextView) mToolbarAddMoreMembers.findViewById(R.id.tv_title);
        Choose[] array = new Choose[]{new Choose("Phuong Vu", true), new Choose("Son Hoang", false)};
        mListAddMore = new ArrayList<>(Arrays.asList(array));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChooseTypeAdapter(this, mListAddMore);
        recyclerView.setAdapter(adapter);
        mTvTitle.setText("Add More");
    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_add_more_members;
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
                                                        mNameChoose = mList.get(getAdapterPosition()).getName_choose();
                                                        Log.d(TAG + " Name choose", mNameChoose);
                                                        mList.get(getAdapterPosition()).setChecked(true);
                                                        notifyDataSetChanged();
                                                    } else {
                                                        mList.get(getAdapterPosition()).setChecked(false);
                                                        notifyDataSetChanged();
                                                    }
                                                }
                                            }

                );
            }
        }
    }
}
