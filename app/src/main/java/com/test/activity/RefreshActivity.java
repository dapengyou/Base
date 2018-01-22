package com.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.test.baseutil.R;

import java.util.ArrayList;
import java.util.List;

public class RefreshActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RefreshLayout mRefreshLayout;

    private HomeAdapter mAdapter;
    private List<String> mData;

    private boolean isRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refesh);
        initData();

        mRefreshLayout = (RefreshLayout) findViewById(R.id.srl_list);
        //设置 Header 为 Material样式
        mRefreshLayout.setRefreshHeader(new MaterialHeader(this).setShowBezierWave(true));
        //设置 Footer 为 球脉冲
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.Scale));

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置adapter
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter());

        mRefreshLayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                isRefresh = true;
                mData.add("" + 0);
                mRefreshLayout.setLoadmoreFinished(false);
            }

            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                isRefresh = false;
                mRefreshLayout.finishLoadmore();
                mRefreshLayout.setLoadmoreFinished(true);
            }
        });
    }

    private void initData() {
        mData = new ArrayList<String>();
        for (int i = 1; i < 15; i++) {
            mData.add("" + i);
        }
    }

    /**
     * adapter
     */
    private class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
        @Override
        public HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder
                    (LayoutInflater.from(RefreshActivity.this).
                            inflate(R.layout.item_adapter, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            //绑定数据
            holder.tv.setText(mData.get(position));
        }

        @Override
        public int getItemCount() {
            //返回item个数
            return mData.size();
        }

        //自定义的ViewHolder
        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }
}
