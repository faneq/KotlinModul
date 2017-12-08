package com.example.library.base.component

import com.example.library.base.BaseApplication
import com.example.library.base.Singleton
import com.example.library.base.module.RetrofitModule
import com.example.library.base.network.api.ApiSever
import dagger.Component

/**
 * Created by fanenqian on 2017/12/4.
 */
@Singleton
@Component(modules = arrayOf(BaseModule::class, RetrofitModule::class))
interface BaseComponent {
//    fun getContext(): Context

    fun inject(baseApplication: BaseApplication)
    fun getApiServices(): ApiSever
}
