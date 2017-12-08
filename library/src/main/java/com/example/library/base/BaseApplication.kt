package com.example.library.base

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.example.library.base.component.BaseComponent
import com.example.library.base.component.GlobalAppComponent

/**
 * Created by fanenqian on 2017/11/22.
 */
open class BaseApplication : Application() {
    private var isDebug: Boolean = true
    private lateinit var context: Context

    override fun onCreate() {
        super.onCreate()
        context = this
        println("基础包Application")
        if (isDebug) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化GlobalAppComponent
        initBaseComponent()
        getAppComponent().inject(this)
    }

    private fun initBaseComponent() {
        GlobalAppComponent.init(this)
    }

    public fun getAppComponent(): BaseComponent {
        return GlobalAppComponent.getAppComponent()
    }
}