package com.test.baseutil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.test.baselibrary.base.TitleActivity;

/**
 * Created by lady_zhou on 2018/1/8.
 */

public class TestTitleActivity  extends TitleActivity{

    @Override
    protected int getContentResId() {
        return 0;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
    }

    @Override
    protected void initData(Intent intent, Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
