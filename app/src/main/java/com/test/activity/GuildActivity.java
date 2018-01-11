package com.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.test.adapter.CardSlideTransformer;
import com.test.adapter.GuildAdapter;
import com.test.baselibrary.base.BaseActivity;
import com.test.baseutil.R;
import com.test.fragment.GuildFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lady_zhou on 2018/1/10.
 */

public class GuildActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private ImageView mIvTip1;
    private ImageView mIvTip2;
    private ImageView mIvTip3;
    private Button mBtStart;

    private GuildAdapter mGuildAdapter;

    private ViewPager mViewPager;

    private List<Fragment> mList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guild;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mViewPager = findViewById(R.id.viewPager);

        mIvTip1 = findViewById(R.id.iv_1);
        mIvTip2 = findViewById(R.id.iv_2);
        mIvTip3 = findViewById(R.id.iv_3);
        mBtStart = findViewById(R.id.bt_start);
    }

    @Override
    protected void initData(Intent intent, Bundle savedInstanceState) {

        GuildFragment guildFragment1 = new GuildFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putInt(GuildFragment.GUILDFRAGMENT, 1);
        guildFragment1.setArguments(bundle1);

        GuildFragment guildFragment2 = new GuildFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt(GuildFragment.GUILDFRAGMENT, 2);
        guildFragment2.setArguments(bundle2);


        GuildFragment guildFragment3 = new GuildFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putInt(GuildFragment.GUILDFRAGMENT, 3);
        guildFragment3.setArguments(bundle3);

        mList.add(guildFragment1);
        mList.add(guildFragment2);
        mList.add(guildFragment3);

        mViewPager.setAdapter(new GuildAdapter(getSupportFragmentManager(), mList));
        mViewPager.addOnPageChangeListener(this);
//        mViewPager.setPageTransformer(true, new CardSlideTransformer());
    }

    @Override
    protected void initListener() {
        mBtStart.setOnClickListener(this);
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:
                startActivity(new Intent(this, TestActivity.class));
                finish();
                break;
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mBtStart.setVisibility(View.GONE);
        mIvTip1.setImageResource(R.mipmap.dot_normal);
        mIvTip2.setImageResource(R.mipmap.dot_normal);
        mIvTip3.setImageResource(R.mipmap.dot_normal);
        if (position == 0) {
            mIvTip1.setImageResource(R.mipmap.dot_focus);
        } else if (position == 1) {
            mIvTip2.setImageResource(R.mipmap.dot_focus);
        } else {
            mIvTip3.setImageResource(R.mipmap.dot_focus);
            mBtStart.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
