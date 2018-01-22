package com.test.MockData;

import com.test.bean.HomeBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lady_zhou on 2018/1/22.
 */

public class MockData {
    public static List<HomeBean> getDatas(int count) {
        List<HomeBean> datas = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            HomeBean homeBean = new HomeBean();
            homeBean.setNumber("list " + (i + 1));
            datas.add(homeBean);
        }
        return datas;
    }
}
