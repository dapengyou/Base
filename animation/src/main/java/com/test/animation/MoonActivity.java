package com.test.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.test.baselibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MoonActivity extends BaseActivity {
    private int res[] = {R.id.imageView_a, R.id.imageView_b, R.id.imageView_c, R.id.imageView_d};

    private List<ImageView> mImageViewList = new ArrayList<>();
    private boolean isOpen = false;

    private int r = 150;//半径

    @Override
    protected int getLayoutId() {
        return R.layout.activity_moon;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        //循环数组获得控件id 加入list，设置点击事件
        for (int i = 0; i < res.length; i++) {
            ImageView imageView = findViewById(res[i]);
            mImageViewList.add(imageView);
            imageView.setOnClickListener(this);
        }
    }

    @Override
    protected void initData(Intent intent, Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.imageView_a:
                if (!isOpen) {
                    openAnimator();
                } else {
                    closeAnimator();
                }
                break;
            default:
                Toast.makeText(v.getContext(), "Id: " + v.getId(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 关闭动画
     */
    private void closeAnimator() {
        for (int i = 0; i < res.length - 1; i++) {
            //计算每个控件展开的弧度
//            moveBack(mImageViewList.get(i + 1), (float) (Math.PI / 2 / (res.length - 2)) * i);
            rotationBack(mImageViewList.get(0));
            endwaysBack(mImageViewList.get(i + 1), (float) (i + 1) * 100);


        }
        isOpen = false;
    }

    /**
     * 打开动画
     */
    private void openAnimator() {
        for (int i = 0; i < res.length - 1; i++) {
            mImageViewList.get(i + 1).setVisibility(View.VISIBLE);
            //计算每个控件展开的弧度
//            moveTo(mImageViewList.get(i + 1), (float) (Math.PI / 2 / (res.length - 2)) * i);
            rotation(mImageViewList.get(0));
            endways(mImageViewList.get(i + 1), (float) (i + 1) * 100);
        }
        isOpen = true;
    }

    /**
     * 扇形展开
     *
     * @param objView 目标控件
     * @param angle   展开的角度
     */
    private void moveTo(View objView, float angle) {
        ObjectAnimator translationX = ObjectAnimator.ofFloat(objView, "translationX", 0f, (float) Math.cos(angle) * r);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(objView, "translationY", 0f, (float) Math.sin(angle) * r);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translationX, translationY);
        animatorSet.setDuration(500).start();
    }

    /**
     * 扇形关闭
     *
     * @param objView 目标控件
     * @param angle   关闭的角度
     */
    private void moveBack(View objView, float angle) {
        ObjectAnimator translationX = ObjectAnimator.ofFloat(objView, "translationX", (float) Math.cos(angle) * r, 0f);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(objView, "translationY", (float) Math.sin(angle) * r, 0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translationX, translationY);
        animatorSet.setDuration(500).start();
    }

    /**
     * 正向旋转
     *
     * @param objView
     */
    private void rotation(View objView) {
        ObjectAnimator rotation = ObjectAnimator.ofFloat(objView, "rotation", 0f, 45);
        rotation.setDuration(500);
        rotation.setRepeatMode(ValueAnimator.RESTART);
        rotation.start();
    }

    /**
     * 逆向旋转回去
     *
     * @param objView
     */
    private void rotationBack(View objView) {
        ObjectAnimator rotation = ObjectAnimator.ofFloat(objView, "rotation", 45, 0f);
        rotation.setDuration(500);
        rotation.setRepeatMode(ValueAnimator.REVERSE);
        rotation.start();
    }

    /**
     * 竖着展开
     *
     * @param objView 目标控件
     * @param angle   展开的角度
     */
    private void endways(View objView, float angle) {
        ObjectAnimator translationY = ObjectAnimator.ofFloat(objView, "translationY", 0f, angle);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(translationY);
        animatorSet.setDuration(500).start();
    }

    /**
     * 竖着展开
     *
     * @param objView 目标控件
     * @param angle   展开的角度
     */
    private void endwaysBack(View objView, float angle) {
        ObjectAnimator translationY = ObjectAnimator.ofFloat(objView, "translationY", angle, 0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(translationY);
        animatorSet.setDuration(500).start();
    }
}
