package com.wtmcodex.samplepaymentapp.core.di.module;

import com.wtmcodex.samplepaymentapp.core.di.scope.ComputationScheduler;
import com.wtmcodex.samplepaymentapp.core.di.scope.IOScheduler;
import com.wtmcodex.samplepaymentapp.core.di.scope.UIScheduler;


import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Module
public abstract class SchedulerModule {
    @Provides
    @ComputationScheduler
    public static Scheduler provideComputationScheduler() {
        return Schedulers.computation();
    }

    @Provides
    @IOScheduler
    public static Scheduler provideIOScheduler() {
        return Schedulers.io();
    }

    @Provides
    @UIScheduler
    public static Scheduler provideUIScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
