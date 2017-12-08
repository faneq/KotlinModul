package com.example.library.base;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by fanenqian on 2017/12/8.
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface Singleton{}
