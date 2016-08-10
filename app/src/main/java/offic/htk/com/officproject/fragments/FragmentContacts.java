package offic.htk.com.officproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;

import android.support.v7.app.AlertDialog;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.util.Attributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.activitis.AddNewCompanyActivity;
import offic.htk.com.officproject.activitis.MainActivity;
import offic.htk.com.officproject.adapters.CustomSwipeRecyclerViewAdapter;
import offic.htk.com.officproject.base.BaseFragment;
import offic.htk.com.officproject.popupwindow.QuickActionItem;
import offic.htk.com.officproject.popupwindow.QuickActionPopup;
import offic.htk.com.officproject.utils.RecyclerViewDividerItemDecoration;
import offic.htk.com.officproject.utils.Utils;

/**
 * Created by nguyen on 02/08/2016.
 */
public class FragmentContacts extends BaseFragment implements View.OnClickListener {
    private final String TAG = "FragmentContacts";
    private FragmentTabHost fragmentTabHost;
    private ImageView mImgAddNewContacts;
    private TextView mTvEditProfile;
    MainActivity mainActivity = (MainActivity) getActivity();

    SwipeLayout swipeLayout;
    RecyclerView reyclerView;
    List<String> list = new ArrayList<>();
    LinearLayout llSearch, layout_top, ll_tags, filter, cancel;
    SearchView searchView;
    Toolbar toolbar;


    //action id
    private static final int ID_ALL = 1;
    private static final int ID_COMPANY = 3;
    private static final int ID_PERSON = 2;
    private static final int ID_RECENTLY = 4;

    @Override
    protected void onCreate() {
//        fragmentTabHost = mainActivity.getFragmentTabHost();
//        fragmentTabHost.setVisibility(View.VISIBLE);
//        Log.d("contacts","tabhost + toolbar " + toolbar.getHeight());
//        toolbar = mainActivity.getToolbar();
//        toolbar.getHeight();
//        Log.d("contacts","tabhost + toolbar " + toolbar.getHeight());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);
        //layout search component
        filter = (LinearLayout) view.findViewById(R.id.bt_filter);
        llSearch = (LinearLayout) view.findViewById(R.id.llsearch);
        layout_top = (LinearLayout) view.findViewById(R.id.layout);
        cancel = (LinearLayout) view.findViewById(R.id.bt_cancel);
        searchView = (SearchView) view.findViewById(R.id.search_view);
        llSearch = (LinearLayout) view.findViewById(R.id.llsearch);
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.getHeight();
        mImgAddNewContacts = (ImageView) toolbar.findViewById(R.id.img_action_add);
        mImgAddNewContacts.setVisibility(View.VISIBLE);
        mTvEditProfile = (TextView) toolbar.findViewById(R.id.tv_action_edit);
        mTvEditProfile.setVisibility(View.GONE);
        mImgAddNewContacts.setOnClickListener(this);
        Log.d("contacts", "tabhost + toolbar " + toolbar.getHeight());
        // layout tags
        ll_tags = (LinearLayout) view.findViewById(R.id.ll_tags);


        reyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        popUpWindow();
        searchLayoutAnimation();
        setUpRecyclerView();
        setUpViewAlphabet(view);
        return view;
    }

    private void setUpViewAlphabet(View view) {
        View vA = view.findViewById(R.id.A);
        View vB = view.findViewById(R.id.B);
        View vC = view.findViewById(R.id.C);
        View vD = view.findViewById(R.id.D);
        View vE = view.findViewById(R.id.E);
        View vF = view.findViewById(R.id.F);
        View vG = view.findViewById(R.id.G);
        View vH = view.findViewById(R.id.H);
        View vI = view.findViewById(R.id.I);
        View vJ = view.findViewById(R.id.J);
        View vK = view.findViewById(R.id.K);
        View vL = view.findViewById(R.id.L);
        View vM = view.findViewById(R.id.M);
        View vN = view.findViewById(R.id.N);
        View vO = view.findViewById(R.id.O);
        View vP = view.findViewById(R.id.P);
        View vQ = view.findViewById(R.id.Q);
        View vR = view.findViewById(R.id.R);
        View vS = view.findViewById(R.id.S);
        View vT = view.findViewById(R.id.T);
        View vU = view.findViewById(R.id.U);
        View vV = view.findViewById(R.id.V);
        View vW = view.findViewById(R.id.W);
        View vX = view.findViewById(R.id.X);
        View vY = view.findViewById(R.id.Y);
        View vZ = view.findViewById(R.id.Z);
        View vDiff = view.findViewById(R.id.diff);
        vA.setOnClickListener(this);
        vB.setOnClickListener(this);
        vC.setOnClickListener(this);
        vD.setOnClickListener(this);
        vE.setOnClickListener(this);
        vF.setOnClickListener(this);
        vG.setOnClickListener(this);
        vH.setOnClickListener(this);
        vI.setOnClickListener(this);
        vJ.setOnClickListener(this);
        vK.setOnClickListener(this);
        vL.setOnClickListener(this);
        vM.setOnClickListener(this);
        vN.setOnClickListener(this);
        vO.setOnClickListener(this);
        vP.setOnClickListener(this);
        vQ.setOnClickListener(this);
        vR.setOnClickListener(this);
        vS.setOnClickListener(this);
        vT.setOnClickListener(this);
        vU.setOnClickListener(this);
        vV.setOnClickListener(this);
        vW.setOnClickListener(this);
        vX.setOnClickListener(this);
        vY.setOnClickListener(this);
        vZ.setOnClickListener(this);
        vDiff.setOnClickListener(this);

    }

    public void quickScroll(View v) {
        String firstLetter = (String) v.getTag();
        Log.d(TAG, "alphabet clicked " + firstLetter);

        if (list != null) {
            int index = -1;
            for (String string : list) {
                if (string.toLowerCase().startsWith(firstLetter.toLowerCase())) {

                    index = list.indexOf(string);
                    Log.d("index", index + "");
                    break;
                }
            }
            if (index >= 0) {
                reyclerView.scrollToPosition(index);
            }

        }

    }






    private void searchLayoutAnimation() {
        // animation button in anh out
        final Animation outtoLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoLeft.setDuration(1000);
        outtoLeft.setFillAfter(true);
        outtoLeft.setInterpolator(new AccelerateInterpolator());

        final Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromLeft.setDuration(1000);
        inFromLeft.setFillAfter(true);
        inFromLeft.setInterpolator(new AccelerateInterpolator());

        final Animation outtoRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoRight.setDuration(1000);
        outtoRight.setInterpolator(new AccelerateInterpolator());

        final Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromRight.setDuration(1000);
        inFromRight.setInterpolator(new AccelerateInterpolator());

        final Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(500);

        final Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
//        fadeOut.setStartOffset(300);
        fadeOut.setDuration(500);

        final AnimationSet fade = new AnimationSet(false); //change to false
        fade.addAnimation(fadeIn);
        fade.addAnimation(fadeOut);

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long wi = filter.getWidth();
                long he = toolbar.getHeight();
                toolbar.animate().x(0).y(-he).setDuration(300);
                toolbar.setVisibility(View.GONE);
                layout_top.animate().x(-wi).y(0).setDuration(300);
                layout_top.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                llSearch.setBackgroundResource(R.drawable.item_btn1);
                filter.startAnimation(outtoLeft);
                cancel.startAnimation(inFromRight);
                cancel.setVisibility(View.VISIBLE);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.setQuery("", false);
                searchView.clearFocus();
                searchView.setIconified(true);
                long he = toolbar.getHeight();
                toolbar.animate().x(0).y(0).setDuration(500);
                Runnable delay = new Runnable() {
                    @Override
                    public void run() {
                        toolbar.setVisibility(View.VISIBLE);
                    }
                };
                Handler handler = new Handler();
                handler.postDelayed(delay,400);
                layout_top.setBackgroundColor(getResources().getColor(R.color.search_ouside_background));
                filter.startAnimation(inFromLeft);
                filter.setVisibility(View.VISIBLE);
                cancel.startAnimation(outtoRight);
                cancel.setVisibility(View.GONE);
                layout_top.animate().x(0).y(0).setDuration(500);
            }
        });
    }

    public void setUpRecyclerView(){
        list.add("Mai Trinh");
        list.add("Nguyen Trinh");
        list.add("Ha Lam");
        list.add("Huy Hoang");
        list.add("Dinh Chien");
        list.add("Duc Phuoc");
        list.add("Da Nang");
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        reyclerView.setLayoutManager(layoutManager);
        reyclerView.addItemDecoration(new RecyclerViewDividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        CustomSwipeRecyclerViewAdapter adapter = new CustomSwipeRecyclerViewAdapter(getContext(),list);
        ((CustomSwipeRecyclerViewAdapter) adapter).setMode(Attributes.Mode.Single);
        adapter.notifyDataSetChanged();
        reyclerView.setAdapter(adapter);

        reyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("RecyclerView", "onScrollStateChanged");
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    private void popUpWindow() {
        final QuickActionItem allContacts = new QuickActionItem(ID_ALL, "All contacts", getResources().getDrawable(R.drawable.op_all));
        QuickActionItem companyConstacts = new QuickActionItem(ID_COMPANY, "Only person contacts", getResources().getDrawable(R.drawable.op_person));
        QuickActionItem personContacts = new QuickActionItem(ID_PERSON, "Only company contacts", getResources().getDrawable(R.drawable.op_company));
        QuickActionItem recentlyContacts = new QuickActionItem(ID_RECENTLY, "Recently added contacts", getResources().getDrawable(R.drawable.op_recently));
//create QuickActionPopup. Use QuickActionPopup.VERTICAL or QuickActionPopup.HORIZONTAL //param to define orientation
        final QuickActionPopup quickActionPopup1 = new QuickActionPopup(getContext(), QuickActionPopup.VERTICAL);

        //add action items into QuickActionPopup
        quickActionPopup1.addActionItem(allContacts);
        quickActionPopup1.addActionItem(companyConstacts);
        quickActionPopup1.addActionItem(personContacts);
        quickActionPopup1.addActionItem(recentlyContacts);

        //Set listener for action item clicked
        quickActionPopup1.setOnActionItemClickListener(new QuickActionPopup.OnActionItemClickListener() {
            @Override
            public void onItemClick(QuickActionPopup source, int pos, int actionId, LinearLayout img) {
                //filtering items by id
                if (actionId == ID_ALL) {
                    Toast.makeText(getContext(), "all clicked", Toast.LENGTH_SHORT).show();
                } else if (actionId == ID_COMPANY) {
                    Toast.makeText(getContext(), "peson clicked", Toast.LENGTH_SHORT).show();
                } else if (actionId == ID_PERSON) {
                    Toast.makeText(getContext(), "company clicked", Toast.LENGTH_SHORT).show();
                } else if (actionId == ID_RECENTLY) {
                    Toast.makeText(getContext(), "recently clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //set dismiss listener
        quickActionPopup1.setOnDismissListener(new QuickActionPopup.OnDismissListener() {
            @Override
            public void onDismiss() {
                Toast.makeText(getContext(), "Dismissed", Toast.LENGTH_SHORT).show();
            }
        });

        //show on btn1
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quickActionPopup1.show(v);
            }
        });
    }

    @Override
    protected void initComponents(View view) {
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_contacts;
    }

    private void createDialog() {
        TextView tvAddNewPerson, tvAddNewCompany, tvCancelDialog;
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View yourCustomView = inflater.inflate(R.layout.dialog_add_new, null);

        final AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setView(yourCustomView).create();
        Window window = dialog.getWindow();
        dialog.setCancelable(false);
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(wlp);
        tvAddNewPerson = (TextView) yourCustomView.findViewById(R.id.tv_add_new_person);
        tvAddNewCompany = (TextView) yourCustomView.findViewById(R.id.tv_add_new_company);
        tvCancelDialog = (TextView) yourCustomView.findViewById(R.id.tv_cancel_dialog);
        tvAddNewCompany.setOnClickListener(this);
        tvAddNewPerson.setOnClickListener(this);
        tvCancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.A:
            case R.id.B:
            case R.id.C:
            case R.id.D:
            case R.id.E:
            case R.id.F:
            case R.id.G:
            case R.id.H:
            case R.id.I:
            case R.id.J:
            case R.id.K:
            case R.id.L:
            case R.id.M:
            case R.id.N:
            case R.id.O:
            case R.id.P:
            case R.id.Q:
            case R.id.R:
            case R.id.S:
            case R.id.T:
            case R.id.U:
            case R.id.V:
            case R.id.W:
            case R.id.X:
            case R.id.Y:
            case R.id.Z:
            case R.id.diff:
                quickScroll(v);
                break;
            case R.id.img_action_add:
                createDialog();
                break;
            case R.id.tv_add_new_person:
                break;
            case R.id.tv_add_new_company:
                startActivity(new Intent(getContext(), AddNewCompanyActivity.class));
                break;

        }
    }
}
