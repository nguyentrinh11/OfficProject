package offic.htk.com.officproject.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.models.Details;
import offic.htk.com.officproject.models.UserInfo;

/**
 * Created by nguyen on 02/08/2016.
 */
public class MenuAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList = new ArrayList<>();
    private UserInfo userInfo = new UserInfo();
    private String company;
    int[] mListImage = null;
    String[] mListName = null;

    public MenuAdapter(Context mContext, List<String> mList, UserInfo userInfo, String company, int[] mListImage, String[] mListName) {
        this.mContext = mContext;
        this.mList = mList;
        this.userInfo = userInfo;
        this.company = company;
        this.mListImage = mListImage;
        this.mListName = mListName;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (position) {
            case 0:
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_company, parent, false);
                TextView tvCompany = (TextView) convertView.findViewById(R.id.tv_company);
                tvCompany.setText(company);
                break;
            case 1:
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_avatar, parent, false);
                TextView tvUserName = (TextView) convertView.findViewById(R.id.tv_username);
                tvUserName.setText(userInfo.getUsername());
                break;
            case 2:
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_details, parent, false);
                ImageView imgDetais = (ImageView) convertView.findViewById(R.id.img_details);
                TextView tvDetails = (TextView) convertView.findViewById(R.id.tv_details_name);
                imgDetais.setBackgroundResource(mListImage[0]);
                convertView.setBackgroundResource(R.color.colorAccent);
                tvDetails.setText(mListName[0]);
                break;
            case 3:
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_details, parent, false);
                ImageView imgDetais1 = (ImageView) convertView.findViewById(R.id.img_details);
                TextView tvDetails1 = (TextView) convertView.findViewById(R.id.tv_details_name);
                imgDetais1.setBackgroundResource(mListImage[1]);
                tvDetails1.setText(mListName[1]);
                break;
            case 4:
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_details, parent, false);
                ImageView imgDetais2 = (ImageView) convertView.findViewById(R.id.img_details);
                TextView tvDetails2 = (TextView) convertView.findViewById(R.id.tv_details_name);
                imgDetais2.setBackgroundResource(mListImage[2]);
                tvDetails2.setText(mListName[2]);
                break;
            case 5:
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_details, parent, false);
                ImageView imgDetais3 = (ImageView) convertView.findViewById(R.id.img_details);
                TextView tvDetails3 = (TextView) convertView.findViewById(R.id.tv_details_name);
                imgDetais3.setBackgroundResource(mListImage[3]);
                tvDetails3.setText(mListName[3]);
                break;
            case 6:
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_details, parent, false);
                ImageView imgDetais4 = (ImageView) convertView.findViewById(R.id.img_details);
                TextView tvDetails4 = (TextView) convertView.findViewById(R.id.tv_details_name);
                imgDetais4.setBackgroundResource(mListImage[4]);
                tvDetails4.setText(mListName[4]);
                break;
            case 7:
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_details, parent, false);
                ImageView imgDetais5 = (ImageView) convertView.findViewById(R.id.img_details);
                TextView tvDetails5 = (TextView) convertView.findViewById(R.id.tv_details_name);
                imgDetais5.setBackgroundResource(mListImage[5]);
                tvDetails5.setText(mListName[5]);
                break;
            case 8:
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_details, parent, false);
                ImageView imgDetais6 = (ImageView) convertView.findViewById(R.id.img_details);
                TextView tvDetails6 = (TextView) convertView.findViewById(R.id.tv_details_name);
                imgDetais6.setBackgroundResource(mListImage[6]);
                tvDetails6.setText(mListName[6]);
                break;
        }

        return convertView;
    }
}
