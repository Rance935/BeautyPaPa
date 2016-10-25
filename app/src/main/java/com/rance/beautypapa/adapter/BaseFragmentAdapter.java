package com.rance.beautypapa.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Rance on 2016/10/25 15:19
 * 邮箱：rance935@163.com
 */
public class BaseFragmentAdapter extends FragmentPagerAdapter {

    protected List<Fragment> fragmentList;

    protected String[] mTitles;

    public BaseFragmentAdapter(FragmentManager fm) {
        this(fm, null, null);
    }

    public BaseFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] mTitles) {
        super(fm);
        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        this.fragmentList = fragmentList;
        this.mTitles = mTitles;
    }

    public void add(Fragment fragment) {
        if (isEmpty()) {
            fragmentList = new ArrayList<>();

        }
        fragmentList.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return isEmpty() ? null : fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return isEmpty() ? 0 : fragmentList.size();
    }

    public boolean isEmpty() {
        return fragmentList == null;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    /*  @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }*/
}
