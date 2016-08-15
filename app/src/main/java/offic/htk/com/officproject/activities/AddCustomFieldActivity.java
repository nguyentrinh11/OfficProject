package offic.htk.com.officproject.activities;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.base.BaseActivity;
import offic.htk.com.officproject.models.realm.CustomField;
import offic.htk.com.officproject.utils.RecyclerViewDividerItemDecoration;

public class AddCustomFieldActivity extends BaseActivity implements View.OnClickListener {

    RecyclerView mRecyclerView;
    LinearLayout ln_add;
    List<CustomField> mCustomFieldList = new ArrayList<>();
    CustomRecyclerViewAdapter mAdapter;
    TextView tv_add_custom;

    @Override
    protected void onCreate() {
    }

    @Override
    protected void initComponents() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rc_add_custom_field_list);
        mAdapter = new CustomRecyclerViewAdapter(this,mCustomFieldList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new RecyclerViewDividerItemDecoration(this, RecyclerViewDividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        ln_add = (LinearLayout) findViewById(R.id.ln_add_custom_field);
        ln_add.setOnClickListener(this);
    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_add_custom_field;
    }

    public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder>{
        private Context context;
        private LayoutInflater mInflater;
        private List<CustomField> customFieldList = new ArrayList<>();

        public CustomRecyclerViewAdapter(Context context, List list) {
            this.context = context;
            this.customFieldList = list;
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.custom_add_custom_field_row,parent,false);
            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, final int position) {
            CustomField customField = customFieldList.get(position);
            holder.edt_field.setText(customField.getCdValue());
        }

        @Override
        public int getItemCount() {
            return customFieldList.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            EditText edt_field;
            ImageView imgDelete;

            public CustomViewHolder(View itemView) {
                super(itemView);
                edt_field = (EditText) itemView.findViewById(R.id.edt_field_value);
                imgDelete = (ImageView) itemView.findViewById(R.id.img_delete_field);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ln_add_custom_field:
                int listSize = mCustomFieldList.size();
                if(listSize >= 1){
                    EditText value = (EditText) mRecyclerView.getChildAt(listSize - 1).findViewById(R.id.edt_field_value);
                    if(value.getText().toString().trim().length() < 1){
                        value.setError("Please enter value");
                    }else{
                        mCustomFieldList.get(listSize - 1).setCdValue(value.getText().toString());
                        CustomField customField = new CustomField();
                        mCustomFieldList.add(customField);
                        mAdapter.notifyDataSetChanged();
                        EditText newValue = (EditText) mRecyclerView.getChildAt(listSize - 1).findViewById(R.id.edt_field_value);
                        newValue.setFocusable(true);
                    }
                }else if(listSize == 0){
                    Log.d("add custom field","click ");
                    CustomField customField = new CustomField();
                    mCustomFieldList.add(customField);
                    mAdapter.notifyDataSetChanged();
                }
                break;
        }
    }

}
