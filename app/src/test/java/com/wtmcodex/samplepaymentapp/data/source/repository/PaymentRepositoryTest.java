package com.wtmcodex.samplepaymentapp.data.source.repository;

import com.wtmcodex.samplepaymentapp.RxImmediateSchedulerRule;
import com.wtmcodex.samplepaymentapp.TestUtils;
import com.wtmcodex.samplepaymentapp.core.data.model.ListResult;
import com.wtmcodex.samplepaymentapp.core.data.model.PaymentModel;
import com.wtmcodex.samplepaymentapp.core.data.source.local.PaymentLocalDataSource;
import com.wtmcodex.samplepaymentapp.core.data.source.remote.PaymentRemoteDataSource;
import com.wtmcodex.samplepaymentapp.core.data.source.repository.PaymentRepositoryImpl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;

import static org.junit.Assert.*;

import java.util.List;

public class PaymentRepositoryTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Rule
    public RxImmediateSchedulerRule testSchedulerRule = new RxImmediateSchedulerRule();

    @Mock
    PaymentRemoteDataSource remoteDataSource;

    @Mock
    PaymentLocalDataSource localDataSource;

    PaymentRepositoryImpl systemUnderTest;

    @Before
    public void setUp() {
        systemUnderTest = new PaymentRepositoryImpl(localDataSource, remoteDataSource);
    }

    @Test
    public void testRemoteResponseWithSuccess() {
        List<PaymentModel> responseFakedPaymentModelList = TestUtils.getFakedPaymentModel();
        ListResult responseFakedResultList = TestUtils.getFakedListResult();
        Mockito.when(remoteDataSource.getPayments()).thenReturn(Observable.just(responseFakedResultList));

        Observable<List<PaymentModel>> result = systemUnderTest.getAllPayments();
        TestObserver<List<PaymentModel>> testObserver = new TestObserver<List<PaymentModel>>();
        result.subscribe(testObserver);
        testObserver.assertComplete();
        testObserver.assertNoErrors();
        testObserver.assertValueCount(1);
        assertNotNull(testObserver.values());
        assertEquals(testObserver.values().size(), 1);
        List<PaymentModel> listResult = testObserver.values().get(0);
        assertEquals(listResult.size(), 1);
        assertEquals(responseFakedPaymentModelList.size(), 1);
        assertEquals(listResult.size(), responseFakedPaymentModelList.size());
        PaymentModel responseFakedPaymentModel = responseFakedPaymentModelList.get(0);
        PaymentModel paymentModel = listResult.get(0);
        assertNotNull(paymentModel);
        assertEquals(paymentModel.getPaymentName(), responseFakedPaymentModel.getPaymentName());
        assertEquals(paymentModel.getPaymentCode(), responseFakedPaymentModel.getPaymentCode());
        assertEquals(paymentModel.getPaymentMethod(), responseFakedPaymentModel.getPaymentMethod());
        assertNotNull(paymentModel.getLogoUrl());
        assertEquals(paymentModel.getLogoUrl(), responseFakedPaymentModel.getLogoUrl());
    }
}
