package com.test.tab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bt_tab1)
    Button wayOne;
    @BindView(R.id.bt_tab2)
    Button wayTwo;
    @BindView(R.id.bt_tab3)
    Button wayThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_tab1)
    public void clickTab1() {
        startActivity(new Intent(this,ViewpagerAndFragmentActivity.class));
    }

    @OnClick(R.id.bt_tab2)
    public void clickTab2() {
        startActivity(new Intent(this,FragmentTransactionActivity.class));

    }

    @OnClick(R.id.bt_tab3)
    public void clickTab3() {
        startActivity(new Intent(this,TablayoutActivity.class));

    }
}
