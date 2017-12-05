package com.example.library.base.component

import com.example.library.base.DaggerTest
import dagger.Module
import dagger.Provides

/**
 * Created by fanenqian on 2017/12/4.
 */
@Module
public class BaseModule {
    @Provides
    fun getTest(): Read {
        return Read()
    }

    @Provides
    fun getDaggerTest(): DaggerTest {
        return DaggerTest()
    }
}