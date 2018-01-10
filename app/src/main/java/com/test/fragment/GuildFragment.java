package com.test.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.baselibrary.CustomView.CustomVideoView;
import com.test.baselibrary.base.BaseLazyFragment;
import com.test.baseutil.R;

/**
 * Created by lady_zhou on 2018/1/10.
 */

//public class GuildFragment extends BaseLazyFragment {
public class GuildFragment extends Fragment {
    public static final String GUILDFRAGMENT = "GuildFragment";

    private Uri mUri;
    private CustomVideoView mCustomVideoView;

    private int mIndex;

//    @Override
//    protected void initData(Bundle arguments, Bundle savedInstanceState) {
//        mCustomVideoView = new CustomVideoView(getActivity());
//        mIndex = arguments.getInt(GUILDFRAGMENT);
//
//        switch (mIndex) {
//            case 1:
//                mUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_1);
//
//                break;
//            case 2:
//                mUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_2);
//                break;
//            case 3:
//                mUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_3);
//                break;
//        }
//
//        mCustomVideoView.playVideo(mUri);
//    }
//
//    @Override
//    protected int getLayoutId() {
//        return R.layout.fragment_guild;
//    }
//
//    @Override
//    protected void initView(Bundle savedInstanceState) {
//    }
//
//    @Override
//    protected void initListener() {
//
//    }
//
//    @Override
//    protected void onViewClick(View v) {
//
//    }
//
//    @Override
//    protected void lazyLoad() {
//
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCustomVideoView = new CustomVideoView(getContext());
        /**获取参数，根据不同的参数播放不同的视频**/
        mIndex = getArguments().getInt(GUILDFRAGMENT);
        Log.d("123", mIndex + "");
//
        switch (mIndex) {
            case 1:
                mUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_1);
                break;
            case 2:
                mUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_2);
                break;
            case 3:
                mUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_3);
                break;
        }

        mCustomVideoView.playVideo(mUri);
        return mCustomVideoView;
    }

    /**
     * 记得在销毁的时候让播放的视频终止
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mCustomVideoView != null) {
            mCustomVideoView.stopPlayback();
        }
    }
}
