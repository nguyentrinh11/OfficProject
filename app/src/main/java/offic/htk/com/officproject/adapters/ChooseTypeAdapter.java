package offic.htk.com.officproject.adapters;

import android.content.Context;
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
import offic.htk.com.officproject.models.Choose;

/**
 * Created by nguyen on 11/08/2016.
 */
public class ChooseTypeAdapter extends RecyclerView.Adapter<ChooseTypeAdapter.ChooseHoler> {
    private Context mContext;
    private List<Choose> mList = new ArrayList<>();
    private String mNameChoose;
    private senData senData;

    public ChooseTypeAdapter(Context mContext, List<Choose> mList,senData senData) {
        this.mContext = mContext;
        this.mList = mList;
        this.senData = senData;
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
                                                    Log.d(" Name choose", mNameChoose);
                                                    mList.get(getAdapterPosition()).setChecked(true);
                                                    notifyDataSetChanged();
                                                    senData.sendName(mNameChoose);
                                                }
                                            }
                                        }

            );
        }
    }

    public interface senData {
        void sendName(String name);
    }
}
