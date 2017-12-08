package com.example.library.base.component

import android.content.Context
import com.example.library.base.network.RetrofitHelper
import com.example.library.base.network.api.ApiSever
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

/**
 * Created by fanenqian on 2017/12/4.
 */
@Module
public class BaseModule(baseApplication: Context) {
    var application: Context = baseApplication


//    @Provides
//    @Singleton
//    fun provideContext(): Context {
//        return application
//    }

    @Provides
    fun providesApiService(): ApiSever {
        val retrofitHelper = RetrofitHelper(OkHttpClient())
        return retrofitHelper.apiSever
    }

}