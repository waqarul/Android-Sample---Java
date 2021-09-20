package com.wtmcodex.samplepaymentapp.core.di.module;


import com.wtmcodex.samplepaymentapp.core.di.scope.PerActivity;
import com.wtmcodex.samplepaymentapp.features.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @PerActivity
    @ContributesAndroidInjector(modules = {FragmentBuilderModule.class})
    abstract MainActivity contributeMainActivity();
}
