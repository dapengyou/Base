package com.test.baseutil;

import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.test.baselibrary.Utils.NotificationsUtils;
import com.test.baselibrary.Utils.NumberUtils;

public class NotificationTestActivity extends Activity implements View.OnClickListener {
    private Button mBtSetting;
    private Button mBtNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_test);

        initView();

        initListener();
    }

    private void initView() {
        mBtSetting = findViewById(R.id.bt_setting);
        mBtNumber = findViewById(R.id.bt_number);
    }

    private void initListener() {
        mBtSetting.setOnClickListener(this);
        mBtNumber.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_setting:
                if (!NotificationsUtils.isNotificationEnabled(this)) {
                    setting();
                } else {
                    Toast.makeText(this, "已经打开了", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_number:
                Log.d("123", NumberUtils.keepTwoByDecimalFormat(2345.1018238382));
                Log.d("123", NumberUtils.keepTwoByDecimalFormat(2345.1918238382));
                break;
        }
    }

    /**
     * 去设置状态栏
     */
    private void setting() {
        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            localIntent.setAction(Intent.ACTION_VIEW);
            localIntent.setClassName("com.android.settings", "com.android.setting.InstalledAppDetails");
            localIntent.putExtra("com.android.settings.ApplicationPkgName", getPackageName());
        }
        startActivity(localIntent);
    }
}
