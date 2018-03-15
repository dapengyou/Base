package com.test.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.test.baselibrary.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private Button mBtMoon;//卫星

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mBtMoon = findViewById(R.id.bt_moon);
    }

    @Override
    protected void initData(Intent intent, Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {
        mBtMoon.setOnClickListener(this);
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.bt_moon:
                startActivity(new Intent(this, MoonActivity.class));
                break;
        }
    }
}
