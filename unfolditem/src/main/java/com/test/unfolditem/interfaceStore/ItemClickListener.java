package com.test.unfolditem.interfaceStore;

import com.test.unfolditem.bean.DataBean;

/**
 * Created by lady_zhou on 2018/3/13.
 */

public interface ItemClickListener {
    /**
     * 展开子Item
     *
     * @param bean
     */
    void onExpandChildren(DataBean bean);

    /**
     * 隐藏子Item
     *
     * @param bean
     */
    void onHideChildren(DataBean bean);
}
