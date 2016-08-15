package offic.htk.com.officproject.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.base.BaseActivity;
import offic.htk.com.officproject.models.realm.Address;
import offic.htk.com.officproject.models.realm.Email;
import offic.htk.com.officproject.models.realm.IM;
import offic.htk.com.officproject.models.realm.Phone;
import offic.htk.com.officproject.models.realm.Website;
import offic.htk.com.officproject.utils.RecyclerViewDividerItemDecoration;

public class ContactDetailActivity extends BaseActivity implements View.OnClickListener {

    // id of each list
    private final int PHONE_LIST_ID = 1;
    private final int EMAIL_LIST_ID = 2;
    private final int IM_LIST_ID = 3;
    private final int WEBSITE_LIST_ID = 4;
    private final int ADDRESS_LIST_ID = 5;

    //linear layout
    LinearLayout ln_navi_note, ln_navi_list_people, ln_navi_deal;

    // array list
    private List<Phone> mPhoneList = new ArrayList<>();
    private List<Email> mEmailList = new ArrayList<>();
    private List<IM> mIMList = new ArrayList<>();
    private List<Website> mWebsiteList = new ArrayList<>();
    private List<Address> mAddressList = new ArrayList<>();

    //recyclerview
    private RecyclerView rcPhone, rcEmail, rcIM, rcWebsite, rcAddress;

    //    private CustomListViewAdapter mAdapter;
    private CustomRecyclerView mPhoneAdapter, mEmailAdapter, mIMAdapter, mWebsiteAdapter, mAddressAdapter;

    @Override
    protected void onCreate() {

    }

    @Override
    protected void initComponents() {

        // linear layout
        ln_navi_deal = (LinearLayout) findViewById(R.id.ln_navi_deal);
        ln_navi_list_people = (LinearLayout) findViewById(R.id.ln_navi_list_people);
        ln_navi_note = (LinearLayout) findViewById(R.id.ln_navi_note);
        ln_navi_deal.setOnClickListener(this);
        ln_navi_list_people.setOnClickListener(this);
        ln_navi_note.setOnClickListener(this);

        // recyclerview phone
        rcPhone = (RecyclerView) findViewById(R.id.rc_phone);
        rcPhone.setLayoutManager(new LinearLayoutManager(this));
        rcPhone.addItemDecoration(new RecyclerViewDividerItemDecoration(this,RecyclerViewDividerItemDecoration.VERTICAL_LIST));
        Phone phone = new Phone();
        phone.setCdValue("0987655");
        mPhoneList.add(phone);
        mPhoneAdapter = new CustomRecyclerView(this,mPhoneList,PHONE_LIST_ID);
        rcPhone.setAdapter(mPhoneAdapter);
        mPhoneAdapter.notifyDataSetChanged();

        // recyclerview email
        rcEmail = (RecyclerView) findViewById(R.id.rc_email);
        rcEmail.setLayoutManager(new LinearLayoutManager(this));
        rcEmail.addItemDecoration(new RecyclerViewDividerItemDecoration(this,RecyclerViewDividerItemDecoration.VERTICAL_LIST));
        Email email = new Email();
        email.setCdValue("trinhmv@gmail.com");
        mEmailList.add(email);
        mEmailAdapter = new CustomRecyclerView(this,mEmailList,EMAIL_LIST_ID);
        rcEmail.setAdapter(mEmailAdapter);
        mEmailAdapter.notifyDataSetChanged();

        // recyclerview im
        rcIM = (RecyclerView) findViewById(R.id.rc_im);
        rcIM.setLayoutManager(new LinearLayoutManager(this));
        rcIM.addItemDecoration(new RecyclerViewDividerItemDecoration(this,RecyclerViewDividerItemDecoration.VERTICAL_LIST));
        IM im = new IM();
        im.setCdValue("1111111");
        mIMList.add(im);
        mIMAdapter = new CustomRecyclerView(this,mIMList,IM_LIST_ID);
        rcIM.setAdapter(mIMAdapter);
        mIMAdapter.notifyDataSetChanged();

        // recyclerview website
        rcWebsite = (RecyclerView) findViewById(R.id.rc_website);
        rcWebsite.setLayoutManager(new LinearLayoutManager(this));
        rcWebsite.addItemDecoration(new RecyclerViewDividerItemDecoration(this,RecyclerViewDividerItemDecoration.VERTICAL_LIST));
        Website wb = new Website();
        wb.setCdValue("trinhmv.com");
        mWebsiteList.add(wb);
        mWebsiteAdapter = new CustomRecyclerView(this,mWebsiteList,WEBSITE_LIST_ID);
        rcWebsite.setAdapter(mWebsiteAdapter);
        mWebsiteAdapter.notifyDataSetChanged();

        // recyclerview address
        rcAddress = (RecyclerView) findViewById(R.id.rc_address);
        rcAddress.setLayoutManager(new LinearLayoutManager(this));
        rcAddress.addItemDecoration(new RecyclerViewDividerItemDecoration(this,RecyclerViewDividerItemDecoration.VERTICAL_LIST));
        Address address = new Address();
        address.setCdStreet("Le Do");
        address.setCdCity("Da Nang");
        address.setCdState("Da Nang");
        address.setCdZip("60000");
        address.setCdCountry("Viet Nam");
        mAddressList.add(address);
        mAddressAdapter = new CustomRecyclerView(this,mAddressList,ADDRESS_LIST_ID);
        rcAddress.setAdapter(mAddressAdapter);
    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_contact_detail;
    }

    public class CustomRecyclerView extends RecyclerView.Adapter<CustomRecyclerView.CustomViewHolder> implements View.OnClickListener {
        private Context context;
        private List<Phone> aPhoneList = new ArrayList<>();
        private List<Email> aEmailList = new ArrayList<>();
        private List<IM> aIMList = new ArrayList<>();
        private List<Website> aWebsiteList = new ArrayList<>();
        private List<Address> aAddressList = new ArrayList<>();
        private LayoutInflater mInflater;
        private int listID;

        public CustomRecyclerView(Context context, List list, int listID) {
            this.context = context;
            this.listID = listID;
            if(listID == 1){
                this.aPhoneList = list;
            }else if(listID == 2){
                this.aEmailList = list;
            }else if(listID == 3){
                this.aIMList = list;
            }else if(listID == 4){
                this.aWebsiteList = list;
            }else if(listID == 5){
                this.aAddressList = list;
            }else{
                Toast.makeText(context,"wrong list id", Toast.LENGTH_SHORT).show();
            }
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            if(listID == 5){
                view = mInflater.inflate(R.layout.custom_contact_detail_address_row, parent, false);
            }else if(listID == 1){
                view = mInflater.inflate(R.layout.custom_contact_detail_phone_row, parent, false);
            }else{
                view = mInflater.inflate(R.layout.custom_contact_detail_row, parent, false);
            }
            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            if(listID == 1){
                Phone mPhone = aPhoneList.get(position);
                holder.tv_value.setText(mPhone.getCdValue());
//                holder.tv_org.setText();
            }else if(listID == 2){
                Email mEmail = aEmailList.get(position);
                holder.tv_value.setText(mEmail.getCdValue());
//                holder.tv_org.setText();
            }else if(listID == 3){
                IM mIM = aIMList.get(position);
                holder.tv_value.setText(mIM.getCdValue());
//                holder.tv_org.setText(mIM.get);
//                holder.tv_type.setText();
            }else if(listID == 4){
                Website mWebsite = aWebsiteList.get(position);
                holder.tv_value.setText(mWebsite.getCdValue());
//                holder.tv_org.setText();
            }else if(listID == 5){
                Address mAddress = aAddressList.get(position);
                holder.tv_street.setText(mAddress.getCdStreet());
                holder.tv_city.setText(mAddress.getCdCity());
                holder.tv_state.setText(mAddress.getCdState());
                holder.tv_county.setText(mAddress.getCdCountry());
//                holder.tv_org.setText(mAddress.get);
            }else{
            }
        }

        @Override
        public int getItemCount() {
            if(listID == 1){
                return aPhoneList.size();
            }else if(listID == 2){
                return aEmailList.size();
            }else if(listID == 3){
                return aIMList.size();
            }else if(listID == 4){
                return aWebsiteList.size();
            }else if(listID == 5){
                return aAddressList.size();
            }else{
                return 0;
            }
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ln_value_org:
                    Log.d("adapter","click org " + listID);
                    break;
                case R.id.ln_value_type:
                    Log.d("adapter","click type " + listID);
                    break;
            }
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            TextView tv_org, tv_type, tv_value, tv_street, tv_city, tv_state, tv_county;
            public CustomViewHolder(View itemView) {
                super(itemView);
                tv_org = (TextView) itemView.findViewById(R.id.tv_org);
                tv_type = (TextView) itemView.findViewById(R.id.tv_type);
                tv_value = (TextView) itemView.findViewById(R.id.tv_value);
                tv_street = (TextView) itemView.findViewById(R.id.tv_address_street);
                tv_city = (TextView) itemView.findViewById(R.id.tv_address_city);
                tv_state = (TextView) itemView.findViewById(R.id.tv_address_state);
                tv_county = (TextView) itemView.findViewById(R.id.tv_address_country);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ln_navi_note:
                Intent note = new Intent(this, NotesActivity.class);
                startActivity(note);
                break;
            case R.id.ln_navi_list_people:
                break;
            case R.id.ln_navi_deal:
                break;
        }

    }
}
