package com.wtmcodex.samplepaymentapp.core.di.module;

import android.app.Application;
import android.content.Context;

import com.wtmcodex.samplepaymentapp.core.Domain;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    @Singleton
    public static Context provideContext(Application application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    public static Domain provideDomain(Context context) {
        return Domain.getInstance(context);
    }
}
