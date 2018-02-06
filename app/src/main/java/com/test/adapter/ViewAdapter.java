package com.test.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayoutManager;
import com.test.baseutil.R;
import com.test.bean.FlexboxBean;

import java.util.List;

/**
 * Created by lady_zhou on 2018/2/6.
 */

public class ViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<FlexboxBean> itemDtoList;

    public ViewAdapter(List<FlexboxBean> itemDtoList) {
        this.itemDtoList = itemDtoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.flexbox_adapter, parent, false);

        final TextView textItem = (TextView) itemView.findViewById(R.id.tv_flexbox);
        textItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "You click text : " + textItem.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        ViewHolder ret = new ViewHolder(itemView);

        return ret;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        FlexboxBean flexboxBean = itemDtoList.get(position);

        holder.getTextItem().setText(flexboxBean.getText());
    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if (this.itemDtoList != null) {
            ret = itemDtoList.size();
        }
        return ret;
    }
}
