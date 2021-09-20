package com.wtmcodex.samplepaymentapp.core.di.scope;

import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;

@Scope
@Retention(AnnotationRetention.RUNTIME)
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}