package offic.htk.com.officproject.popupwindow;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import offic.htk.com.officproject.R;

import static android.view.ViewGroup.MarginLayoutParams;

/**
 * Created by Mai Trinh on 7/29/2016.
 */
public class QuickActionPopup extends MyPopupWindow implements OnDismissListener {
    private View mRootView;
    private ImageView mArrowUp;
    private ImageView mArrowDown;
    private LayoutInflater mInflater;
    private ViewGroup mTrack;
    private ScrollView mScroller;

    private OnActionItemClickListener mItemClickListener;
    private OnDismissListener mDismissListener;

    private List<QuickActionItem> actionItems = new ArrayList<QuickActionItem>();

    private boolean mDidAction;
    private boolean reverseOrientationItem = false;

    private int mChildPos;
    private int mInsertPos;
    private int mAnimStyle;
    private int mOrientation;
    private int rootWidth=0;


    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    public static final int ANIM_GROW_FROM_LEFT = 1;


    final int[] lastPos = {-1};


    /**
     * Constructor for default vertical layout
     *
     * @param context  Context
     */
    public QuickActionPopup(Context context) {
        this(context, VERTICAL);
    }






    /**
     * Constructor allowing orientation override
     *
     * @param context    Context
     * @param orientation Layout orientation, can be vartical or horizontal
     */
    public QuickActionPopup(Context context, int orientation) {
        super(context);

        mOrientation = orientation;

        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (mOrientation == HORIZONTAL) {
            setRootViewId(R.layout.popup_horizontal);
        } else {
            setRootViewId(R.layout.popup_vertical);
        }

        mAnimStyle  = ANIM_GROW_FROM_LEFT;
        mChildPos   = 0;
    }

    /**
     * Set the background of the popup and the two arrows. Must be 9-patch.
     * @param popup
     * @param arrowUp
     * @param arrowDown
     */
    public void setBackgroundResources(int popup, int arrowUp, int arrowDown){

        if(popup!=0 && arrowUp!=0 && arrowDown!=0){

            mScroller.setBackgroundResource(popup);
            mArrowDown.setImageResource(arrowDown);
            mArrowUp.setImageResource(arrowUp);

        }
    }


    /**
     * Get action item at an index
     *
     * @param index  Index of item (position from callback)
     *
     * @return  Action Item at the position
     */
    public QuickActionItem getActionItem(int index) {
        return actionItems.get(index);
    }

    public View editActionItem(int index, View container){
//        QuickActionItem item = getActionItem(index);
//        container.
        return container;
    }

    /**
     * Set root view.
     *
     * @param id Layout resource id
     */
    private void setRootViewId(int id) {
        mRootView   = (ViewGroup) mInflater.inflate(id, null);
        mTrack  = (ViewGroup) mRootView.findViewById(R.id.tracks);
        mArrowDown  = (ImageView) mRootView.findViewById(R.id.arrow_down);
        mArrowUp    = (ImageView) mRootView.findViewById(R.id.arrow_up);
        mScroller   = (ScrollView) mRootView.findViewById(R.id.scroller);
        mRootView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        setContentView(mRootView);
    }

    /**
     * Set animation style
     *
     * @param mAnimStyle animation style, default is set to ANIM_AUTO
     */
    public void setAnimStyle(int mAnimStyle) {
        this.mAnimStyle = mAnimStyle;
    }

    /**
     * Set listener for action item clicked.
     *
     * @param listener Listener
     */
    public void setOnActionItemClickListener(OnActionItemClickListener listener) {
        mItemClickListener = listener;
    }

    /**
     * Add action item
     *
     * @param action  {@link QuickActionItem}
     */
    public void addActionItem(QuickActionItem action) {
        View container;
        if (mOrientation == HORIZONTAL && !reverseOrientationItem) {
            container = mInflater.inflate(R.layout.action_item_horizontal, null);
        } else {
            container = mInflater.inflate(R.layout.action_item_vertical, null);
        }
        final ImageView img   = (ImageView) container.findViewById(R.id.img_org_icon);
        TextView text   = (TextView) container.findViewById(R.id.tv_title);
        final ImageView checked = (ImageView) container.findViewById(R.id.img_org_checked);
        final LinearLayout llOrg = (LinearLayout) container.findViewById(R.id.ll_org);
//        container.on
        actionItems.add(action);
//        final ListView listview;
        String title    = action.getTitle();
        Drawable icon   = action.getIcon();

        if (icon != null) {
            img.setImageDrawable(icon);
        } else {
            img.setVisibility(View.GONE);
        }
        if (title != null) {
            text.setText(title);
        } else {
            text.setVisibility(View.GONE);
        }

        final int pos   =  mChildPos;
        final int actionId  = action.getActionId();
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("list item size ", " " + actionItems.size());
            }
        });
        llOrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(QuickActionPopup.this, pos, actionId, llOrg);
                    Log.d("popup","position " + pos);
                    if(!getActionItem(pos).isSticky()){
                        mDidAction = true;
                        checked.setVisibility(View.VISIBLE);
                        checked.setImageResource(R.drawable.check);
                        editItem(lastPos[0]);
                        dismiss();
                    }
                    lastPos[0] = pos;
                }
            }
        });

        container.setFocusable(true);
        container.setClickable(true);
        mTrack.addView(container, mInsertPos);
        mChildPos++;
        mInsertPos++;
    }

    public void editItem(int position){
        if(lastPos[0] >= 0){
            actionItems.get(position);
            Log.d("edit last position"," " + position);
            mTrack.getChildAt(position).findViewById(R.id.img_org_checked).setVisibility(View.GONE);
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        View view;
    }

    /**
     * Show quickaction popup. Popup is automatically positioned, on top or bottom of anchor
     *
     */
    public void show (View anchor) {
        preShow();
        int xPos, yPos, arrowPosx, arrowPosy = 0;
        mDidAction          = false;
        int[] location      = new int[2];
        anchor.getLocationOnScreen(location);
        Rect anchorRect = new Rect(location[0], location[1], location[0] + anchor.getWidth(), location[1] + anchor.getHeight());
        mRootView.measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        int rootHeight = mRootView.getMeasuredHeight();
        if (rootWidth == 0) {
            rootWidth   = mRootView.getMeasuredWidth();
        }
        int screenWidth     = mWindowManager.getDefaultDisplay().getWidth();
        int screenHeight    = mWindowManager.getDefaultDisplay().getHeight();

        if ((anchorRect.left + rootWidth) > screenWidth) {
            xPos        = anchorRect.left - (rootWidth-anchor.getWidth());
            xPos        = (xPos < 0) ? 0 : xPos;
            arrowPosx    = anchorRect.centerX()-xPos;
        } else {
            if (anchor.getWidth() > rootWidth) {
                xPos = anchorRect.centerX() - (rootWidth/2);
            } else {
                xPos = anchorRect.left;
            }
            arrowPosx = anchorRect.centerX()-xPos;
        }

        int dyTop = anchorRect.top;
        int dyBottom = screenHeight - anchorRect.bottom;

        boolean onTop = (dyTop > dyBottom) ? true : false;

        if (onTop) {
            if (rootHeight > dyTop) {
                yPos            = 15;
                LayoutParams l  = mScroller.getLayoutParams();
                l.height = dyTop - anchor.getHeight();
                arrowPosy = anchorRect.centerY() - yPos;
            } else {
                yPos = anchorRect.top - rootHeight;
                arrowPosy = anchorRect.centerY() - yPos;
            }
        } else {
            yPos = anchorRect.bottom;

            if (rootHeight > dyBottom) {
                LayoutParams l  = mScroller.getLayoutParams();
                l.height = dyBottom;
                arrowPosy = anchorRect.centerY() - yPos;
            }
        }

        showArrow(((onTop) ? R.id.arrow_down : R.id.arrow_up), arrowPosx, arrowPosy);

        setAnimationStyle(screenWidth, anchorRect.centerX(), onTop);

        mWindow.showAtLocation(anchor, Gravity.NO_GRAVITY, xPos, yPos);

        Log.d("QuicActionPopup","root width " + rootWidth);
        Log.d("QuicActionPopup","root height " + rootWidth);
        Log.d("QuicActionPopup","root screen width " + screenWidth);
        Log.d("QuicActionPopup","x pos " + xPos);
        Log.d("QuicActionPopup","y pos " + yPos);
        Log.d("QuicActionPopup","dy top " + dyTop);
        Log.d("QuicActionPopup","y pos " + arrowPosx);
        Log.d("QuicActionPopup","anchorRect " + anchorRect);
        Log.d("QuicActionPopup","anchor get height " + anchor.getHeight());
        Log.d("QuicActionPopup","anchorRect center x " + anchorRect.centerX());
    }

    /**
     * Set animation style
     *
     * @param screenWidth screen width
     * @param requestedX distance from left edge
     * @param onTop flag to indicate where the popup should be displayed. Set TRUE if  *displayed on top of anchor view and vice versa
     */

    private void setAnimationStyle(int screenWidth, int requestedX, boolean onTop) {
        int arrowPos = requestedX - mArrowUp.getMeasuredWidth()/2;

        switch (mAnimStyle) {
            case ANIM_GROW_FROM_LEFT:
                mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Left : R.style.Animations_PopDownMenu_Left);
                break;
        }
    }


    private void showArrow(int whichArrow, int requestedX, int requestedY) {

        final View showArrow = (whichArrow == R.id.arrow_up) ? mArrowUp : mArrowDown;
        final View hideArrow = (whichArrow == R.id.arrow_up) ? mArrowDown : mArrowUp;

        final int arrowWidth = mArrowUp.getMeasuredWidth();
        final int arrowHeight = mArrowUp.getMeasuredHeight();

        showArrow.setVisibility(View.VISIBLE);

        MarginLayoutParams param = (MarginLayoutParams)showArrow.getLayoutParams();

        param.leftMargin = requestedX - arrowWidth / 2;
        param.topMargin = requestedY - arrowHeight / 4;

        hideArrow.setVisibility(View.INVISIBLE);
    }

    /**
     * Listener for dismissing the window.
     */

    public void setOnDismissListener(QuickActionPopup.OnDismissListener listener) {
        setOnDismissListener(this);
        mDismissListener = listener;
        Log.d("set ondismiss"," dismiss");
        editItem(lastPos[0]);
    }

    @Override
    public void onDismiss() {
        if (!mDidAction && mDismissListener != null) {
            Log.d("ondismiss"," dismiss");
            editItem(lastPos[0]);
            mDismissListener.onDismiss();
        }
    }

    /**
     * If we want to reverse the item orientation.
     */

    public boolean isReverseOrientationItem() {
        return reverseOrientationItem;
    }

    public void setReverseOrientationItem(boolean reverseOrientationItem) {
        this.reverseOrientationItem = reverseOrientationItem;
    }
    /**
     * Listener for item click
     *
     */
    public interface OnActionItemClickListener {

        public abstract void onItemClick(QuickActionPopup source, int pos, int actionId, LinearLayout item);
    }

    /**
     * Listener for window dismiss
     *
     */
    public interface OnDismissListener {
        public abstract void onDismiss();
    }
}