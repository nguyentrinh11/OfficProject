package offic.htk.com.officproject.activitis;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
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

/**
 * Created by nguyen on 04/08/2016.
 *
 * edit by Mai on 09/08/2016
 */
public class AddNewCompanyActivity extends BaseActivity implements View.OnClickListener {
    // view compnent
    private LinearLayout  lnAddPhone,lnAddEmail,lnAddIM,lnAddWebsite,lnAddAddress, mRootLayout;
    private RecyclerView rcPhone, rcEmail, rcIM, rcWebsite, rcAddress;

    // array list
    private List<Phone> mPhoneList = new ArrayList<>();
    private List<Email> mEmailList = new ArrayList<>();
    private List<IM> mIMList = new ArrayList<>();
    private List<Website> mWebsiteList = new ArrayList<>();
    private List<Address> mAddressList = new ArrayList<>();
    private LinearLayout mContainerView, lnAdd;
    private View mExclusiveEmptyView;
    private TextView tvCancel, tvDone;

    //    private CustomListViewAdapter mAdapter;
    private CustomRecyclerView mPhoneAdapter, mEmailAdapter, mIMAdapter, mWebsiteAdapter, mAddressAdapter;

    // id of each list
    private final int PHONE_LIST_ID = 1;
    private final int EMAIL_LIST_ID = 2;
    private final int IM_LIST_ID = 3;
    private final int WEBSITE_LIST_ID = 4;
    private final int ADDRESS_LIST_ID = 5;

    private  View focus = getCurrentFocus();

    @Override
    protected void onCreate() {

    }

    public void onDeleteClicked(View v) {
        mContainerView.removeView((View) v.getParent());
    }

    @Override
    protected void initComponents() {

        tvCancel = (TextView) findViewById(R.id.tv_cancel);
        tvDone = (TextView) findViewById(R.id.tv_done);
        tvCancel.setOnClickListener(this);
        tvDone.setOnClickListener(this);
        //linearlayout
        mRootLayout = (LinearLayout) findViewById(R.id.root_ln);
        lnAddPhone = (LinearLayout) findViewById(R.id.ln_add_phone);
        lnAddEmail = (LinearLayout) findViewById(R.id.ln_add_email);
        lnAddIM = (LinearLayout) findViewById(R.id.ln_add_im);
        lnAddWebsite = (LinearLayout) findViewById(R.id.ln_add_website);
        lnAddAddress = (LinearLayout) findViewById(R.id.ln_add_address);
        mContainerView = (LinearLayout) findViewById(R.id.ln_add_phone);

        mRootLayout.setOnClickListener(this);
        lnAddPhone.setOnClickListener(this);
        lnAddEmail.setOnClickListener(this);
        lnAddIM.setOnClickListener(this);
        lnAddWebsite.setOnClickListener(this);
        lnAddAddress.setOnClickListener(this);

        // recyclerview phone
        rcPhone = (RecyclerView) findViewById(R.id.rc_phone);
        rcPhone.setLayoutManager(new LinearLayoutManager(this));
        rcPhone.addItemDecoration(new RecyclerViewDividerItemDecoration(this,RecyclerViewDividerItemDecoration.VERTICAL_LIST));
//        Phone phone = new Phone();
//        phone.setCdValue("0987655");
//        mPhoneList.add(phone);
        mPhoneAdapter = new CustomRecyclerView(this,mPhoneList,PHONE_LIST_ID);
        rcPhone.setAdapter(mPhoneAdapter);
        mPhoneAdapter.notifyDataSetChanged();

        // recyclerview email
        rcEmail = (RecyclerView) findViewById(R.id.rc_email);
        rcEmail.setLayoutManager(new LinearLayoutManager(this));
        rcEmail.addItemDecoration(new RecyclerViewDividerItemDecoration(this,RecyclerViewDividerItemDecoration.VERTICAL_LIST));
//        Email email = new Email();
//        email.setCdValue("trinhmv@gmail.com");
//        mEmailList.add(email);
        mEmailAdapter = new CustomRecyclerView(this,mEmailList,EMAIL_LIST_ID);
        rcEmail.setAdapter(mEmailAdapter);
        mEmailAdapter.notifyDataSetChanged();

        // recyclerview im
        rcIM = (RecyclerView) findViewById(R.id.rc_im);
        rcIM.setLayoutManager(new LinearLayoutManager(this));
        rcIM.addItemDecoration(new RecyclerViewDividerItemDecoration(this,RecyclerViewDividerItemDecoration.VERTICAL_LIST));
//        IM im = new IM();
//        im.setCdValue("1111111");
//        mIMList.add(im);
        mIMAdapter = new CustomRecyclerView(this,mIMList,IM_LIST_ID);
        rcIM.setAdapter(mIMAdapter);
        mIMAdapter.notifyDataSetChanged();

        // recyclerview website
        rcWebsite = (RecyclerView) findViewById(R.id.rc_website);
        rcWebsite.setLayoutManager(new LinearLayoutManager(this));
        rcWebsite.addItemDecoration(new RecyclerViewDividerItemDecoration(this,RecyclerViewDividerItemDecoration.VERTICAL_LIST));
//        Website wb = new Website();
//        wb.setCdValue("trinhmv.com");
//        mWebsiteList.add(wb);
        mWebsiteAdapter = new CustomRecyclerView(this,mWebsiteList,WEBSITE_LIST_ID);
        rcWebsite.setAdapter(mWebsiteAdapter);
        mWebsiteAdapter.notifyDataSetChanged();

        // recyclerview address
        rcAddress = (RecyclerView) findViewById(R.id.rc_address);
        rcAddress.setLayoutManager(new LinearLayoutManager(this));
        rcAddress.addItemDecoration(new RecyclerViewDividerItemDecoration(this,RecyclerViewDividerItemDecoration.VERTICAL_LIST));
//        Address address = new Address();
//        address.setCdStreet("Le Do");
//        address.setCdCity("Da Nang");
//        address.setCdState("Da Nang");
//        address.setCdZip("60000");
//        address.setCdCountry("Viet Nam");
//        mAddressList.add(address);
        mAddressAdapter = new CustomRecyclerView(this,mAddressList,ADDRESS_LIST_ID);
        rcAddress.setAdapter(mAddressAdapter);
        mAddressAdapter.notifyDataSetChanged();
    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_add_new_company;
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
                view = mInflater.inflate(R.layout.add_contact_address_item_row, parent, false);
            }else if(listID == 3){
                view = mInflater.inflate(R.layout.add_contact_im_item_row, parent, false);
            }else{
                view = mInflater.inflate(R.layout.add_contact_info_item_row, parent, false);
            }
            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            if(listID == 1){
                Phone mPhone = aPhoneList.get(position);
                holder.edt_value.setHint("Add Phone");
                holder.edt_value.setText(mPhone.getCdValue());
//                holder.tv_org.setText();

                holder.ln_org.setOnClickListener(this);
                holder.imgDelete.setOnClickListener(this);
            }else if(listID == 2){
                Email mEmail = aEmailList.get(position);
                holder.edt_value.setHint("Add Email");
                holder.edt_value.setText(mEmail.getCdValue());
//                holder.tv_org.setText();

                holder.ln_org.setOnClickListener(this);
                holder.imgDelete.setOnClickListener(this);
            }else if(listID == 3){
                IM mIM = aIMList.get(position);
                holder.edt_value.setHint("Add IM");
                holder.edt_value.setText(mIM.getCdValue());
//                holder.tv_org.setText(mIM.get);
//                holder.tv_type.setText();

                holder.ln_org.setOnClickListener(this);
                holder.ln_type.setOnClickListener(this);
                holder.imgDelete.setOnClickListener(this);
            }else if(listID == 4){
                Website mWebsite = aWebsiteList.get(position);
                holder.edt_value.setHint("Add Website");
                holder.edt_value.setText(mWebsite.getCdValue());
//                holder.tv_org.setText();

                holder.ln_org.setOnClickListener(this);
                holder.imgDelete.setOnClickListener(this);
            }else if(listID == 5){
                Address mAddress = aAddressList.get(position);
                holder.edtStreet.setText(mAddress.getCdStreet());
                holder.edtCity.setText(mAddress.getCdCity());
                holder.edtState.setText(mAddress.getCdState());
                holder.edtZip.setText(mAddress.getCdZip());
                holder.edtCountry.setText(mAddress.getCdCountry());
//                holder.tv_org.setText();

                holder.ln_org.setOnClickListener(this);
                holder.imgDelete.setOnClickListener(this);
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
                    break;
                case R.id.ln_value_type:
                    break;
            }
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            EditText edt_value, edtStreet, edtCity, edtState, edtZip, edtCountry;
            LinearLayout ln_org, ln_type, ln_country;
            ImageView imgDelete;
            TextView tv_org, tv_type;
            public CustomViewHolder(View itemView) {
                super(itemView);

                imgDelete = (ImageView) itemView.findViewById(R.id.buttonDelete);
                edt_value = (EditText) itemView.findViewById(R.id.edt_value);
                ln_org = (LinearLayout) itemView.findViewById(R.id.ln_value_org);
                ln_type = (LinearLayout) itemView.findViewById(R.id.ln_value_type);
                tv_org = (TextView) itemView.findViewById(R.id.tv_org);
                tv_type = (TextView) itemView.findViewById(R.id.tv_type);

                // view holder address
                edtStreet = (EditText) itemView.findViewById(R.id.edt_address_street);
                edtState = (EditText) itemView.findViewById(R.id.edt_address_state);
                edtZip = (EditText) itemView.findViewById(R.id.edt_address_zip);
                edtCity = (EditText) itemView.findViewById(R.id.edt_address_city);
                edtCountry = (EditText) itemView.findViewById(R.id.edt_address_country);
                ln_country = (LinearLayout) itemView.findViewById(R.id.ln_country);
            }
        }
    }

    public void hideSoftKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager)
                getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),0);
    }

    /*
    * check input of the value is valid and add new row for user add new or edit value
    *
    *@param adapter are different adapter of the different recyclerview inclue: phone, email, im, website, address
    *@param recyclerView are recycler for each model
    *@param list are list of different model: phone, email, im, website, address.
    *@param listID an int value for check what model are interactive
    *
    **/
    public void isInputValid(CustomRecyclerView adapter, RecyclerView recyclerView, List list, int listID) {
        int listSize = adapter.getItemCount();
        // value in edit text for phone, email, im, website
        EditText edt = (EditText) recyclerView.getChildAt(listSize - 1).findViewById(R.id.edt_value);
        // value in edit text for address
        EditText edtStreet = (EditText) recyclerView.getChildAt(listSize - 1).findViewById(R.id.edt_address_street);
        EditText edtCity = (EditText) recyclerView.getChildAt(listSize - 1).findViewById(R.id.edt_address_city);
        EditText edtState = (EditText) recyclerView.getChildAt(listSize - 1).findViewById(R.id.edt_address_state);
        EditText edtZip = (EditText) recyclerView.getChildAt(listSize - 1).findViewById(R.id.edt_address_zip);
        EditText edtCountry = (EditText) recyclerView.getChildAt(listSize - 1).findViewById(R.id.edt_address_country);

        if (listSize >= 1) {
            if (listID == ADDRESS_LIST_ID) {
                if ((edtStreet.getText().toString().trim().length() < 1)) {
                    edtStreet.setFocusable(true);
                    edtStreet.setError("Please enter street");
                } else if (edtCity.getText().toString().trim().length() < 1) {
                    edtStreet.setFocusable(true);
                    edtCity.setError("Please enter city");
                } else if (edtState.getText().toString().trim().length() < 1) {
                    edtStreet.setFocusable(true);
                    edtState.setError("Please enter state");
                } else if (edtZip.getText().toString().trim().length() < 1) {
                    edtStreet.setFocusable(true);
                    edtZip.setError("Please enter zip");
                } else if (edtCountry.getText().toString().trim().length() < 1) {
                    edtStreet.setFocusable(true);
                    edtCountry.setError("Please select country");
                } else {
                    List<Address> addressList = list;
                    addressList.get(listSize - 1).setCdStreet(edtStreet.getText().toString());
                    addressList.get(listSize - 1).setCdCity(edtCity.getText().toString());
                    addressList.get(listSize - 1).setCdState(edtState.getText().toString());
                    addressList.get(listSize - 1).setCdZip(edtZip.getText().toString());
                    addressList.get(listSize - 1).setCdCountry(edtCountry.getText().toString());
                    Address address = new Address();
                    addressList.add(address);
                    adapter.notifyDataSetChanged();
                }
            } else {
                if (edt.getText().toString().trim().length() < 1) {
                    edt.setError("Please Enter Item");
                } else {
                    if (listID == PHONE_LIST_ID) {
                        List<Phone> phoneList = list;
                        phoneList.get(listSize - 1).setCdValue(edt.getText().toString());
                        Phone phone = new Phone();
                        phoneList.add(phone);
                        adapter.notifyDataSetChanged();
                    } else if (listID == EMAIL_LIST_ID) {
                        List<Email> emailList = list;
                        emailList.get(listSize - 1).setCdValue(edt.getText().toString());
                        Email email = new Email();
                        emailList.add(email);
                        adapter.notifyDataSetChanged();
                    } else if (listID == IM_LIST_ID) {
                        List<IM> imList = list;
                        imList.get(listSize - 1).setCdValue(edt.getText().toString());
                        IM im = new IM();
                        imList.add(im);
                        adapter.notifyDataSetChanged();
                    } else if (listID == WEBSITE_LIST_ID) {
                        List<Website> webList = list;
                        webList.get(listSize - 1).setCdValue(edt.getText().toString());
                        Website wb = new Website();
                        webList.add(wb);
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        } else if (listSize == 0) {
            if (listID == PHONE_LIST_ID) {
                Phone phone = new Phone();
                List<Phone> phoneList = list;
                phoneList.add(phone);
                adapter.notifyDataSetChanged();
            } else if (listID == EMAIL_LIST_ID) {
                Email email = new Email();
                List<Email> emailList = list;
                emailList.add(email);
                adapter.notifyDataSetChanged();
            } else if (listID == IM_LIST_ID) {
                IM im = new IM();
                List<IM> imList = list;
                imList.add(im);
                adapter.notifyDataSetChanged();
            } else if (listID == WEBSITE_LIST_ID) {
                Website wb = new Website();
                List<Website> webList = list;
                webList.add(wb);
                adapter.notifyDataSetChanged();
            } else if (listID == ADDRESS_LIST_ID) {
                Address address = new Address();
                List<Address> addressList = list;
                addressList.add(address);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ln_add_phone:
                isInputValid(mPhoneAdapter,rcPhone,mPhoneList,PHONE_LIST_ID);
                break;
            case R.id.ln_add_email:
                isInputValid(mEmailAdapter,rcEmail,mEmailList,EMAIL_LIST_ID);
                break;
            case R.id.ln_add_im:
                isInputValid(mIMAdapter,rcIM,mIMList,IM_LIST_ID);
                break;
            case R.id.ln_add_website:
                isInputValid(mWebsiteAdapter,rcWebsite,mWebsiteList,WEBSITE_LIST_ID);
                break;
            case R.id.ln_add_address:
                isInputValid(mAddressAdapter,rcAddress,mAddressList,ADDRESS_LIST_ID);
                break;
            case R.id.root_ln:
                Log.d("add person ","click");
                if(focus != null){
                    focus.clearFocus();
                    hideSoftKeyboard(this);
                }
                break;
        }
    }
}
