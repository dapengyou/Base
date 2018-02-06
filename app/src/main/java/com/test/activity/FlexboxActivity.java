package com.test.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.AlignSelf;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.test.MockData.MockData;
import com.test.adapter.FlexboxAdapter;
import com.test.adapter.ViewAdapter;
import com.test.baselibrary.base.TitleActivity;
import com.test.baseutil.R;
import com.test.bean.FlexboxBean;

import java.util.ArrayList;
import java.util.List;

public class FlexboxActivity extends TitleActivity {
    private FlexboxLayout mFlexboxLayout;
    private RecyclerView mRecyclerView;
    private FlexboxAdapter mFlexboxAdapter;

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
//        for (int i = 0; i < mList.size(); i++) {
//            // 通过代码向FlexboxLayout添加View
//            TextView textView = new TextView(this);
//            textView.setBackground(getResources().getDrawable(R.drawable.bg_flexbox));
//            textView.setText(mList.get(i));
//            textView.setGravity(Gravity.CENTER);
//            textView.setPadding(30, 10, 30, 10);
//            mFlexboxLayout.addView(textView);
//
//            //通过FlexboxLayout.LayoutParams 设置子元素支持的属性
//            ViewGroup.LayoutParams lp = textView.getLayoutParams();
//            if (lp instanceof FlexboxLayoutManager.LayoutParams) {
//                FlexboxLayoutManager.LayoutParams flexboxLp = (FlexboxLayoutManager.LayoutParams) lp;
//                flexboxLp.setFlexGrow(1.0f);
//                flexboxLp.setAlignSelf(AlignSelf.FLEX_END);
//                flexboxLp.setMargins(20, 10, 20, 10);
//            }
//        }
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


//        ViewAdapter viewAdapter = new ViewAdapter(MockData.getFlexBox(mList));
//        mRecyclerView.setAdapter(viewAdapter);
    }
    private List<FlexboxBean> initViewItemDtoList()
    {
        List<FlexboxBean> ret = new ArrayList<FlexboxBean>();

        for(int i=0;i < mList.size(); i++)
        {
            FlexboxBean itemDto = new FlexboxBean();
            itemDto.setText(mList.get(i));
            ret.add(itemDto);
        }
        return ret;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onViewClick(View v) {

    }

}
