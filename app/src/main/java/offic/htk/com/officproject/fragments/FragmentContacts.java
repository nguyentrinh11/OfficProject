package offic.htk.com.officproject.fragments;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.util.Attributes;

import java.util.ArrayList;
import java.util.List;

import offic.htk.com.officproject.R;
import offic.htk.com.officproject.activitis.MainActivity;
import offic.htk.com.officproject.adapters.CustomSwipeRecyclerViewAdapter;
import offic.htk.com.officproject.base.BaseFragment;
import offic.htk.com.officproject.popupwindow.QuickActionItem;
import offic.htk.com.officproject.popupwindow.QuickActionPopup;
import offic.htk.com.officproject.utils.RecyclerViewDividerItemDecoration;

/**
 * Created by nguyen on 02/08/2016.
 */
public class FragmentContacts extends BaseFragment {
    private FragmentTabHost fragmentTabHost;
    MainActivity mainActivity = (MainActivity) getActivity();

    SwipeLayout swipeLayout;
    RecyclerView reyclerView;
    List<String> list = new ArrayList<>();
    LinearLayout llSearch,layout_top, ll_tags, filter, cancel;
    SearchView searchView;
    Toolbar toolbar;

    //action id
    private static final int ID_ALL    = 1;
    private static final int ID_COMPANY   = 3;
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
        View view = inflater.inflate(R.layout.fragment_contacts,container,false);
        //layout search component
        filter = (LinearLayout) view.findViewById(R.id.bt_filter);
        llSearch = (LinearLayout) view.findViewById(R.id.llsearch);
        layout_top = (LinearLayout) view.findViewById(R.id.layout);
        cancel = (LinearLayout) view.findViewById(R.id.bt_cancel);
        searchView = (SearchView) view.findViewById(R.id.search_view);
        llSearch = (LinearLayout) view.findViewById(R.id.llsearch);
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.getHeight();
        Log.d("contacts","tabhost + toolbar " + toolbar.getHeight());
        // layout tags
        ll_tags = (LinearLayout) view.findViewById(R.id.ll_tags);

        reyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        popUpWindow();
        searchLayoutAnimation();
        setUpRecyclerView();

        return view;
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
                } else if(actionId == ID_PERSON){
                    Toast.makeText(getContext(), "company clicked", Toast.LENGTH_SHORT).show();
                } else if(actionId == ID_RECENTLY){
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
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View yourCustomView = inflater.inflate(R.layout.dialog_add_new, null);

//        final TextView etName = (EditText) yourCustomView.findViewById(R.id.EditZip);
        final AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setView(yourCustomView).create();
        dialog.show();
    }
}
