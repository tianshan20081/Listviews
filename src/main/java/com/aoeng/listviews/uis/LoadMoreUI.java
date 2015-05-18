package com.aoeng.listviews.uis;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.aoeng.listviews.R;
import com.aoeng.listviews.utils.DataUtils;
import com.aoeng.listviews.views.LvLoardMore;

import java.util.List;

public class LoadMoreUI extends Activity {

    private LvLoardMore lvLoadMore;
    private List<String> mDatas;
    private ArrayAdapter<String> mAdapter;

    private int maxAccount = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_more_ui);
        lvLoadMore = (LvLoardMore) findViewById(R.id.lvLoadMore);
        mDatas = DataUtils.initDatas();
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, mDatas);
        lvLoadMore.setAdapter(mAdapter);

        lvLoadMore.setLvStatusChangeListener(new LvLoardMore.LvStatusChangeListener() {
            @Override
            public void startLoadingData(int startIndex) {
                loadDataStart(startIndex);
            }
        });
    }

    private void loadDataStart(final int startIndex) {
        if (startIndex >= maxAccount) {
            lvLoadMore.setFinishLoading();
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    mDatas.add("this is load More " + (startIndex + i));
                }
                lvLoadMore.setLoadingFinished();
                mAdapter.notifyDataSetChanged();
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_load_more_ui, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
