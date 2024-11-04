package com.proseobd.fuljhuridirectory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;


public class EmergencyFragment extends Fragment {

    FrameLayout framLay;
    TabLayout tabLayout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_emergency, container, false);

        framLay = fragmentView.findViewById(R.id.framLay);
        tabLayout = fragmentView.findViewById(R.id.tabLayout);


        return fragmentView;
    }
}