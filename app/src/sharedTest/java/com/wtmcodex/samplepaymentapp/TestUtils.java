package com.wtmcodex.samplepaymentapp;

import android.net.Uri;

import com.wtmcodex.samplepaymentapp.core.data.model.ApplicableNetwork;
import com.wtmcodex.samplepaymentapp.core.data.model.ListResult;
import com.wtmcodex.samplepaymentapp.core.data.model.Networks;
import com.wtmcodex.samplepaymentapp.core.data.model.PaymentModel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

import retrofit2.http.Url;

public class TestUtils {
    public static ListResult getFakedListResult() {
        try {
            HashMap<String, URL> hashMap = new HashMap<>();
            hashMap.put("logo", new URL("https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/amex.png"));
            ApplicableNetwork applicableNetwork = new ApplicableNetwork("AMEX", "American Express", "CREDIT_CARD", hashMap);
            Networks networks = new Networks(Lists.newArrayList(applicableNetwork));
            return new ListResult(networks);
        } catch (MalformedURLException ex) {
            return null;
        }
    }

    public static List<PaymentModel> getFakedPaymentModel() {
        return Lists.newArrayList(new PaymentModel("American Express", "AMEX", "CREDIT_CARD", "https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/amex.png"));
    }
}
