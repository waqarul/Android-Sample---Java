package com.wtmcodex.samplepaymentapp.core.di.key;

import androidx.lifecycle.ViewModel;

import dagger.MapKey;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;


@MapKey
@Retention(AnnotationRetention.RUNTIME)
@Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@Documented
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({ElementType.METHOD})

public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}
