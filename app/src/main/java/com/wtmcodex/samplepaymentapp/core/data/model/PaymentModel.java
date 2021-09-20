package com.wtmcodex.samplepaymentapp.core.data.model;

public class PaymentModel {
    private int id;
    private final String paymentName;
    private final String paymentCode;
    private final String paymentMethod;
    private final String logoUrl;

    public int getId() {
        return id;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public PaymentModel(String paymentName, String paymentCode, String paymentMethod, String logoUrl) {
        this.paymentName = paymentName;
        this.paymentCode = paymentCode;
        this.paymentMethod = paymentMethod;
        this.logoUrl = logoUrl;
    }
}
