package com.test.baselibrary.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public abstract class BaseActivity extends AppCompatActivity implements OnClickListener {
    public Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        //设置成没有Title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());

        initView(savedInstanceState);

        Intent intent = getIntent();
        initData(intent, savedInstanceState);

        initListener();
    }

    /**
     * 获得相应Activity的layoutId
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化View
     *
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化数据
     *
     * @param intent
     * @param savedInstanceState
     */
    protected abstract void initData(Intent intent, Bundle savedInstanceState);

    /**
     * 初始化点击事件
     */
    protected abstract void initListener();

    /**
     * 当View被点击时调用
     *
     * @param v
     */
    protected abstract void onViewClick(View v);

    @Override
    public void onClick(View v) {
        onViewClick(v);
    }
}
