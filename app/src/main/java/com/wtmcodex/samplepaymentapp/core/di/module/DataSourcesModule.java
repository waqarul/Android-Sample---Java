package com.wtmcodex.samplepaymentapp.core.di.module;

import com.wtmcodex.samplepaymentapp.core.data.source.local.PaymentLocalDataSource;
import com.wtmcodex.samplepaymentapp.core.data.source.local.PaymentLocalDataSourceImpl;
import com.wtmcodex.samplepaymentapp.core.data.source.remote.PaymentRemoteDataSource;
import com.wtmcodex.samplepaymentapp.core.data.source.remote.PaymentRemoteDataSourceImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataSourcesModule {
    @Binds
    abstract PaymentLocalDataSource bindLocalDataSource(PaymentLocalDataSourceImpl paymentLocalDataSourceImpl);

    @Binds
    abstract PaymentRemoteDataSource bindRemoteDataSource(PaymentRemoteDataSourceImpl paymentRemoteDataSourceImpl);
}
