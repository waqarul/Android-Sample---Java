package com.wtmcodex.samplepaymentapp.core.data.source.local;


import com.wtmcodex.samplepaymentapp.core.data.source.local.entity.DBPayment;

import org.jetbrains.annotations.NotNull;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public interface PaymentLocalDataSource {

    Completable insertAll(@NotNull DBPayment... items);

    Completable insertPayment(DBPayment payment);

    Observable<DBPayment> getAllPayments();

    Single<DBPayment> getPaymentByID(int id);

    Completable deleteAllPayments();
}
