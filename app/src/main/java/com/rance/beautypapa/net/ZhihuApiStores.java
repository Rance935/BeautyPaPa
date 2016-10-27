package com.rance.beautypapa.net;

import com.rance.beautypapa.model.NewsDetailsEntity;
import com.rance.beautypapa.model.NewsEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 作者：Rance on 2016/10/25 15:19
 * 邮箱：rance935@163.com
 */
public interface ZhihuApiStores {
    String API_SERVER_URL = "http://news-at.zhihu.com/api/4/";

    @GET("news/latest")
    Observable<NewsEntity> getLatestNews();

    @GET("news/before/{time}")
    Observable<NewsEntity> getBeforetNews(@Path("time") String time);

    @GET("news/{id}")
    Observable<NewsDetailsEntity> getDetailNews(@Path("id") String id);
}
