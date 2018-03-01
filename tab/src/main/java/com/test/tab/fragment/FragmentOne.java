package com.test.tab.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.tab.R;

/**
 * Created by lady_zhou on 2018/2/28.
 */

public class FragmentOne extends Fragment {
    private static FragmentOne instance = null;
    private View mView;


    private static FragmentOne newInstance() {
        if (instance == null) {
            instance = new FragmentOne();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_one, container, false);
        return mView;
    }
}
