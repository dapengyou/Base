package com.test.valueAnimator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
//抄袭失败
public class MainActivity extends AppCompatActivity {
    private final static int GETLAYOUT = 1;
    private final static int TOBOTTOM = 2;

    TextView mTvIntroduce;//介绍

    private View mLayout;//箭头布局

    ImageView mIvImage;//箭头

    String context = "这是一个练习，练习什么呢？练习使用valueAnimator动画，在点击的时候箭头变化，出现隐藏的内容," +
            "这是一个练习，练习什么呢？练习使用valueAnimator动画，在点击的时候箭头变化，出现隐藏的内容";

    private ViewGroup.LayoutParams mDesLayoutParams;//描述信息的布局参数
    private boolean isOpen = false; //标记是否展开显示更多描述信息

    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayout = findViewById(R.id.rl_layout);
        mIvImage = findViewById(R.id.image);
        mTvIntroduce = findViewById(R.id.tv_introduction);

        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvIntroduce.setText(context);
                // 将更新高度的逻辑放在handler消息队列中处理, 避免当描述很短时也是7行高度的bug出现
//        UIUtils.getHandler().post(new Runnable() {
//            @Override
//            public void run() {
//                int shortHeight = getShotHeight();
//                mDesLayoutParams = mTvIntroduce.getLayoutParams();
//                mDesLayoutParams.height = shortHeight;
//                mTvIntroduce.setLayoutParams(mDesLayoutParams);
//            }
//        });
                Message msg = Message.obtain();
                msg.what = GETLAYOUT;
                mHandler.sendMessageDelayed(msg, 50);

                toggle();
            }
        });
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GETLAYOUT:
                    int shortHeight = getShotHeight();
                    mDesLayoutParams = mTvIntroduce.getLayoutParams();
                    mDesLayoutParams.height = shortHeight;
                    mTvIntroduce.setLayoutParams(mDesLayoutParams);
                    break;
                case TOBOTTOM:
                    scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                    break;
            }
        }
    };


    /**
     * 控制更多描述信息显示与否的开关
     */
    private void toggle() {
        //创建属性动画
        ValueAnimator animator = null;
        //描述信息的最大7行的高度和完整的高度
        int shortHeight = getShotHeight();
        int fullHeight = getFullHeight();
        if (isOpen) {
            //此时展开,点击后关闭
            animator = ValueAnimator.ofInt(fullHeight, shortHeight);
        } else {
            //此时关闭,点击后展开
            animator = ValueAnimator.ofInt(shortHeight, fullHeight);
        }
        //重置标记
        isOpen = !isOpen;
        //设置动画的时间
        animator.setDuration(200);
        //设置动画的更新监听
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取变化的高度
                int height = (int) animation.getAnimatedValue();
                mDesLayoutParams.height = height;
                //应用变化的高度
                mTvIntroduce.setLayoutParams(mDesLayoutParams);
            }
        });
        //如果tvDetailDes的完整高度大于最大7行的高度,则开启动画
        if (null != animator && fullHeight > shortHeight) {
            animator.start();
        }
        //更新箭头的方向
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (isOpen) {
                    mIvImage.setImageResource(R.mipmap.up);
                } else {
                    mIvImage.setImageResource(R.mipmap.down);
                }
                // 动画播放完后让ScrollView滑动到底部
                scrollView = getScrollView();
                // 需要注意的是，该方法不能直接被调用
                // 因为Android很多函数都是基于消息队列来同步，所以需要一部操作，
                // addView完之后，不等于马上就会显示，而是在队列中等待处理，虽然很快，但是如果立即调用fullScroll，
                // view可能还没有显示出来，所以会失败
                // 应该通过handler在新线程中更新
//                UIUtils.getHandler().post(new Runnable() {
//                    @Override
//                    public void run() {
//                        scrollView.fullScroll(ScrollView.FOCUS_DOWN);
//                    }
//                });
                Message message = new Message();
                message.what = TOBOTTOM;
                mHandler.sendMessageDelayed(message, 50);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }

    /**
     * 获取当前rootView所在的父控件ScrollView
     *
     * @return
     */
    private ScrollView getScrollView() {
        ViewParent parent = getScrollView().getParent();
        while (!(parent instanceof ScrollView)) {
            parent = parent.getParent();
        }
        return (ScrollView) parent;
    }

    /**
     * 获取显示描述信息0-7行的高度,即最大的高度是7行数据
     *
     * @return
     */
    private int getShotHeight() {
        //创建一个模拟的和布局文件中tvDetailDes布局参数一样的TextView,目的是为了之后的高度测量
        TextView copyTextView = new TextView(this);
        copyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        copyTextView.setText(context);
        copyTextView.setMaxLines(7);

        //获取原始tvDetailDes在布局中的宽度
        int originalWidth = mTvIntroduce.getMeasuredWidth();
        //计算出widthMeasureSpec,由于是宽度是match_parent,所以mode是EXACTLY
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(originalWidth, View.MeasureSpec.EXACTLY);
        //计算出heightMeasureSpec,由于文字的高度是最大7行,所以高度是不确定的,可以写一个最大的高度.例如2000px,模式为AT_MOST
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(2000, View.MeasureSpec.AT_MOST);

        //根据widthMeasureSpec,heightMeasureSpec去测量模拟的TextView的宽高
        copyTextView.measure(widthMeasureSpec, heightMeasureSpec);
        //最后将测量后的高度返回.
        return copyTextView.getMeasuredHeight();
    }

    /**
     * 获取显示描述信息显示完整内容的高度,即最大的高度是不固定的
     * 和上面的方法类似,只是去掉了MaxLines的限制
     *
     * @return
     */
    private int getFullHeight() {
        //创建一个模拟的和布局文件中tvDetailDes布局参数一样的TextView,目的是为了之后的高度测量
        TextView copyTextView = new TextView(this);
        copyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        copyTextView.setText(context);

        //获取原始tvDetailDes在布局中的宽度
        int originalWidth = mTvIntroduce.getMeasuredWidth();
        //计算出widthMeasureSpec,由于是宽度是match_parent,所以mode是EXACTLY
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(originalWidth, View.MeasureSpec.EXACTLY);
        //计算出heightMeasureSpec,由于文字的高度是最大7行,所以高度是不确定的,可以写一个最大的高度.例如2000px,模式为AT_MOST
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(2000, View.MeasureSpec.AT_MOST);

        //根据widthMeasureSpec,heightMeasureSpec去测量模拟的TextView的宽高
        copyTextView.measure(widthMeasureSpec, heightMeasureSpec);
        //最后将测量后的高度返回.
        return copyTextView.getMeasuredHeight();
    }
}
