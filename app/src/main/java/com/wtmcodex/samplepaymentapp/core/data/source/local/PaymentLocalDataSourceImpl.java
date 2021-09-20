package com.wtmcodex.samplepaymentapp.core.data.source.local;

import androidx.annotation.NonNull;

import com.wtmcodex.samplepaymentapp.core.data.source.local.dao.PaymentDao;
import com.wtmcodex.samplepaymentapp.core.data.source.local.entity.DBPayment;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class PaymentLocalDataSourceImpl implements PaymentLocalDataSource {
    private PaymentDao paymentDao;

    @Inject
    public PaymentLocalDataSourceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public Completable insertPayment(DBPayment payment) {
        return paymentDao.insertPayment(payment);
    }

    @Override
    public Completable insertAll(@NonNull DBPayment... items) {
        return paymentDao.insertAll(items);
    }

    @Override
    public Observable<DBPayment> getAllPayments() {
        return paymentDao.getAllPayments();
    }

    @Override
    public Single<DBPayment> getPaymentByID(int id) {
        return paymentDao.getPaymentByID(id);
    }

    @Override
    public Completable deleteAllPayments() {
        return paymentDao.deleteAllPayments();
    }
}
