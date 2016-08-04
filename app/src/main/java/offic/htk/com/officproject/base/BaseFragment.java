package offic.htk.com.officproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import offic.htk.com.officproject.R;

/**
 * Created by nguyen on 02/08/2016.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);
        getActivity().overridePendingTransition(R.anim.in_from_left, R.anim.out_from_right);
        onCreate();
        initComponents(view);
        return view;
    }

    protected abstract void onCreate();


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        getActivity().overridePendingTransition(R.anim.in_from_left, R.anim.out_from_right);

    }

    @Override
    public void onResume() {
        super.onResume();
    }


    protected abstract void initComponents(View view);

    protected abstract int getLayoutResource();
}
