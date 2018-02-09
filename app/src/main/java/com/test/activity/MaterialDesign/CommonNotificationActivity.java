package com.test.activity.MaterialDesign;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.test.baselibrary.base.TitleActivity;
import com.test.baseutil.R;

public class CommonNotificationActivity extends TitleActivity {

    private Button mBtCommon;

    @Override
    protected int getContentResId() {
        return R.layout.activity_notification;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        mBtCommon = findViewById(R.id.bt_common);
    }

    @Override
    protected void initData(Intent intent, Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {
        mBtCommon.setOnClickListener(this);
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.bt_common:
                Log.d("123", "124");
                setNotificationBuilder();
                break;
        }
    }

    private void setNotificationBuilder() {
        NotificationManager manager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification.Builder builder = new Notification.Builder(this);
        Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.csdn.net/lady_zhou"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        //给Notification添加属性
        builder.setContentIntent(pendingIntent);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setContentTitle("普通通知");
        builder.setAutoCancel(true);
        // 需要VIBRATE权限
//        builder.setDefaults(Notification.DEFAULT_ALL);
//        builder.setPriority(Notification.PRIORITY_DEFAULT);

        manager.notify(0, builder.build());

    }

}
