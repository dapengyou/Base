package com.test.unfolditem.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.test.unfolditem.R;
import com.test.unfolditem.bean.DataBean;

/**
 * Created by lady_zhou on 2018/3/13.
 */

public class ChildViewHolder extends BaseViewHolder {

    private Context mContext;
    private View view;
    private TextView childText;

    public ChildViewHolder(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        this.view = itemView;
    }

    public void bindView(final DataBean dataBean, final int pos){

        childText = (TextView) view.findViewById(R.id.child_text);
        childText.setText(dataBean.getChildTxt());

    }
}
