package com.rance.beautypapa.base;

import com.rance.beautypapa.net.AppClient;
import com.rance.beautypapa.net.VideoApiStores;
import com.rance.beautypapa.net.ZhihuApiStores;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 作者：Rance on 2016/10/25 15:19
 * 邮箱：rance935@163.com
 */
public class BasePresenter<V> {
    public V mvpView;
    protected VideoApiStores videoapiStores;
    protected ZhihuApiStores zhihuApiStores;
    private CompositeSubscription mCompositeSubscription;

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
        videoapiStores = AppClient.getVideoRetrofit().create(VideoApiStores.class);
        zhihuApiStores = AppClient.getZhiHURetrofit().create(ZhihuApiStores.class);
    }


    public void detachView() {
        this.mvpView = null;
        onUnsubscribe();
    }


    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }


    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }
}
