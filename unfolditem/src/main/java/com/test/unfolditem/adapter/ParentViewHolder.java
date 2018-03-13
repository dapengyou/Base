package com.test.unfolditem.adapter;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.test.unfolditem.R;
import com.test.unfolditem.bean.DataBean;
import com.test.unfolditem.interfaceStore.ItemClickListener;

/**
 * Created by lady_zhou on 2018/3/13.
 */

public class ParentViewHolder extends BaseViewHolder {

    private Context mContext;
    private View view;
    private LinearLayout containerLayout;
    private TextView parentLeftView;
    private ImageView expand;
    private View parentDashedView;

    public ParentViewHolder(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        this.view = itemView;
    }

    public void bindView(final DataBean dataBean, final int pos, final ItemClickListener listener){

        containerLayout = (LinearLayout) view.findViewById(R.id.container);
        parentLeftView = (TextView) view.findViewById(R.id.tv_content);
        expand = (ImageView) view.findViewById(R.id.expend);
        parentDashedView = view.findViewById(R.id.parent_dashed_view);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) expand
                .getLayoutParams();
        expand.setLayoutParams(params);
        parentLeftView.setText(dataBean.getParentTxt());

        if (dataBean.isExpand()) {
            expand.setRotation(90);
            parentDashedView.setVisibility(View.INVISIBLE);
        } else {
            expand.setRotation(0);
            parentDashedView.setVisibility(View.VISIBLE);
        }

        //父布局OnClick监听
        containerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    if (dataBean.isExpand()) {
                        listener.onHideChildren(dataBean);
                        parentDashedView.setVisibility(View.VISIBLE);
                        dataBean.setExpand(false);
                        rotationExpandIcon(90,  0);
                    } else {
                        listener.onExpandChildren(dataBean);
                        parentDashedView.setVisibility(View.INVISIBLE);
                        dataBean.setExpand(true);
                        rotationExpandIcon(0,  90);
                    }
                }
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void rotationExpandIcon(float from,  float to) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(from, to);//属性动画
            valueAnimator.setDuration(500);
            valueAnimator.setInterpolator(new DecelerateInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    expand.setRotation((Float) valueAnimator.getAnimatedValue());
                }
            });
            valueAnimator.start();
        }
    }
}
