package com.test.activity.BaseTest;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.test.MockData.MockData;
import com.test.adapter.HomeAdapter;
import com.test.baseutil.R;
import com.test.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RefreshActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SmartRefreshLayout mRefreshLayout;

    private HomeAdapter mAdapter;
    private List<String> mData;

    private boolean isRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refesh);

        mRefreshLayout = findViewById(R.id.srl_list);
        mRecyclerView = findViewById(R.id.rv_list);

        //设置 Header 为 Material样式
        mRefreshLayout.setRefreshHeader(new MaterialHeader(this).setShowBezierWave(true));
        //设置 Footer 为 球脉冲
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.Scale));

        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initData(10);

        mRefreshLayout.setEnableAutoLoadmore(true);

        mRefreshLayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                getData();
                mRefreshLayout.setLoadmoreFinished(false);
            }

            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mRefreshLayout.finishLoadmore();
                mRefreshLayout.setLoadmoreFinished(true);
            }
        });
    }

    private void initData(int count) {
        mAdapter = new HomeAdapter(MockData.getDatas(count));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void getData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mRefreshLayout.isRefreshing()) {
                    mAdapter.setNewData(MockData.getDatas(10));
                } else {
                    List<HomeBean> datas = MockData.getDatas(5 + new Random().nextInt(10));
                    mAdapter.addData(datas);
                    if (datas.size() >= 10) {
                        mAdapter.loadMoreComplete();
                    } else if (datas.size() > 5) {
                        mAdapter.loadMoreEnd();
                    } else {
                        mAdapter.loadMoreFail();
                    }
                }
                //结束加载
                mRefreshLayout.finishRefresh();
                //加载失败的话3秒后结束加载
                mRefreshLayout.finishRefresh(3000);
            }
        }, 1000);
    }

}
