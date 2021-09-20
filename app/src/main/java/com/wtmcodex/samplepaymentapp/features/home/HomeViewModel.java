package com.wtmcodex.samplepaymentapp.features.home;

import android.os.Bundle;

import androidx.lifecycle.MutableLiveData;

import com.wtmcodex.samplepaymentapp.helpers.AlertMessagesHelper;
import com.wtmcodex.samplepaymentapp.helpers.Utils;
import com.wtmcodex.samplepaymentapp.core.Domain;
import com.wtmcodex.samplepaymentapp.core.data.model.PaymentModel;
import com.wtmcodex.samplepaymentapp.core.data.source.repository.PaymentRepository;
import com.wtmcodex.samplepaymentapp.core.di.scope.IOScheduler;
import com.wtmcodex.samplepaymentapp.core.di.scope.UIScheduler;
import com.wtmcodex.samplepaymentapp.features.BaseViewModel;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.observers.DisposableObserver;

public class HomeViewModel extends BaseViewModel {
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<Boolean>();
    private MutableLiveData<Boolean> isRecordFound = new MutableLiveData<Boolean>();
    private MutableLiveData<Boolean> showRefreshIndicator = new MutableLiveData<Boolean>();
    private MutableLiveData<List<PaymentViewItem>> viewItems = new MutableLiveData<List<PaymentViewItem>>();

    private Domain domain;
    private PaymentRepository paymentRepository;
    @IOScheduler
    private Scheduler ioScheduler;
    @UIScheduler
    private Scheduler uiScheduler;

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public MutableLiveData<Boolean> getIsRecordFound() {
        return isRecordFound;
    }

    public MutableLiveData<Boolean> getShowRefreshIndicator() {
        return showRefreshIndicator;
    }

    public MutableLiveData<List<PaymentViewItem>> getViewItems() {
        return viewItems;
    }

    @Inject
    public HomeViewModel(Domain domain, PaymentRepository paymentRepository, @IOScheduler Scheduler ioScheduler, @UIScheduler Scheduler uiScheduler) {
        this.domain = domain;
        this.paymentRepository = paymentRepository;
        this.ioScheduler = ioScheduler;
        this.uiScheduler = uiScheduler;
    }

    @Override
    protected void loadData(Bundle params) {
        makeRequestToFetchPaymentMethods(true);
    }

    public void makeRequestToFetchPaymentMethods(boolean showLoading) {
        makeRequest(showLoading);
    }

    private void makeRequest(boolean showLoading) {

        if (!Utils.isNetworkAvailable(domain.getContext())) {
            showAlertDialog.postValue(AlertMessagesHelper.getNoInternetConnectionAlertModel(domain.getContext(), null));
            resetView();
            return;
        }

        if (showLoading) {
            isLoading.postValue(true);
        }
        disposables.add(paymentRepository.getAllPayments()
                .subscribeOn(ioScheduler)
                .observeOn(uiScheduler)
                .subscribeWith(new DisposableObserver<List<PaymentModel>>() {
                    @Override
                    public void onNext(@NonNull List<PaymentModel> paymentModels) {
                        viewItems.postValue(getPaymentViewItems(paymentModels));
                        isRecordFound.postValue(true);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        resetView();
                        showAlertDialog.postValue(AlertMessagesHelper.getAlertMessageFromException(domain.getContext(), e, null));
                    }

                    @Override
                    public void onComplete() {
                        isLoading.postValue(false);
                        showRefreshIndicator.postValue(false);
                    }
                })
        );
    }

    private void resetView() {
        isLoading.postValue(false);
        isRecordFound.postValue(false);
        showRefreshIndicator.postValue(false);
    }

    private List<PaymentViewItem> getPaymentViewItems(List<PaymentModel> paymentModelList) {
        return paymentModelList.stream().map(paymentModel -> {
            return new PaymentViewItem(paymentModel.getPaymentName(), paymentModel.getLogoUrl());
        }).collect(Collectors.toList());
    }
}
