package com.proseobd.fuljhuridirectory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

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


        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framLay, new PoliceStationFragment()).commit();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Fragment tabFragment = null;

                int tabPosition = tab.getPosition();

                if (tabPosition==0)  tabFragment = new PoliceStationFragment();

                else if (tabPosition==1)  tabFragment = new FireServiceFragment();

                else if (tabPosition==2)  tabFragment = new HospitalFragment();

                else if (tabPosition==3)  tabFragment = new AmbulanceFragment();

                else if (tabPosition==4)  tabFragment = new OthersFragment();

                assert tabFragment != null;
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framLay, tabFragment).commit();



            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });















        return fragmentView;
    }
}