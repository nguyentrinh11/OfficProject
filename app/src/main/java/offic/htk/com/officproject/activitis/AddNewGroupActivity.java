package offic.htk.com.officproject.activitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import offic.htk.com.officproject.R;

public class AddNewGroupActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTvCancel, mTvDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_group);
        mTvCancel = (TextView) findViewById(R.id.tv_cancel_add_new_group);
        mTvDone = (TextView) findViewById(R.id.tv_done_add_new_group);
        mTvCancel.setOnClickListener(this);
        mTvDone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel_add_new_group:
                AddNewGroupActivity.this.finish();
                break;
            case R.id.tv_done_add_new_group:
                break;
        }
    }
}
