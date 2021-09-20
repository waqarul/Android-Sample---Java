package com.wtmcodex.samplepaymentapp.core.data.source.repository;

import com.wtmcodex.samplepaymentapp.core.data.model.ApplicableNetwork;
import com.wtmcodex.samplepaymentapp.core.data.model.ListResult;
import com.wtmcodex.samplepaymentapp.core.data.model.PaymentModel;
import com.wtmcodex.samplepaymentapp.core.data.source.local.PaymentLocalDataSource;
import com.wtmcodex.samplepaymentapp.core.data.source.local.entity.DBPayment;
import com.wtmcodex.samplepaymentapp.core.data.source.remote.PaymentRemoteDataSource;
import com.wtmcodex.samplepaymentapp.core.di.scope.IOScheduler;
import com.wtmcodex.samplepaymentapp.mapper.PaymentMapperRemote;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public final class PaymentRepositoryImpl implements PaymentRepository {
    private PaymentLocalDataSource paymentLocalDataSource;
    private PaymentRemoteDataSource paymentRemoteDataSource;

    @Inject
    @IOScheduler
    Scheduler ioScheduler;

    @Inject
    public PaymentRepositoryImpl(PaymentLocalDataSource paymentLocalDataSource, PaymentRemoteDataSource paymentRemoteDataSource) {
        this.paymentLocalDataSource = paymentLocalDataSource;
        this.paymentRemoteDataSource = paymentRemoteDataSource;
    }

    @Override
    public Completable insertAll(PaymentModel... items) {
        // TODO: Not implemented
        return null;
    }

    @Override
    public Completable insertPayment(PaymentModel payment) {
        // TODO: Not implemented
        return null;
    }

    @Override
    public Observable<List<PaymentModel>> getAllPayments() {
        return Observable.create(emitter -> {
            paymentRemoteDataSource.getPayments().subscribeOn(Schedulers.io()).subscribe(new DisposableObserver<ListResult>() {
                @Override
                public void onNext(@NonNull ListResult listResult) {
                    if (listResult == null || listResult.getNetworks() == null || listResult.getNetworks().getApplicable() == null || listResult.getNetworks().getApplicable().isEmpty()) {
                        emitter.onError(new Throwable("No result found"));
                    }

                    List<ApplicableNetwork> applicable = listResult.getNetworks().getApplicable();
                    PaymentMapperRemote mapper = new PaymentMapperRemote();
                    emitter.onNext(mapper.transformToDomain(applicable));
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    emitter.onError(e);
                }

                @Override
                public void onComplete() {
                    emitter.onComplete();
                }
            });
        });
    }

    @Override
    public Single<PaymentModel> getPaymentByID(int id) {
        // TODO: Not implemented
        return null;
    }

    @Override
    public Completable deleteAllPayments() {
        // TODO: Not implemented
        return null;
    }
}