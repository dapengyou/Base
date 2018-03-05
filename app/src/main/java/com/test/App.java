package com.test;

import com.test.baselibrary.MyApplication;
import com.test.share.ShareManager;

/**
 * Created by lady_zhou on 2018/1/16.
 */

public class App extends MyApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initShareSDK();
    }

    public void initShareSDK() {
        ShareManager.initSDK(this);
    }
}
