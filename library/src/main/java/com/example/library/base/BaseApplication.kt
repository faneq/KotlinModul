package com.example.library.base

import android.app.Application
import android.content.Context
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.example.library.base.component.DaggerAppComponent
import com.example.library.base.module.AppModule
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by fanenqian on 2017/11/22.
 */
open class BaseApplication : Application() {
    private var isDebug: Boolean = true
    private lateinit var context: Context
    @field:[Inject Named("something")]
    lateinit var something: String
    @Inject lateinit var daggerTest: DaggerTest
    override fun onCreate() {
        super.onCreate()
        context = this
        println("基础包Application")
        if (isDebug) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化
        initDagger()
    }

    private fun initDagger() {
        DaggerAppComponent.builder().appModule(AppModule()).build().inject(context as BaseApplication)
        Toast.makeText(this, "$something", Toast.LENGTH_SHORT).show()
        daggerTest.show()
    }
}