package com.rance.beautypapa.net;

import com.rance.beautypapa.BuildConfig;
import com.rance.beautypapa.base.MyApplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：Rance on 2016/10/25 15:19
 * 邮箱：rance935@163.com
 */
public class AppClient {
    public static Retrofit mVideoRetrofit;
    public static Retrofit mZhiHuRetrofit;
    private static OkHttpClient okHttpClient;

    public static Retrofit getVideoRetrofit() {
        if (mVideoRetrofit == null) {
            mVideoRetrofit = new Retrofit.Builder()
                    .baseUrl(VideoApiStores.API_SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(getOkHttpClient())
                    .build();
        }
        return mVideoRetrofit;
    }

    public static Retrofit getZhiHURetrofit() {
        if (mZhiHuRetrofit == null) {
            mZhiHuRetrofit = new Retrofit.Builder()
                    .baseUrl(ZhihuApiStores.API_SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(getOkHttpClient())
                    .build();
        }
        return mZhiHuRetrofit;
    }

    public static OkHttpClient getOkHttpClient(){
        if (okHttpClient == null){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (BuildConfig.DEBUG) {
                // Log信息拦截器
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                //设置 Debug Log 模式
                builder.addInterceptor(loggingInterceptor);
            }
            //cache url
            File httpCacheDirectory = new File(MyApplication.mContext.getExternalCacheDir(), "responses");
            int cacheSize = 10 * 1024 * 1024; // 10 MiB
            Cache cache = new Cache(httpCacheDirectory, cacheSize);
            builder.cache(cache);
            builder.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
            okHttpClient = builder.build();
        }
        return okHttpClient;
    }

    //cache
    static Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            CacheControl.Builder cacheBuilder = new CacheControl.Builder();
            cacheBuilder.maxAge(0, TimeUnit.SECONDS);
            cacheBuilder.maxStale(365, TimeUnit.DAYS);
            CacheControl cacheControl = cacheBuilder.build();

            Request request = chain.request();
            if (!MyApplication.isNetworkAvailable(MyApplication.getInstance())) {
                request = request.newBuilder()
                        .cacheControl(cacheControl)
                        .build();

            }
            Response originalResponse = chain.proceed(request);
            if (MyApplication.isNetworkAvailable(MyApplication.getInstance())) {
                int maxAge = 0; // read from cache
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-xcached, max-stale=" + maxStale)
                        .build();
            }
        }
    };

}
