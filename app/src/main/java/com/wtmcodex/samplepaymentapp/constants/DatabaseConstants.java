package com.wtmcodex.samplepaymentapp.constants;


public interface DatabaseConstants {

    public static final String DATABASE_NAME = "PaymentType.db";
    public static final String TABLE_PAYMENT = "Payments";
    public static final String QUERY_SELECT_PAYMENTS = "SELECT * FROM " + TABLE_PAYMENT;
    public static final String QUERY_SELECT_PAYMENT_BY_ID = "SELECT * FROM " + TABLE_PAYMENT + " WHERE id=:id ";
    public static final String QUERY_DELETE_PAYMETS = "DELETE FROM " + TABLE_PAYMENT;

}
