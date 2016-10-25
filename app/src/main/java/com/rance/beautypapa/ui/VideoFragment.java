package com.rance.beautypapa.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rance.beautypapa.R;
import com.rance.beautypapa.adapter.BaseFragmentAdapter;
import com.rance.beautypapa.base.BaseActivity;
import com.rance.beautypapa.base.BaseFragment;
import com.rance.beautypapa.base.ViewPagerFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：Rance on 2016/10/25 15:19
 * 邮箱：rance935@163.com
 */
public class VideoFragment extends ViewPagerFragment {

    @Bind(R.id.tabs)
    TabLayout mTabLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;

    List<Fragment> mFragments;
    String[] mTitles = new String[]{
            "热门", "搞笑", "逗比", "明星名人", "男神", "女神", "音乐", "舞蹈", "旅行", "美食", "美妆时尚", "涨姿势", "宝宝", "萌宠乐园", "二次元"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_video, container, false);
        }
        ButterKnife.bind(this, rootView);
        setupViewPager();
        return rootView;
    }

    private void setupViewPager() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            VideoListFragment videoListFragment = new VideoListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            videoListFragment.setArguments(bundle);
            mFragments.add(videoListFragment);
        }
        // 第二步：为ViewPager设置适配器
        BaseFragmentAdapter adapter =
                new BaseFragmentAdapter(getChildFragmentManager(), mFragments, mTitles);

        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(1);
        //  第三步：将ViewPager与TableLayout 绑定在一起
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
