package offic.htk.com.officproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;

import java.util.ArrayList;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.activitis.GroupDetailActivity;

/**
 * Created by nguyen on 12/08/2016.
 */
public class CustomSwipeGroupsAdapter extends RecyclerSwipeAdapter<CustomSwipeGroupsAdapter.MyHolder> {
    private String TAG = "CustomSwipeGroupsAdapter";
    private Context context;
    private List<String> mListGroups = new ArrayList<>();
    private int lastPos = -1;

    public CustomSwipeGroupsAdapter(Context mContext, List<String> mListGroups) {
        this.context = mContext;
        this.mListGroups = mListGroups;
    }

    @Override
    public CustomSwipeGroupsAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_groups, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomSwipeGroupsAdapter.MyHolder viewHolder, final int position) {
        viewHolder.mTvNameGroups.setText(mListGroups.get(position));
        viewHolder.mTvNameMemberGroups.setText(mListGroups.get(position));
        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        viewHolder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {
                Runnable delay = new Runnable() {
                    @Override
                    public void run() {
                        if (lastPos == -1) {

                        } else {
                            closeItem(lastPos);
                            lastPos = position;
                        }
                    }
                };
                Handler handler = new Handler();
                handler.postDelayed(delay, 100);
            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onClose(SwipeLayout layout) {

            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {

            }
        });
        viewHolder.swipeLayout.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Surface position click " + position);
                Intent intent = new Intent(context, GroupDetailActivity.class);
                intent.putExtra("groupname", mListGroups.get(position));
                context.startActivity(intent);
            }
        });
        viewHolder.mLnEditGroups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, " action edit at " + position);
            }
        });
        viewHolder.mLnDeleteGroups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, " action delete at " + position);
                createDialog(position);
            }
        });
        mItemManger.bindView(viewHolder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return mListGroups.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swip_row_groups;
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTvNameGroups, mTvNameMemberGroups;
        private SwipeLayout swipeLayout;
        private LinearLayout mLnEditGroups, mLnDeleteGroups;

        public MyHolder(View itemView) {
            super(itemView);
            mTvNameGroups = (TextView) itemView.findViewById(R.id.tv_name_groups);
            mTvNameMemberGroups = (TextView) itemView.findViewById(R.id.tv_name_member_groups);
            swipeLayout = (SwipeLayout) itemView.findViewById(R.id.swip_row_groups);
            mLnEditGroups = (LinearLayout) itemView.findViewById(R.id.ln_edit_groups);
            mLnDeleteGroups = (LinearLayout) itemView.findViewById(R.id.ln_delete_groups);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, " action clicked at " + getAdapterPosition());
        }
    }

    private void createDialog(final int position) {
        TextView tvOk, tvCancel, tvTitleDialog;
        LayoutInflater inflater = LayoutInflater.from(context);
        final View yourCustomView = inflater.inflate(R.layout.dialog_sync_contacts, null);

        final AlertDialog dialog = new AlertDialog.Builder(context)
                .setView(yourCustomView).create();
        dialog.setCancelable(false);
        tvOk = (TextView) yourCustomView.findViewById(R.id.tv_ok);
        tvCancel = (TextView) yourCustomView.findViewById(R.id.tv_dont_allow);
        tvTitleDialog = (TextView) yourCustomView.findViewById(R.id.tv_title_dialog);
        tvCancel.setText("Cancel");
        tvOk.setText("OK");
        tvTitleDialog.setText("Delete this groups?");
        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, " removed at " + position);
                dialog.dismiss();
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
