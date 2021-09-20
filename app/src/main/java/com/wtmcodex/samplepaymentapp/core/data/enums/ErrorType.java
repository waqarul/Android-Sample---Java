package com.wtmcodex.samplepaymentapp.core.data.enums;

import android.content.Context;

import com.wtmcodex.samplepaymentapp.R;

//HTTP ERRORS
public enum ErrorType {
    UNKNOWN_ERROR(0),
    NO_INTERNET_CONNECTION(100),
    RESOURCE_NOT_FOUND(404),
    UNAUTHORIZED(401),
    CANNOT_REACH_SERVER(900),
    INTERNAL_SERVER_ERROR(500),
    BAD_REQUEST(400);

    private int code;

    ErrorType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static ErrorType fromString(int code) {
        for (ErrorType type : ErrorType.values()) {
            if (type.code == code) {
                return type;
            }
        }
        return ErrorType.UNKNOWN_ERROR;
    }

    public static String getMessageForType(ErrorType type, Context context) {
        String message = context.getString(R.string.message_error_in_request);
        if (type == ErrorType.NO_INTERNET_CONNECTION) {
            message = context.getString(R.string.message_no_internet_connection);
        } else if (type == ErrorType.RESOURCE_NOT_FOUND) {
            message = context.getString(R.string.error_page_not_found);
        } else if (type == ErrorType.UNAUTHORIZED) {
            message = context.getString(R.string.error_unauthorized);
        } else if (type == ErrorType.INTERNAL_SERVER_ERROR) {
            message = context.getString(R.string.error_internal_server_error);
        } else if (type == ErrorType.BAD_REQUEST) {
            message = context.getString(R.string.message_error_in_request);
        }

        return message;
    }
}
