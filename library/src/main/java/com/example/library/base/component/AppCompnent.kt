package com.example.library.base.component

import android.support.v7.app.AppCompatActivity
import com.example.library.base.BaseApplication
import com.example.library.base.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by fanenqian on 2017/12/1.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(baseApplication: BaseApplication)
    fun inject(baseApplication: AppCompatActivity)
}
