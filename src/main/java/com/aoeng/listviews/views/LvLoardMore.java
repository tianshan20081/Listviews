package com.aoeng.listviews.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aoeng.listviews.R;

/**
 * Created by sczhang on 15/5/11.
 */
public class LvLoardMore extends ListView implements AbsListView.OnScrollListener {
    private View mFooter;
    private int mTotalAccount;
    private int mLastIndex;
    private boolean isLoading = false;
    private LvStatusChangeListener mStatusChangeListener;

    public LvLoardMore(Context context) {
        super(context);
        initViews();
    }

    public LvLoardMore(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public LvLoardMore(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    private void initViews() {
        mFooter = LayoutInflater.from(getContext()).inflate(R.layout.ui_lv_footer, null
        );

        this.addFooterView(mFooter);
        this.setOnScrollListener(this);
    }


    /**
     * Callback method to be invoked while the list view or grid view is being scrolled. If the
     * view is being scrolled, this method will be called before the next frame of the scroll is
     * rendered. In particular, it will be called before any calls to
     * {@link Adapter#getView(int, View, ViewGroup)}.
     *
     * @param view        The view whose scroll state is being reported
     * @param scrollState The current scroll state. One of
     *                    {@link #SCROLL_STATE_TOUCH_SCROLL} or {@link #SCROLL_STATE_IDLE}.
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE && mTotalAccount == mLastIndex) {
            if (!isLoading) {
                isLoading = true;
                mFooter.setVisibility(View.VISIBLE);
                //加载更多
                loadMoreData(mTotalAccount);
            }
        }
    }

    private void loadMoreData(int currentIndex) {
        this.mStatusChangeListener.startLoadingData(currentIndex);
    }

    /**
     * Callback method to be invoked when the list or grid has been scrolled. This will be
     * called after the scroll has completed
     *
     * @param view             The view whose scroll state is being reported
     * @param firstVisibleItem the index of the first visible cell (ignore if
     *                         visibleItemCount == 0)
     * @param visibleItemCount the number of visible cells
     * @param totalItemCount   the number of items in the list adaptor
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        mTotalAccount = totalItemCount;
        mLastIndex = firstVisibleItem + visibleItemCount;
    }

    public interface LvStatusChangeListener {
        public void startLoadingData(int startIndex);
    }

    public void setLvStatusChangeListener(LvStatusChangeListener statusChangeListener) {
        this.mStatusChangeListener = statusChangeListener;
    }

    public void setLoadingFinished() {
        if (isLoading) {
            isLoading = false;
            mFooter.setVisibility(View.GONE);
        }
    }

    public void setFinishLoading() {
        mFooter.setVisibility(View.VISIBLE);
        TextView tvMsg = (TextView) mFooter.findViewById(R.id.tvMsg);
        tvMsg.setText(getContext().getString(R.string.lv_no_more_info));
        ProgressBar pbBar = (ProgressBar) mFooter.findViewById(R.id.pbBar);
        pbBar.setVisibility(View.GONE);
    }
}
