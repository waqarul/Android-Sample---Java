package com.wtmcodex.samplepaymentapp.core.di.module;

import android.content.Context;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wtmcodex.samplepaymentapp.BuildConfig;
import com.wtmcodex.samplepaymentapp.constants.APIConstants;
import com.wtmcodex.samplepaymentapp.core.data.source.remote.retrofit.PaymentApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder().setLenient().create();
    }


    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .readTimeout(APIConstants.READ_TIME_OUT_DELAY, TimeUnit.SECONDS)
                .connectTimeout(APIConstants.CONNECT_TIME_OUT_DELAY, TimeUnit.SECONDS)
                .addInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)).build();
    }

    @Singleton
    @Provides
    HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.NONE;
        if (BuildConfig.DEBUG) {
            level = HttpLoggingInterceptor.Level.BODY;
        }

        return new HttpLoggingInterceptor().setLevel(level);
    }

    @Singleton
    @Provides
    Retrofit provideRetrofitBuilder(OkHttpClient client,
                                    Context context) {
        return new Retrofit.Builder()
                .baseUrl(APIConstants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

    }

    @Provides
    @Singleton
    PaymentApiService provideInstantPaymentApiService(Retrofit retrofit) {
        return retrofit.create(PaymentApiService.class);
    }
}
