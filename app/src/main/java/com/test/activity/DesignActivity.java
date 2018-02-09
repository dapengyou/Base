package com.test.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.test.baselibrary.base.BaseActivity;
import com.test.baseutil.R;

public class DesignActivity extends BaseActivity {
    private Button mBtTest2;
    private Button mBottomSheetDialog;
    private Button mBtCollapsing;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_design;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mBtTest2 = findViewById(R.id.bt_quickContactBadge);
        mBottomSheetDialog = findViewById(R.id.bt_bottomSheetDialog);
        mBtCollapsing = findViewById(R.id.bt_collapsing);
    }

    @Override
    protected void initData(Intent intent, Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {
        mBtTest2.setOnClickListener(this);
        mBottomSheetDialog.setOnClickListener(this);
        mBtCollapsing.setOnClickListener(this);
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.bt_quickContactBadge:
                startActivity(new Intent(this, QuickContactBadgeActivity.class));
                break;
            case R.id.bt_bottomSheetDialog:
                startActivity(new Intent(this, BottomSheetDialogActivity.class));
                break;
            case R.id.bt_collapsing:
                startActivity(new Intent(this, CollaspingLayoutActivity.class));
                break;
        }
    }
}
