package com.test.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.test.baseutil.R;
import com.test.bean.HomeBean;

import java.util.List;

/**
 * Created by lady_zhou on 2018/1/22.
 */

public class HomeAdapter extends BaseQuickAdapter<HomeBean, BaseViewHolder> {

    public HomeAdapter(List<HomeBean> data) {
        super(R.layout.item_adapter, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean item) {
        helper.setText(R.id.id_num, item.getNumber());
    }
}
