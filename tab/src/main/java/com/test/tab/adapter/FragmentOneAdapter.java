package com.test.tab.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.tab.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lady_zhou on 2018/2/28.
 */

public class FragmentOneAdapter extends RecyclerView.Adapter<FragmentOneAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> dataList = new ArrayList<>();

    public FragmentOneAdapter(RecyclerView recyclerView, List<String> dataList) {
        this.mContext = recyclerView.getContext();
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_one, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }
}
