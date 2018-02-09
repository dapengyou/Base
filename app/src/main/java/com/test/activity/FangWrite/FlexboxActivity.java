package com.test.activity.FangWrite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.test.MockData.MockData;
import com.test.adapter.FlexboxAdapter;
import com.test.baselibrary.base.TitleActivity;
import com.test.baseutil.R;

import java.util.ArrayList;

public class FlexboxActivity extends TitleActivity {
    private FlexboxLayout mFlexboxLayout;
    private RecyclerView mRecyclerView;
    private FlexboxAdapter mFlexboxAdapter;
    private View mView;

    private ArrayList<String> mList = new ArrayList<String>() {{
        add("要闻");
        add("视频");
        add("新时代");
        add("北京");
        add("娱乐");
        add("体育");
        add("财经");
        add("军事");
        add("国际");
        add("独家");
        add("游戏");
        add("时尚");
        add("政务");
        add("体育");
        add("游戏");
    }};
    private String textArr[] = {"dev2qa.com", "is", "a very good", "android example website", "there are", "a lot of", "android, java examples"};

    @Override
    protected int getContentResId() {
        return R.layout.activity_flexbox;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
//        mFlexboxLayout = findViewById(R.id.fl_flexbox);
        mRecyclerView = findViewById(R.id.rv_recycleView);
    }


    @Override
    protected void initData(Intent intent, Bundle savedInstanceState) {
        FlexboxLayoutManager manager = new FlexboxLayoutManager(getApplicationContext());

        //设置主轴排列方式
        manager.setFlexDirection(FlexDirection.ROW);
        //设置是否换行
        manager.setFlexWrap(FlexWrap.WRAP);
        manager.setJustifyContent(JustifyContent.SPACE_AROUND);

        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mFlexboxAdapter = new FlexboxAdapter(MockData.getFlexBox(mList));
        mRecyclerView.setAdapter(mFlexboxAdapter);

        //点击后显示点击内容
        mFlexboxAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(view.getContext(), "You click text : " + mList.get(position), Toast.LENGTH_SHORT).show();

            }
        });
        //adapter设置动画（渐显）
        mFlexboxAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);

        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(mFlexboxAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);


        OnItemDragListener onItemDragListener = new OnItemDragListener() {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {

            }

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {

            }

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
                Toast.makeText(FlexboxActivity.this, "You drag text : " + mList.get(pos), Toast.LENGTH_SHORT).show();

            }
        };

        // 开启拖拽
        mFlexboxAdapter.enableDragItem(itemTouchHelper, R.id.tv_flexbox, true);
        mFlexboxAdapter.setOnItemDragListener(onItemDragListener);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onViewClick(View v) {

    }

}
