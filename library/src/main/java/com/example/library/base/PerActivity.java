package com.example.library.base;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by fanenqian on 2017/4/25 14:44
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}