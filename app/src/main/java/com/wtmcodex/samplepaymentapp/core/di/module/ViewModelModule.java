package com.wtmcodex.samplepaymentapp.core.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.wtmcodex.samplepaymentapp.ViewModelFactory;
import com.wtmcodex.samplepaymentapp.core.di.key.ViewModelKey;
import com.wtmcodex.samplepaymentapp.features.home.HomeViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);

    @IntoMap
    @Binds
    @ViewModelKey(HomeViewModel.class)
    abstract ViewModel bindHomeViewModel(HomeViewModel viewModel);
}
