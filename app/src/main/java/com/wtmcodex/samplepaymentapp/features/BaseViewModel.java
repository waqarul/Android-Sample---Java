package com.wtmcodex.samplepaymentapp.features;

import android.os.Bundle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.wtmcodex.samplepaymentapp.core.data.model.AlertModel;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {
    protected MutableLiveData<AlertModel> showAlertDialog = new MutableLiveData<AlertModel>();

    public MutableLiveData<AlertModel> getShowAlertDialog() {
        return showAlertDialog;
    }

    protected CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onCleared() {
        disposables.clear();
        super.onCleared();
    }

    protected abstract void loadData(Bundle params);
}
