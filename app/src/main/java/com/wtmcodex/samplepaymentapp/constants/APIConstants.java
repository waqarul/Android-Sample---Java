package com.wtmcodex.samplepaymentapp.constants;

import com.wtmcodex.samplepaymentapp.BuildConfig;
import com.wtmcodex.samplepaymentapp.R;
import com.wtmcodex.samplepaymentapp.core.Domain;

import javax.inject.Inject;

public interface APIConstants {

    public static final String BASE_API_URL = Domain.getInstance().getContext().getString(R.string.base_url);
    public static final String PATH = Domain.getInstance().getContext().getString(R.string.path);
    public static final String BASE_URL = String.format("%s/%s/", BASE_API_URL, PATH);
    public static final String GET_PAYMENTS = "listresult.json";

    public static final long READ_TIME_OUT_DELAY = 2L;
    public static final long CONNECT_TIME_OUT_DELAY = 2L;

}
