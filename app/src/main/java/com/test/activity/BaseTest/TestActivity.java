package com.test.activity.BaseTest;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.test.baselibrary.MyApplication;
import com.test.baselibrary.Utils.CheckTextUtils;
import com.test.baselibrary.Utils.CountDownUtil;
import com.test.baselibrary.Utils.NotificationsUtils;
import com.test.baselibrary.Utils.NumberUtils;
import com.test.baselibrary.base.TitleActivity;
import com.test.baseutil.R;

public class TestActivity extends TitleActivity {
    private Button mBtSetting;
    private Button mBtNumber;
    private Button mBtTest;
    private Button mBtRefresh;


    private EditText mEtPassword;
    private EditText mEtPhone;
    private EditText mEtEmail;

    private TextView mTvCountDown;
    private TextView mTvAddress;

    private String mPhone;
    private String mPassword;
    private String mEmail;

    private String mProvince;
    private String mCity;
    private String mDistrict;

    @Override
    protected int getContentResId() {
        return R.layout.notification_test;
    }

    @Override
    protected void initData(Intent intent, Bundle savedInstanceState) {
//        setLeftText("嗨");
        setTitleText("title");
//        setRightText("设置");
//        setRightIcon(R.mipmap.back_white);
//        setLeftIcon(0); //传0 隐藏图标

        //设置Titlebar 渐变色
//        int colors[] = {Color.WHITE,Color.GREEN};
//        int colors[] = {Color.parseColor("#000000"), Color.parseColor("#f1f9b1")};
//        int colors[] = {0xff255779, 0xff3e7492};
//        setTitleBarColor(colors);
    }

    @Override
    protected void onRightClick(View rigthTv) {
        show("右边");
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        mBtSetting = findViewById(R.id.bt_setting);
        mBtNumber = findViewById(R.id.bt_number);
        mBtTest = findViewById(R.id.bt_test);

        mEtEmail = findViewById(R.id.et_email);
        mEtPassword = findViewById(R.id.et_password);
        mEtPhone = findViewById(R.id.et_phone);

        mTvCountDown = findViewById(R.id.tv_countDown);
        mTvAddress = findViewById(R.id.tv_address);
        mBtRefresh = findViewById(R.id.bt_refresh);

    }

    @Override
    protected void initListener() {
        mBtSetting.setOnClickListener(this);
        mBtNumber.setOnClickListener(this);
        mBtTest.setOnClickListener(this);
        mTvCountDown.setOnClickListener(this);
        mTvAddress.setOnClickListener(this);
        mBtRefresh.setOnClickListener(this);

    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
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
                if (checkForm()) {  //验证手机号、邮箱地址、密码输入的是否正确
                    show("unbelievable");
                }
                break;
            case R.id.tv_countDown:
                show("点击了");
//                CountDownUtil countDown = new CountDownUtil(mTvCountDown);
                CountDownUtil countDown = new CountDownUtil(mTvCountDown, "%ds后重新发送");
//                CountDownUtil countDown = new CountDownUtil(mTvCountDown,180,"%ds后重新发送");
                countDown.start();
                break;
            case R.id.tv_address:
                showAddressDialog();
                break;
            case R.id.bt_refresh:
                startActivity(new Intent(this, RefreshActivity.class));
                break;

        }
    }

    /**
     * 弹出选择器
     */
    private void showAddressDialog() {
        final OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                mProvince = MyApplication.provinces.get(options1).getPickerViewText();
                mCity = MyApplication.citys.get(options1).get(options2);
                mDistrict = MyApplication.districts.get(options1).get(options2).get(options3);
                mTvAddress.setText(mProvince + mCity + mDistrict);

            }
        })
                .setDividerColor(Color.WHITE)//分割线的颜色
                .setTitleBgColor(Color.WHITE)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(17)
                .setOutSideCancelable(false)// default is true
                .setTitleText("地区选择")
                .setTitleColor(getResources().getColor(R.color.blue))
                .setCancelColor(getResources().getColor(R.color.blue))
                .setTitleSize(20)
                .setSubmitColor(getResources().getColor(R.color.blue))
                .build();

        pvOptions.setPicker(MyApplication.provinces, MyApplication.citys, MyApplication.districts);//二级选择器
        pvOptions.show();
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
