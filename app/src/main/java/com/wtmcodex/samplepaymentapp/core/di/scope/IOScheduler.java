package com.wtmcodex.samplepaymentapp.core.di.scope;

import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;

@Retention(AnnotationRetention.BINARY)
@Qualifier
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
public @interface IOScheduler {
}

