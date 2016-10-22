package com.rance.beautypapa.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rance.beautypapa.R;
import com.rance.beautypapa.base.BaseMvpViewPagerFragment;
import com.rance.beautypapa.base.BasePresenter;
import com.rance.beautypapa.model.VideoEntity;
import com.rance.beautypapa.presenter.MainPresenter;
import com.rance.beautypapa.view.MainView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Rance
 * on 2016/10/22.
 */
public class VideoListFragment extends BaseMvpViewPagerFragment<MainPresenter> implements MainView{

    private int index = 0;
    private String[] ids = {"1", "13", "64", "16", "31", "19", "62", "63", "3", "59", "27", "5", "18", "6", "193"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.layout_only_list, container, false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(VideoListFragment.this);
    }

    private void initView(){
        index = getArguments().getInt("index", 0);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", ids[index]);
        mvpPresenter.getVideoList(map);
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        if (isVisible) {
            //   do things when fragment is visible
            //    if (ListUtils.isEmpty(mDataList) && !isRefreshing()) {
            //        setRefresh(true);
            //        loadServiceData(false);
        } else {
            //        setRefresh(false);
        }
    }

    @Override
    public void getVideoSuccess(List<VideoEntity> videoEntity) {

    }

    @Override
    public void getVideoFail(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

}
