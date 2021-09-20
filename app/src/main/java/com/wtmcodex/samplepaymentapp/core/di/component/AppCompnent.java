package com.wtmcodex.samplepaymentapp.core.di.component;


import android.app.Application;

import com.wtmcodex.samplepaymentapp.PaymentAppApplication;
import com.wtmcodex.samplepaymentapp.core.di.module.ActivityBindingModule;
import com.wtmcodex.samplepaymentapp.core.di.module.AppModule;
import com.wtmcodex.samplepaymentapp.core.di.module.DataSourcesModule;
import com.wtmcodex.samplepaymentapp.core.di.module.DatabaseModule;
import com.wtmcodex.samplepaymentapp.core.di.module.NetworkModule;
import com.wtmcodex.samplepaymentapp.core.di.module.RepositoryModule;
import com.wtmcodex.samplepaymentapp.core.di.module.SchedulerModule;
import com.wtmcodex.samplepaymentapp.core.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ActivityBindingModule.class,
        AppModule.class,
        DatabaseModule.class,
        DataSourcesModule.class,
        NetworkModule.class,
        RepositoryModule.class,
        SchedulerModule.class,
        ViewModelModule.class
})
public interface AppCompnent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppCompnent build();
    }

    void inject(PaymentAppApplication application);
}
