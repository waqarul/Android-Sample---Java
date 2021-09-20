package com.wtmcodex.samplepaymentapp.core.data.source.repository;

import com.wtmcodex.samplepaymentapp.core.data.model.PaymentModel;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public interface PaymentRepository {

    Completable insertAll(PaymentModel... item);

    Completable insertPayment(PaymentModel payment);

    Observable<List<PaymentModel>> getAllPayments();

    Single<PaymentModel> getPaymentByID(int id);

    Completable deleteAllPayments();
}
