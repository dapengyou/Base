package com.test.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.test.baseutil.R;
import com.test.bean.FlexboxBean;
import com.test.bean.HomeBean;

import java.util.List;

/**
 * Created by lady_zhou on 2018/1/22.
 */

public class FlexboxAdapter extends BaseQuickAdapter<FlexboxBean, BaseViewHolder> {

    public FlexboxAdapter(List<FlexboxBean> data) {
        super(R.layout.flexbox_adapter, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final FlexboxBean item) {
        TextView mTextView = helper.getConvertView().findViewById(R.id.tv_flexbox);
        helper.setText(R.id.tv_flexbox,item.getText());

        ViewGroup.LayoutParams lp = mTextView.getLayoutParams();
        if (lp instanceof FlexboxLayoutManager.LayoutParams) {
            FlexboxLayoutManager.LayoutParams flexboxLp =
                    (FlexboxLayoutManager.LayoutParams) mTextView.getLayoutParams();
            flexboxLp.setFlexGrow(1.0f);
        }

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "You click text : " + item.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
