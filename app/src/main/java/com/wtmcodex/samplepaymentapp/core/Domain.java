package com.wtmcodex.samplepaymentapp.core;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

public final class Domain {
    private static Context context;
    private static Domain INSTANCE = null;

    private Domain(Context context) {
        this.context = context;
    }

    public static Domain getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Domain(context);
        }
        return INSTANCE;
    }

    public static Domain getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        } else
            throw new NullPointerException("Did you forget calling getInstance with application context at the start of the app?");
    }

    public Context getContext() {
        return context;
    }
}
