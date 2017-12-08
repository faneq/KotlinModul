package com.example.library.base.network;


import com.example.library.base.network.api.ApiSever;
import com.example.library.base.network.api.UrlManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Context:网路请求相关
 * Created by fanenqian on 2017/4/24 18:01
 */
public class RetrofitHelper {
    private OkHttpClient client;
    private ApiSever apiSever;

    public RetrofitHelper(OkHttpClient client) {
        this.client = client;
        init();
    }

    private void init() {
        apiSever = getApiService(UrlManager.WEATHER_HOST, ApiSever.class);
    }

    private <T> T getApiService(String kaiyanHost, Class<T> apiSeverClass) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(kaiyanHost)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        return retrofit.create(apiSeverClass);
    }

   public ApiSever getApiSever() {
        return apiSever;
    }

}
