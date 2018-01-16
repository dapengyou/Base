package com.test.baselibrary;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.test.baselibrary.Utils.AdressDataUtil;
import com.test.baselibrary.module.Province;

import java.util.ArrayList;

/**
 * Created by lady_zhou on 2018/1/16.
 */

public class MyApplication extends MultiDexApplication {
    private static MyApplication instance;
    private static Context mContext;
    private static String token;

    public static ArrayList<Province> provinces = new ArrayList<>();
    public static ArrayList<ArrayList<String>> citys = new ArrayList<>();
    public static ArrayList<ArrayList<ArrayList<String>>> districts = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
        this.mContext = this;

        initWheelData();
    }

    private void initWheelData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                provinces = AdressDataUtil.getProviceData(mContext);
                citys = AdressDataUtil.getCityData(provinces);
                districts = AdressDataUtil.getDistricts(provinces);
            }
        }
        ).start();

    }
}
