package com.rance.beautypapa.net;

import com.rance.beautypapa.model.VideoEntity;

import java.util.HashMap;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * 作者：Rance on 2016/10/25 15:19
 * 邮箱：rance935@163.com
 */
public interface VideoApiStores {

    String API_SERVER_URL = "http://newapi.meipai.com/output/";

    /**
     * 获取视频列表
     * @param map
     * @return
     */
    @GET("channels_topics_timeline.json")
    Observable<List<VideoEntity>> getVideoList(@QueryMap HashMap<String, Object> map);
}
