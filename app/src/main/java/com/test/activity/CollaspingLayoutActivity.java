package com.test.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import com.test.MockData.MockData;
import com.test.adapter.HomeAdapter;
import com.test.baselibrary.base.BaseActivity;
import com.test.baseutil.R;

public class CollaspingLayoutActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private HomeAdapter mAdapter;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collasping_layout;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mRecyclerView = findViewById(R.id.rv_recycleView);
        mCollapsingToolbarLayout = findViewById(R.id.collapsing);
        mToolbar = findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);

    }

    @Override
    protected void initData(Intent intent, Bundle savedInstanceState) {
        mCollapsingToolbarLayout.setTitle("测试一号");
        mCollapsingToolbarLayout.setCollapsedTitleGravity(Gravity.CENTER);//设置收缩后标题的位置
        mCollapsingToolbarLayout.setExpandedTitleGravity(Gravity.CENTER|Gravity.BOTTOM);//设置展开后标题的位置
        mCollapsingToolbarLayout.setExpandedTitleTextColor(ColorStateList.valueOf(Color.BLACK));

        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        initData(20);

    }

    private void initData(int count) {
        mAdapter = new HomeAdapter(MockData.getDatas(count));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
