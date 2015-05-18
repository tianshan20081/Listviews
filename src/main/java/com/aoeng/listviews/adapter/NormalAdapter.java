package com.aoeng.listviews.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.aoeng.listviews.domain.Data;

import java.util.List;

/**
 * Created by sczhang on 15/5/11.
 */
public class NormalAdapter extends BaseAdapter {

    private Context mContext;
    private List<Data> mDatas;

    public NormalAdapter(Context context, List<Data> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public int getCount() {
        return this.mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return this.mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        return null;
    }
}
