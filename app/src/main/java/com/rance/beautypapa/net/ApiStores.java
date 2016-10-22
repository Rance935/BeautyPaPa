package com.rance.beautypapa.net;

import com.rance.beautypapa.model.VideoEntity;

import java.util.HashMap;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Rance
 * on 2016/10/22.
 */
public interface ApiStores {
    //baseUrl
    String API_SERVER_URL = "http://newapi.meipai.com/output/";

    /**
     * 获取视频列表
     * @param map
     * @return
     */
    @GET("channels_topics_timeline.json")
    Observable<List<VideoEntity>> getVideoList(@QueryMap HashMap<String, String> map);
}
