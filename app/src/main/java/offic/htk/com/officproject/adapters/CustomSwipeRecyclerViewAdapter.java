package offic.htk.com.officproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;

import java.util.ArrayList;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.activities.ContactDetailActivity;

/**
 * Created by Mai Trinh on 7/29/2016.
 */
public class CustomSwipeRecyclerViewAdapter extends RecyclerSwipeAdapter<CustomSwipeRecyclerViewAdapter.CustomViewHolder>{
    private Context context;
    private List<String> list = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private int lastPos = -1;

    public CustomSwipeRecyclerViewAdapter(Context context, List<String> list){
        this.context = context;
        this.list = list;
        this.layoutInflater = LayoutInflater.from(this.context);
    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.custom_contact_row,parent,false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder viewHolder, final int position) {
        viewHolder.name.setText(list.get(position));
        viewHolder.phone.setText(list.get(position));
        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
//        viewHolder.swipeLayout.addDrag(SwipeLayout.DragEdge.Left, viewHolder.swipeLayout.findViewById(R.id.bottom_wrapper));
//        viewHolder.swipeLayout.addDrag(SwipeLayout.DragEdge.Right, viewHolder.swipeLayout.findViewById(R.id.bottom_wrapper));

        viewHolder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {

            }
            @Override
            public void onOpen(SwipeLayout layout) {

                Runnable delay = new Runnable() {
                    @Override
                    public void run() {
                        if(lastPos == -1){

                        }else{
                        closeItem(lastPos);
                lastPos = position;
            }
        }
    };
    Handler handler = new Handler();
    handler.postDelayed(delay,100);
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
                Log.d("Adapter","Surface position click " + position);
            }
        });

        viewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Adapter","textview position click " + position);
            }
        });

        viewHolder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Adapter","favorite position click " + position);
            }
        });

        viewHolder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Adapter","detail position click " + position);
                Intent intent = new Intent(context, ContactDetailActivity.class);
                context.startActivity(intent);
            }
        });

        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Adapter","delete position click " + position);
            }
        });
        mItemManger.bindView(viewHolder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swip;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView name,phone;
        private ImageView favorite, detail, delete;
        private SwipeLayout swipeLayout;
        private ImageView img;
        public CustomViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.user_name);
            phone = (TextView) itemView.findViewById(R.id.user_phone_number);
            favorite = (ImageView) itemView.findViewById(R.id.imgv_favorite);
            detail = (ImageView) itemView.findViewById(R.id.imgv_details);
            delete = (ImageView) itemView.findViewById(R.id.imgv_delete);
            swipeLayout = (SwipeLayout) itemView.findViewById(R.id.swip);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
