package com.proseobd.fuljhuridirectory.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.proseobd.fuljhuridirectory.R;
import com.proseobd.fuljhuridirectory.controllers.DialogUtils;
import com.proseobd.fuljhuridirectory.controllers.NetworkUtils;

public abstract class BaseListFragment extends Fragment {
    protected RecyclerView recyclerView;
    protected ProgressBar progressBar;
    protected SearchView searchView;
    protected SwipeRefreshLayout swipeRefreshLayout;
    protected TextView vdAdd;

    @LayoutRes
    protected abstract int getLayoutId();
    protected abstract void initAdapter();
    protected abstract void loadData();
    protected abstract void handleSearch(String query);

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(getLayoutId(), container, false);
        initViews(fragmentView);
        setupRecyclerView();
        setupSearchView();
        setupSwipeRefresh();
        
        if (NetworkUtils.isInternetAvailable(requireActivity())) {
            loadData();
        } else {
            DialogUtils.showAlertDialog(getActivity(), "সতর্ক বার্তা", "আপনার মোবাইলে ইন্টারনেট নেই!");
            swipeRefreshLayout.setRefreshing(false);
        }

        return fragmentView;
    }

    private void initViews(View view) {
        vdAdd = view.findViewById(R.id.vdAdd);
        recyclerView = view.findViewById(R.id.recycleView);
        searchView = view.findViewById(R.id.searchView);
        progressBar = view.findViewById(R.id.progressBar);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
    }

    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initAdapter();
    }

    private void setupSearchView() {
        searchView.clearFocus();
        searchView.setQueryHint("অনুসন্ধান করুন...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                handleSearch(newText);
                return false;
            }
        });
    }

    private void setupSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            if (NetworkUtils.isInternetAvailable(requireActivity())) {
                loadData();
                swipeRefreshLayout.setColorSchemeColors(
                        getResources().getColor(android.R.color.holo_blue_dark),
                        getResources().getColor(android.R.color.holo_orange_dark),
                        getResources().getColor(android.R.color.holo_green_dark),
                        getResources().getColor(android.R.color.holo_red_dark));
            } else {
                DialogUtils.showAlertDialog(getActivity(), "সতর্ক বার্তা", "আপনার মোবাইলে ইন্টারনেট নেই!");
            }
            swipeRefreshLayout.setRefreshing(false);
        });
    }
} 