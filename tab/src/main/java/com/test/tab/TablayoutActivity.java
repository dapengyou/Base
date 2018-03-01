package com.test.tab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.test.tab.adapter.ViewPageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TablayoutActivity extends AppCompatActivity {
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        ViewPageAdapter viewPagerAdapter = new ViewPageAdapter(getSupportFragmentManager());


    }
}
