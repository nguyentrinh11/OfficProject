package offic.htk.com.officproject.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.models.realm.Note;

/**
 * Created by Mai Trinh on 8/12/2016.
 */
public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.CustomViewHolder> {

    private Context context;
    private LayoutInflater vInflater;
    private List<Note> noteList = new ArrayList<>();
    private RecyclerView hRecyclerView;

    public VerticalRecyclerViewAdapter(Context context, List list){
        this.context = context;
        this.noteList = list;
        this.vInflater = LayoutInflater.from(context);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = vInflater.inflate(R.layout.custom_note_row,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.imgAvatar.setImageResource(R.drawable.avatar);
        holder.hAdapter.setFileList(noteList.get(position).getFileList());
        holder.hAdapter.setmRowIndex(position);
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAvatar, imgEdit, imgDelete;
        private TextView tvUserName, tvAddDate, tvMessage;
        private HorizontalRecyclerViewAdapter hAdapter;
        public CustomViewHolder(View itemView) {
            super(itemView);
            // imageview
            imgAvatar = (ImageView) itemView.findViewById(R.id.notes_img_user_avatar);
            imgEdit = (ImageView) itemView.findViewById(R.id.notes_img_edit);
            imgDelete = (ImageView) itemView.findViewById(R.id.notes_img_delete);
            // textview
            tvUserName = (TextView) itemView.findViewById(R.id.notes_tv_user_name);
            tvAddDate = (TextView) itemView.findViewById(R.id.notes_tv_add_date);
            tvMessage = (TextView) itemView.findViewById(R.id.notes_message);
            // recyclerview
            hRecyclerView = (RecyclerView) itemView.findViewById(R.id.rc_note_attack_file);
            hRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));
            hAdapter = new HorizontalRecyclerViewAdapter();
            hRecyclerView.setAdapter(hAdapter);

        }
    }
}
