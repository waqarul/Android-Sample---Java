package com.wtmcodex.samplepaymentapp.core.data.source.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.wtmcodex.samplepaymentapp.constants.DatabaseConstants;

@Entity(tableName = DatabaseConstants.TABLE_PAYMENT)
public class DBPayment {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "payment_name")
    private final String paymentName;
    @ColumnInfo(name = "logo_url")
    private final String logoUrl;
    @ColumnInfo(name = "payment_code")
    private final String paymentCode;
    @ColumnInfo(name = "payment_method")
    private final String paymentMethod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public DBPayment(String paymentName, String logoUrl, String paymentCode, String paymentMethod) {
        this.paymentName = paymentName;
        this.logoUrl = logoUrl;
        this.paymentCode = paymentCode;
        this.paymentMethod = paymentMethod;
    }
}
