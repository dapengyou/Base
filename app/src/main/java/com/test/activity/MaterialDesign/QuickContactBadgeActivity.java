package com.test.activity.MaterialDesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

import com.test.baseutil.R;

public class QuickContactBadgeActivity extends AppCompatActivity {
    private QuickContactBadge badge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        badge = (QuickContactBadge) findViewById(R.id.badge);

        // 指定联系人的电话号码
        // 先搜索该号码，如果没有则提醒是否添加到联系人
        // 第二个参数为延迟匹配，若为true，则直到被点击时才会查找该地址
        badge.assignContactFromPhone("18940864676", false);
    }
}
