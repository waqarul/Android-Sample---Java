package com.wtmcodex.samplepaymentapp.core.data.source.local.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.wtmcodex.samplepaymentapp.constants.DatabaseConstants;
import com.wtmcodex.samplepaymentapp.core.data.source.local.entity.DBPayment;


import org.jetbrains.annotations.NotNull;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;


@Dao
public interface PaymentDao extends BaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertAll(@NotNull DBPayment... items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertPayment(DBPayment payment);

    @Query(DatabaseConstants.QUERY_SELECT_PAYMENTS)
    Observable<DBPayment> getAllPayments();

    @Query(DatabaseConstants.QUERY_SELECT_PAYMENT_BY_ID)
    Single<DBPayment> getPaymentByID(int id);

    @Query(DatabaseConstants.QUERY_DELETE_PAYMETS)
    Completable deleteAllPayments();
}
