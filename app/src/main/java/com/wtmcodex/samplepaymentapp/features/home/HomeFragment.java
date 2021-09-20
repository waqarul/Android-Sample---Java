package com.wtmcodex.samplepaymentapp.features.home;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.wtmcodex.samplepaymentapp.databinding.FragmentHomeBinding;
import com.wtmcodex.samplepaymentapp.features.BaseFragment;

public class HomeFragment extends BaseFragment {
    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;

    @Override
    protected View getBindingView(LayoutInflater inflater) {
        binding = FragmentHomeBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    protected void getOrCreateViewModel() {
        viewModel = new ViewModelProvider(this, viewModelFactoryProvider).get(HomeViewModel.class);
    }

    @Override
    protected void setupUI() {
        setupRecyclerView();
        setupSwipeRefreshLayout();
    }

    @Override
    protected void setupBindings() {

        viewModel.getIsLoading().observe(getViewLifecycleOwner(), isLoading -> {
            if (isLoading) {
                binding.pbLoading.setVisibility(View.VISIBLE);
            } else {
                binding.pbLoading.setVisibility(View.GONE);
            }
        });

        viewModel.getShowRefreshIndicator().observe(getViewLifecycleOwner(), showRefreshIndicator -> {
            binding.srLayout.setRefreshing(showRefreshIndicator);
        });

        viewModel.getIsRecordFound().observe(getViewLifecycleOwner(), isRecordFound -> {
            if (isRecordFound) {
                binding.tvNoResult.setVisibility(View.GONE);
                binding.rvPayment.setVisibility(View.VISIBLE);
            } else {
                binding.tvNoResult.setVisibility(View.VISIBLE);
                binding.rvPayment.setVisibility(View.GONE);
            }
        });

        viewModel.getViewItems().observe(getViewLifecycleOwner(), viewItems -> {
            PaymentRecyclerViewAdapter adapter = (PaymentRecyclerViewAdapter) binding.rvPayment.getAdapter();
            adapter.setViewItems(viewItems);
        });

        viewModel.getShowAlertDialog().observe(getViewLifecycleOwner(), alertModel -> {
            showAlert(alertModel);
        });
    }

    @Override
    protected void setListeners() {
        binding.srLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.srLayout.setRefreshing(true);
                doOnRefresh();
            }
        });
    }

    @Override
    protected void loadData() {
        ((HomeViewModel) viewModel).loadData(getArguments());
    }

    private void setupRecyclerView() {
        PaymentRecyclerViewAdapter adapter = new PaymentRecyclerViewAdapter(new PaymentRecyclerViewAdapter.OnItemClickedListener() {
            @Override
            public void onItemClicked(PaymentViewItem item) {
                // TODO: Not implemented
            }
        });
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        binding.rvPayment.setLayoutManager(lManager);
        binding.rvPayment.setAdapter(adapter);
    }

    private void setupSwipeRefreshLayout() {
        binding.srLayout.setColorSchemeColors(
                ContextCompat.getColor(binding.srLayout.getContext(), android.R.color.holo_blue_bright),
                ContextCompat.getColor(binding.srLayout.getContext(), android.R.color.holo_green_light),
                ContextCompat.getColor(binding.srLayout.getContext(), android.R.color.holo_orange_light),
                ContextCompat.getColor(binding.srLayout.getContext(), android.R.color.holo_red_light));
    }

    private void doOnRefresh() {
        doApiCall();
    }

    private void doApiCall() {
        viewModel.makeRequestToFetchPaymentMethods(false);
    }
}