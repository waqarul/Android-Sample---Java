package com.wtmcodex.samplepaymentapp.core.data.source.remote;

import com.wtmcodex.samplepaymentapp.core.data.model.ListResult;

import io.reactivex.rxjava3.core.Observable;

public interface PaymentRemoteDataSource {
    Observable<ListResult> getPayments();
}
