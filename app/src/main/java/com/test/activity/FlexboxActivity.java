package com.test.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.test.baselibrary.base.TitleActivity;
import com.test.baseutil.R;

import java.util.ArrayList;
import java.util.List;

public class FlexboxActivity extends TitleActivity {
    private FlexboxLayout mFlexboxLayout;
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

    @Override
    protected int getContentResId() {
        return R.layout.activity_flexbox;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        mFlexboxLayout = findViewById(R.id.fl_flexbox);
    }

    @Override
    protected void initData(Intent intent, Bundle savedInstanceState) {
        for (int i = 0; i < mList.size(); i++) {
//            FlexboxLayoutManager manager = new FlexboxLayoutManager();
//            //设置主轴排列方式
//            manager.setFlexDirection(FlexDirection.ROW);
//            //设置是否换行
//            manager.setFlexWrap(FlexWrap.WRAP);
//            manager.setAlignItems(AlignItems.STRETCH);

            // 通过代码向FlexboxLayout添加View
            TextView textView = new TextView(this);
            textView.setBackground(getResources().getDrawable(R.drawable.bg_flexbox));
            textView.setText(mList.get(i));
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(30, 10, 30, 10);

            mFlexboxLayout.addView(textView);

        }

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onViewClick(View v) {

    }

}
