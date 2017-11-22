package com.example.library.base

import android.app.Application
import android.util.Log

/**
 * Created by fanenqian on 2017/11/22.
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.i("1", "1")
    }
}