package com.test.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.test.baseutil.R;

/**
 * Created by lady_zhou on 2018/2/6.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView textItem;

    public ViewHolder(View itemView) {
        super(itemView);
        if(itemView!=null) {
            this.textItem = itemView.findViewById(R.id.tv_flexbox);
        }
    }

    public TextView getTextItem() {
        return textItem;
    }
}
