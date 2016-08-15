package offic.htk.com.officproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.activities.MainActivity;
import offic.htk.com.officproject.rest.response.ListOrganizations.Organization;


/**
 * Created by nguyen on 28/07/2016.
 */
public class ListNameCompanyAdapter extends RecyclerView.Adapter<ListNameCompanyAdapter.MyHolder> {
    private Context mContext;
    private List<Organization> mListOrganizations = new ArrayList<>();

    public ListNameCompanyAdapter(Context mContext, List<Organization> mListOrganizations) {
        this.mContext = mContext;
        this.mListOrganizations = mListOrganizations;
    }

    @Override
    public ListNameCompanyAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_company_list, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(ListNameCompanyAdapter.MyHolder holder, int position) {
        Organization organizations = mListOrganizations.get(position);
        holder.mTvNameCompany.setText(organizations.getName().trim());

    }

    @Override
    public int getItemCount() {
        return mListOrganizations.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTvNameCompany;
        private ImageView mImgLogoComapy;

        public MyHolder(View itemView) {
            super(itemView);
            mTvNameCompany = (TextView) itemView.findViewById(R.id.tv_name_company);
            mImgLogoComapy = (ImageView) itemView.findViewById(R.id.img_company);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mContext.startActivity(new Intent(mContext, MainActivity.class));
        }
    }
}
