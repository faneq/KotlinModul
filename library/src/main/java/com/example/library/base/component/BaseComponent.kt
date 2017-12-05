package com.example.library.base.component

import com.example.library.base.BaseApplication
import com.example.library.base.DaggerTest
import dagger.Component

/**
 * Created by fanenqian on 2017/12/4.
 */
@Component(modules = arrayOf(BaseModule::class))
interface BaseComponent {
    fun getRead(): Read
    fun getDaggerTes(): DaggerTest
    fun inject(baseApplication: BaseApplication)
}
