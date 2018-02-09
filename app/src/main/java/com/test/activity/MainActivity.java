package com.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.test.activity.BaseTest.TestActivity;
import com.test.activity.FangWrite.FlexboxActivity;
import com.test.activity.MaterialDesign.DesignActivity;
import com.test.baselibrary.base.BaseActivity;
import com.test.baseutil.R;

public class MainActivity extends BaseActivity {
    private Button mBtTest;
    private Button mBtFtenxun;
    private Button mBtDesign;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mBtTest = findViewById(R.id.bt_test);
        mBtFtenxun = findViewById(R.id.bt_ftenxun);
        mBtDesign = findViewById(R.id.bt_design);
    }

    @Override
    protected void initData(Intent intent, Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {
        mBtFtenxun.setOnClickListener(this);
        mBtTest.setOnClickListener(this);
        mBtDesign.setOnClickListener(this);
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.bt_test:
                startActivity(new Intent(this, TestActivity.class));
                break;
            case R.id.bt_ftenxun:
                startActivity(new Intent(this, FlexboxActivity.class));
                break;
            case R.id.bt_design:
                startActivity(new Intent(this, DesignActivity.class));
                break;
        }
    }
}
