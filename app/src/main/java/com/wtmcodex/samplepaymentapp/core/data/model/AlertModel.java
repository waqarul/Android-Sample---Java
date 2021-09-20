package com.wtmcodex.samplepaymentapp.core.data.model;

import androidx.annotation.Nullable;

import com.wtmcodex.samplepaymentapp.core.data.enums.ErrorType;

public class AlertModel {
    private final String title;
    private final String message;
    private final String positiveButtonTitle;
    private final String negativeButtonTitle;
    private final OnAlertClickListener listener;
    private final ErrorType errorType;

    public final String getTitle() {
        return this.title;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getPositiveButtonTitle() {
        return this.positiveButtonTitle;
    }

    public final String getNegativeButtonTitle() {
        return this.negativeButtonTitle;
    }

    public OnAlertClickListener getListener() {
        return listener;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public AlertModel(@Nullable String title, @Nullable String message, @Nullable String positiveButtonTitle, @Nullable String negativeButtonTitle, @Nullable OnAlertClickListener listener, @Nullable ErrorType errorType) {
        this.title = title;
        this.message = message;
        this.positiveButtonTitle = positiveButtonTitle;
        this.negativeButtonTitle = negativeButtonTitle;
        this.listener = listener;
        this.errorType = errorType;
    }

    public interface OnAlertClickListener {
        abstract void onPositiveButtonClickAction(ErrorType errorType);

        abstract void onNegativeButtonClickAction(ErrorType errorType);
    }
}
