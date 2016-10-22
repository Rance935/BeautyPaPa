package com.rance.beautypapa.presenter;


import com.rance.beautypapa.base.BasePresenter;
import com.rance.beautypapa.model.VideoEntity;
import com.rance.beautypapa.net.ApiCallback;
import com.rance.beautypapa.view.MainView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Race
 * on 2016/9/23.
 */
public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view) {
        attachView(view);
    }

    public void getVideoList(HashMap<String, String> map) {
        mvpView.showLoading();
        addSubscription(apiStores.getVideoList(map), new ApiCallback<List<VideoEntity>>() {
            @Override
            public void onSuccess(List<VideoEntity> model) {
                mvpView.getVideoSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getVideoFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        });
    }

}
