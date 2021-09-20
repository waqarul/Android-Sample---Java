package com.wtmcodex.samplepaymentapp.features;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.wtmcodex.samplepaymentapp.core.data.model.AlertModel;
import com.wtmcodex.samplepaymentapp.core.di.Injectable;

import javax.inject.Inject;

public abstract class BaseFragment extends Fragment implements Injectable {

    @Inject
    public ViewModelProvider.Factory viewModelFactoryProvider;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getBindingView(inflater);

        getOrCreateViewModel();

        setupUI();

        setListeners();

        setupBindings();

        loadData();

        return view;
    }

    protected void showAlert(AlertModel alertModel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext())
                .setTitle(alertModel.getTitle())
                .setMessage(alertModel.getMessage())
                .setCancelable(false)
                .setPositiveButton(alertModel.getPositiveButtonTitle(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (alertModel.getListener() != null) {
                            alertModel.getListener().onPositiveButtonClickAction(alertModel.getErrorType());
                        }
                    }
                })
                .setNegativeButton(alertModel.getNegativeButtonTitle(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (alertModel.getListener() != null) {
                            alertModel.getListener().onNegativeButtonClickAction(alertModel.getErrorType());
                        }
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();

        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setAllCaps(false);
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setAllCaps(false);

    }

    // this method is used to get binding view
    protected abstract View getBindingView(LayoutInflater inflater);

    // this method is used to initialize View Model
    protected abstract void getOrCreateViewModel();

    // this method is used to setup UI views
    protected void setupUI() {
    }

    // this method will be invoked from @onViewCreated to setup bindings
    protected void setListeners() {
    }

    // this method will be invoked from @onViewCreated to setup bindings
    protected void setupBindings() {
    }

    // this method will be invoked from @onViewCreated to load data remotely/locally
    protected void loadData() {
    }

}
