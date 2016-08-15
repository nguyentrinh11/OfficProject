package offic.htk.com.officproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.models.realm.File;

/**
 * Created by Mai Trinh on 8/12/2016.
 */
public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.CustomViewHolder> {
    private Context context;
    private LayoutInflater hzInflater;
    private List<File> fileList = new ArrayList<>();
    private int mRowIndex = -1;

    public HorizontalRecyclerViewAdapter(){
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
        notifyDataSetChanged();
    }

    public int getmRowIndex() {
        return mRowIndex;
    }

    public void setmRowIndex(int mRowIndex) {
        this.mRowIndex = mRowIndex;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = hzInflater.inflate(R.layout.custom_notes_attack_file_item,parent,false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
//        CustomViewHolder hd = (CustomViewHolder) holder;
        holder.imgFile.setImageResource(R.drawable.avatar);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return fileList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFile;

        public CustomViewHolder(View itemView) {
            super(itemView);
            imgFile = (ImageView) itemView.findViewById(R.id.notes_img_file_attach);
        }
    }
}
