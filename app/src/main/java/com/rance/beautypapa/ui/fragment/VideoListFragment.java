package com.rance.beautypapa.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.rance.beautypapa.R;
import com.rance.beautypapa.adapter.VideoRecyclerAdapter;
import com.rance.beautypapa.base.BaseMvpViewPagerFragment;
import com.rance.beautypapa.model.VideoEntity;
import com.rance.beautypapa.presenter.MainPresenter;
import com.rance.beautypapa.ui.activity.WebViewActivity;
import com.rance.beautypapa.view.MainView;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：Rance on 2016/10/25 15:19
 * 邮箱：rance935@163.com
 */
public class VideoListFragment extends BaseMvpViewPagerFragment<MainPresenter> implements MainView, RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.recyclerView)
    EasyRecyclerView mRecyclerView;
    private int index = 0;
    private String[] ids = {"1", "13", "64", "16", "31", "19", "62", "63", "3", "59", "27", "5", "18", "6", "193"};
    private VideoRecyclerAdapter mVideoRecyclerAdapter;
    private LinearLayoutManager mLayoutManager;
    private int page = 1;
    private int count = 10;
    private List<VideoEntity> videoEntities = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.layout_only_list, container, false);
        }
        ButterKnife.bind(this, rootView);
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

    private void initView() {
        index = getArguments().getInt("index", 0);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mVideoRecyclerAdapter = new VideoRecyclerAdapter(getActivity());
        mRecyclerView.setAdapter(mVideoRecyclerAdapter);

        mVideoRecyclerAdapter.setMore(R.layout.view_more, this);
        mVideoRecyclerAdapter.setError(R.layout.view_error);
        mRecyclerView.setRefreshListener(this);
        mRecyclerView.setEmptyView(R.layout.view_empty);
        mVideoRecyclerAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", videoEntities.get(position).getUrl());
                getActivity().startActivity(intent);
            }
        });
        getVideoList();
    }

    public void getVideoList() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", ids[index]);
        map.put("page", page);
        map.put("count", count);
        if (videoEntities.size() > 0) {
            map.put("max_id", videoEntities.get(videoEntities.size() - 1).getId());
        }
        mvpPresenter.getVideoList(map);
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        if (isVisible) {

        } else {
//            setRefresh(false);
        }
    }

    @Override
    public void getVideoSuccess(List<VideoEntity> videoEntity) {
        videoEntities.addAll(videoEntity);
        mVideoRecyclerAdapter.addAll(videoEntity);
    }

    @Override
    public void getVideoFail(String msg) {
        toastShow(msg);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onRefresh() {
        page = 1;
        mVideoRecyclerAdapter.clear();
        getVideoList();
    }

    @Override
    public void onLoadMore() {
        page++;
        getVideoList();
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("VideoListFragment"); //统计页面
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("VideoListFragment");
    }

}
