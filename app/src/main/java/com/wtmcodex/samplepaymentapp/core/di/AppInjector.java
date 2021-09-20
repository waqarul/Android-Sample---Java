package com.wtmcodex.samplepaymentapp.core.di;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.wtmcodex.samplepaymentapp.PaymentAppApplication;
import com.wtmcodex.samplepaymentapp.core.di.component.DaggerAppCompnent;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import dagger.android.AndroidInjection;
import dagger.android.HasAndroidInjector;
import dagger.android.support.AndroidSupportInjection;

public final class AppInjector {
    private static AppInjector INSTANCE = null;

    private AppInjector() {
    }

    public static AppInjector getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppInjector();
        }
        return INSTANCE;
    }

    public final void init(@NotNull PaymentAppApplication application) {
        DaggerAppCompnent.builder().application(application).build().inject(application);
        application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) (new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
                handleActivity(activity);
            }

            public void onActivityStarted(@NotNull Activity activity) {
            }

            public void onActivityResumed(@NotNull Activity activity) {
            }

            public void onActivityPaused(@NotNull Activity activity) {
            }

            public void onActivityStopped(@NotNull Activity activity) {
            }

            public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
            }

            public void onActivityDestroyed(@NotNull Activity activity) {
            }
        }));
    }

    private final void handleActivity(Activity activity) {
        if (activity instanceof HasAndroidInjector) {
            AndroidInjection.inject(activity);
        }

        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks((FragmentManager.FragmentLifecycleCallbacks) (new FragmentManager.FragmentLifecycleCallbacks() {
                public void onFragmentCreated(@NotNull FragmentManager fm, @NotNull Fragment f, @Nullable Bundle savedInstanceState) {
                    if (f instanceof Injectable) {
                        AndroidSupportInjection.inject(f);
                    }

                }
            }), true);
        }

    }

}
