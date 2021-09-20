package com.wtmcodex.samplepaymentapp.core.di.module;

import android.content.Context;

import androidx.room.Room;

import com.wtmcodex.samplepaymentapp.constants.DatabaseConstants;
import com.wtmcodex.samplepaymentapp.core.data.source.local.PaymentDatabase;
import com.wtmcodex.samplepaymentapp.core.data.source.local.dao.PaymentDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    @Singleton
    @Provides
    PaymentDatabase provideDatabase(Context context) {
        return Room.databaseBuilder(context, PaymentDatabase.class, DatabaseConstants.DATABASE_NAME).build();
    }

    @Singleton
    @Provides
    PaymentDao providePaymentDao(PaymentDatabase paymentDatabase) {
        return paymentDatabase.paymentDao();
    }
}
