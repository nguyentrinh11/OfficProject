package offic.htk.com.officproject.activitis;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.base.BaseActivity;

/**
 * Created by nguyen on 04/08/2016.
 */
public class AddNewCompanyActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout mContainerView, lnAdd;
    private View mExclusiveEmptyView;
    private TextView tvCancel, tvDone;

    @Override
    protected void onCreate() {


    }

    public void onAddNewClicked(View v) {
        inflateEditRow(null);
        v.setVisibility(View.VISIBLE);

    }

    public void onDeleteClicked(View v) {
        mContainerView.removeView((View) v.getParent());
    }

    @Override
    protected void initComponents() {
        mContainerView = (LinearLayout) findViewById(R.id.ln_add_phone);
        lnAdd = (LinearLayout) findViewById(R.id.ln_add);
        tvCancel = (TextView) findViewById(R.id.tv_cancel);
        tvDone = (TextView) findViewById(R.id.tv_done);
        tvCancel.setOnClickListener(this);
        tvDone.setOnClickListener(this);

    }

    private void inflateEditRow(String name) {

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.item_row, null);
//        spinner = (Spinner) rowView.findViewById(R.id.spinnerCategory);
//        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.categories, R.layout.item_spinner);
//        adapter.setDropDownViewResource(R.layout.item_spinner);
//        spinner.setAdapter(adapter);
        final ImageView deleteButton = (ImageView) rowView.findViewById(R.id.buttonDelete);
        final EditText editText = (EditText) rowView
                .findViewById(R.id.editText);

        if (name != null && !name.isEmpty()) {
            editText.setText(name);
        } else {
            mExclusiveEmptyView = rowView;
            deleteButton.setVisibility(View.INVISIBLE);
        }


        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().isEmpty()) {
                    lnAdd.setVisibility(View.GONE);
                    deleteButton.setVisibility(View.INVISIBLE);

                    if (mExclusiveEmptyView != null
                            && mExclusiveEmptyView != rowView) {
                        mContainerView.removeView(mExclusiveEmptyView);
                    }
                    mExclusiveEmptyView = rowView;
                } else {

                    if (mExclusiveEmptyView == rowView) {
                        mExclusiveEmptyView = null;
                    }
                    lnAdd.setVisibility(View.VISIBLE);
                    deleteButton.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }
        });

        mContainerView.addView(rowView, mContainerView.getChildCount() - 1);

    }

    @Override
    protected int getLayoutRescource() {
        return R.layout.activity_add_new_company;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                AddNewCompanyActivity.this.finish();
                break;
            case R.id.tv_done:
                break;
            default:
                break;
        }

    }
}
