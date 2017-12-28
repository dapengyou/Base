package com.test.baseutil;

import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.test.baselibrary.Utils.CheckTextUtils;
import com.test.baselibrary.Utils.NotificationsUtils;
import com.test.baselibrary.Utils.NumberUtils;

public class TestActivity extends Activity implements View.OnClickListener {
    private Button mBtSetting;
    private Button mBtNumber;
    private Button mBtTest;

    private EditText mEtPassword;
    private EditText mEtPhone;
    private EditText mEtEmail;

    private String mPhone;
    private String mPassword;
    private String mEmail;

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
        mBtTest = findViewById(R.id.bt_test);

        mEtEmail = findViewById(R.id.et_email);
        mEtPassword = findViewById(R.id.et_password);
        mEtPhone = findViewById(R.id.et_phone);
    }

    private void initListener() {
        mBtSetting.setOnClickListener(this);
        mBtNumber.setOnClickListener(this);
        mBtTest.setOnClickListener(this);
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

            case R.id.bt_test:
                if (checkForm()){
                    show("unbelievable");
                }
                    break;

        }
    }

    /**
     * 检查表单
     *
     * @return
     */
    private boolean checkForm() {
        mPassword = mEtPassword.getText().toString().trim();
        mPhone = mEtPhone.getText().toString().trim();
        mEmail = mEtEmail.getText().toString().trim();

        if (TextUtils.isEmpty(mPhone)) {
            show("手机号不能为空");
            return false;
        }

        if (!CheckTextUtils.checkMobile(mPhone)) {
            show("请输入有效手机号");
            return false;
        }

        if (TextUtils.isEmpty(mPassword)) {
            show("密码不能为空");
            return false;
        }

        if (!CheckTextUtils.checkPassword(mPassword)) {
            show("请输入6-20位有效密码");
            return false;
        }
        if (TextUtils.isEmpty(mEmail)) {
            show("邮箱不能为空");
            return false;
        }

        if (!CheckTextUtils.checkEmail(mEmail)) {
            show("请输入有效邮箱");
            return false;
        }
        return true;
    }

    private void show(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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
