package com.wtmcodex.samplepaymentapp.features.home;

public class PaymentViewItem {
    private String title;
    private String logoUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public PaymentViewItem(String title, String logoUrl) {
        this.title = title;
        this.logoUrl = logoUrl;
    }
}
