package com.rance.beautypapa.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.rance.beautypapa.R;
import com.rance.beautypapa.adapter.BaseFragmentAdapter;
import com.rance.beautypapa.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.tabs)
    TabLayout mTabLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;

    List<Fragment> mFragments;
    String[] mTitles = new String[]{
            "热门", "搞笑", "逗比", "明星名人", "男神", "女神", "音乐", "舞蹈", "旅行", "美食", "美妆时尚", "涨姿势", "宝宝", "萌宠乐园", "二次元"
    };
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar.setTitle("爱啪啪");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setupViewPager();
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
                new BaseFragmentAdapter(getSupportFragmentManager(), mFragments, mTitles);

        mViewPager.setAdapter(adapter);
        //  第三步：将ViewPager与TableLayout 绑定在一起
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
