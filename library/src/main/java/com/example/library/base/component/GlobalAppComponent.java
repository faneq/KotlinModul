package com.example.library.base.component;

import android.content.Context;

import com.example.library.base.module.RetrofitModule;

public class GlobalAppComponent {
    private volatile static BaseComponent mAppComponent;

    /**
     * 初始化全局AppComponent
     *
     * @param context applicationContext
     */
    public static void init(Context context) {
        if (mAppComponent == null) {
            synchronized (GlobalAppComponent.class) {
                if (mAppComponent == null) {
                    mAppComponent = DaggerBaseComponent.builder()
                            .baseModule(new BaseModule(context)).retrofitModule(new RetrofitModule(context))
                            .build();
                }
            }
        }
    }

    public static BaseComponent getAppComponent() {
        if (mAppComponent == null) {
            throw (new NullPointerException("GlobalAppComponent必须在application中进行init初始化"));
        }
        return mAppComponent;
    }
}
