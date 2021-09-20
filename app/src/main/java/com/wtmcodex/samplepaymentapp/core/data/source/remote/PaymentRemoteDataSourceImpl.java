package com.wtmcodex.samplepaymentapp.core.data.source.remote;

import com.wtmcodex.samplepaymentapp.core.data.model.ListResult;
import com.wtmcodex.samplepaymentapp.core.data.source.remote.retrofit.PaymentApiService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class PaymentRemoteDataSourceImpl implements PaymentRemoteDataSource {
    private PaymentApiService apiService;

    @Inject
    public PaymentRemoteDataSourceImpl(PaymentApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<ListResult> getPayments() {
        return apiService.getPayments();
    }
}
