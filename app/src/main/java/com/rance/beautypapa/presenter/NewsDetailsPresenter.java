package com.rance.beautypapa.presenter;


import com.rance.beautypapa.base.BasePresenter;
import com.rance.beautypapa.model.NewsDetailsEntity;
import com.rance.beautypapa.net.ApiCallback;
import com.rance.beautypapa.view.NewsDetailsView;

/**
 * 作者：Rance on 2016/10/25 15:19
 * 邮箱：rance935@163.com
 */
public class NewsDetailsPresenter extends BasePresenter<NewsDetailsView> {

    public NewsDetailsPresenter(NewsDetailsView view) {
        attachView(view);
    }

    public void getDetailNews(String id) {
        mvpView.showLoading();
        addSubscription(zhihuApiStores.getDetailNews(id), new ApiCallback<NewsDetailsEntity>() {
            @Override
            public void onSuccess(NewsDetailsEntity model) {
                mvpView.getNewsDetailsSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getNewsDetailsFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        });
    }

}
