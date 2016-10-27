package com.rance.beautypapa.presenter;


import com.rance.beautypapa.base.BasePresenter;
import com.rance.beautypapa.model.NewsEntity;
import com.rance.beautypapa.model.VideoEntity;
import com.rance.beautypapa.net.ApiCallback;
import com.rance.beautypapa.view.MainView;
import com.rance.beautypapa.view.NewsView;

import java.util.HashMap;
import java.util.List;

/**
 * 作者：Rance on 2016/10/25 15:19
 * 邮箱：rance935@163.com
 */
public class NewsPresenter extends BasePresenter<NewsView> {

    public NewsPresenter(NewsView view) {
        attachView(view);
    }

    public void getVideoList() {
        mvpView.showLoading();
        addSubscription(zhihuApiStores.getLatestNews(), new ApiCallback<NewsEntity>() {
            @Override
            public void onSuccess(NewsEntity model) {
                mvpView.getNewsSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getNewsFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        });
    }

    public void getBeforetNews(String time) {
        mvpView.showLoading();
        addSubscription(zhihuApiStores.getBeforetNews(time), new ApiCallback<NewsEntity>() {
            @Override
            public void onSuccess(NewsEntity model) {
                mvpView.getNewsSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getNewsFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        });
    }
}
