package com.test.valueAnimator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 使用viewStub
 */
public class Main2Activity extends AppCompatActivity {
    View mLayout;
    TextView mTip;
    ViewStub mViewStub;
    TextView mTextView;
    boolean flag = false;
    View inflate = null;

    String context = "这是一个练习，练习什么呢？练习使用valueAnimator动画，在点击的时候箭头变化，出现隐藏的内容," +
            "这是一个练习，练习什么呢？练习使用valueAnimator动画，在点击的时候箭头变化，出现隐藏的内容";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mLayout = findViewById(R.id.rl_layout);
        mViewStub = findViewById(R.id.tv_introduction);

        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.rl_layout:
                        if (!flag) {
                            inflate = mViewStub.inflate();
                            mTextView = (TextView) inflate.findViewById(R.id.textview);
                            mTextView.setText(context);
                            flag = true;
                        } else {
                            mViewStub.setVisibility(View.GONE);
                            flag = false;

                        }
                        break;
                }
            }
        });
    }

}
