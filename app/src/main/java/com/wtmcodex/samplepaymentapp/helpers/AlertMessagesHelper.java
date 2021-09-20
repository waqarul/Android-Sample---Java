package com.wtmcodex.samplepaymentapp.helpers;

import android.content.Context;

import com.wtmcodex.samplepaymentapp.R;
import com.wtmcodex.samplepaymentapp.core.data.enums.ErrorType;
import com.wtmcodex.samplepaymentapp.core.data.model.AlertModel;

import java.io.IOException;

import retrofit2.HttpException;

public class AlertMessagesHelper {

    public static AlertModel getNoInternetConnectionAlertModel(Context context, AlertModel.OnAlertClickListener listener) {
        return new AlertModel(context.getString(R.string.title_no_internet_connection),
                context.getString(R.string.message_no_internet_connection),
                context.getString(R.string.alert_ok_label),
                null,
                listener,
                ErrorType.NO_INTERNET_CONNECTION);
    }

    public static AlertModel getAlertMessageFromException(Context context, Throwable exception, AlertModel.OnAlertClickListener listener) {
        ErrorType errorType = ErrorType.UNKNOWN_ERROR;
        String errorMessage = context.getString(R.string.message_error_in_request);
        if (exception instanceof HttpException) {
            errorType = ErrorType.fromString(((HttpException) exception).code());
            errorMessage = ErrorType.getMessageForType(errorType, context);
        } else if (exception instanceof IOException) {
            errorType = ErrorType.UNKNOWN_ERROR;
            errorMessage = "" + exception.getLocalizedMessage();
        } else if (exception instanceof IOException) {
            errorType = ErrorType.UNKNOWN_ERROR;
            errorMessage = context.getString(R.string.message_error_in_request);
        }

        return new AlertModel(context.getString(R.string.title_error_in_request),
                errorMessage,
                context.getString(R.string.alert_ok_label),
                null,
                listener,
                errorType);
    }
}
