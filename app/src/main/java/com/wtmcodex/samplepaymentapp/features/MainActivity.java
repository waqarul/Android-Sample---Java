package com.wtmcodex.samplepaymentapp.features;

import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.wtmcodex.samplepaymentapp.R;
import com.wtmcodex.samplepaymentapp.databinding.ActivityMainBinding;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setupNavigation();
    }

    private void setupNavigation() {
        NavController navController = Navigation.findNavController(this, R.id.mainNavFragment);
        NavigationUI.setupActionBarWithNavController(this, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.mainNavFragment).navigateUp();
    }
}