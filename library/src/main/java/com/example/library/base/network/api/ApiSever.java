package com.example.library.base.network.api;


import com.example.library.base.network.WeatherEntity;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by guangjiego on 2017/3/21.
 */

public interface ApiSever {
    @GET("open/api/weather/json.shtml")
    Flowable<WeatherEntity> getTitles(@Query("city") String city);
}
