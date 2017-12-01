package com.example.library.base.module

import com.example.library.base.DaggerTest
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by fanenqian on 2017/12/1.
 */
@Module
class AppModule {
    @Provides
    @Singleton
    @Named("something")
    fun provideSomething(): String = "dagger创建对象成功"

    @Provides
    fun getTest(): DaggerTest {
        return DaggerTest()
    }
}