package com.wtmcodex.samplepaymentapp.core.data.source.local;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.wtmcodex.samplepaymentapp.core.data.source.local.dao.PaymentDao;
import com.wtmcodex.samplepaymentapp.core.data.source.local.entity.DBPayment;

@Database(entities = {DBPayment.class}, version = 1, exportSchema = false)
public abstract class PaymentDatabase extends RoomDatabase {
    public abstract PaymentDao paymentDao();
}
