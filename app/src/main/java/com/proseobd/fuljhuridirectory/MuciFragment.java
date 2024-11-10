package com.proseobd.fuljhuridirectory;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.proseobd.fuljhuridirectory.adapters.MuciAdapter;
import com.proseobd.fuljhuridirectory.controllers.DialogUtils;
import com.proseobd.fuljhuridirectory.controllers.NetworkUtils;
import com.proseobd.fuljhuridirectory.datamodels.MuciData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MuciFragment extends Fragment {

    RecyclerView recycleView;
    ProgressBar progressBar;
    SearchView searchView;
    SwipeRefreshLayout swipeRefreshLayout;
    TextView vdAdd;

    MuciAdapter muciAdapter;

    List<MuciData> muciDataList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_muci, container, false);

        vdAdd = fragmentView.findViewById(R.id.vdAdd);

        recycleView = fragmentView.findViewById(R.id.recycleView);
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));


        searchView = fragmentView.findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setQueryHint("অনুসন্ধান করুন...");


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                muciAdapter.getFilter().filter(newText);

                return false;
            }
        });


        progressBar = fragmentView.findViewById(R.id.progressBar);
        swipeRefreshLayout = fragmentView.findViewById(R.id.swipeRefreshLayout);




        if (NetworkUtils.isInternetAvailable(requireActivity())) {
            loadData();
        } else {
            DialogUtils.showAlertDialog(getActivity(), "সতর্ক বার্তা", "আপনার মোবাইলে ইন্টারনেট নেই!");
            swipeRefreshLayout.setRefreshing(false);
        }





        if (NetworkUtils.isInternetAvailable(requireActivity())) {
            loadData();
        } else {
            DialogUtils.showAlertDialog(getActivity(), "সতর্ক বার্তা", "আপনার মোবাইলে ইন্টারনেট নেই!");
            swipeRefreshLayout.setRefreshing(false);
        }



        swipeRefreshLayout.setOnRefreshListener(() -> {

            if (NetworkUtils.isInternetAvailable(requireActivity())) {
                loadData();
                swipeRefreshLayout.setColorSchemeColors(
                        getResources().getColor(android.R.color.holo_blue_dark),
                        getResources().getColor(android.R.color.holo_orange_dark),
                        getResources().getColor(android.R.color.holo_green_dark),
                        getResources().getColor(android.R.color.holo_red_dark));

                swipeRefreshLayout.setRefreshing(false);
            } else {
                DialogUtils.showAlertDialog(getActivity(), "সতর্ক বার্তা", "আপনার মোবাইলে ইন্টারনেট নেই!");
                swipeRefreshLayout.setRefreshing(false);
            }

        });



        return fragmentView;
    }

    private void loadData(){


        RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());
        progressBar.setVisibility(View.VISIBLE);

        String url = "https://proseobd.com/apps/fuljhuridirectory/Muci/view.php";

        JsonArrayRequest jsonArrayRequest;
        jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null,
                response -> {
                    progressBar.setVisibility(View.GONE);
                    muciDataList.clear();
                    Log.d("ServerRes", response.toString());


                    for (int x=0; x<response.length(); x++){

                        try {

                            JSONObject jsonObject = response.getJSONObject(x);
                            MuciData muciData = new MuciData();
                            muciData.setName(jsonObject.getString("name"));
                            muciData.setOwner(jsonObject.getString("owner"));
                            muciData.setAddress(jsonObject.getString("address"));
                            muciData.setMobile(jsonObject.getString("mobile"));
                            muciData.setEmail(jsonObject.getString("email"));
                            muciData.setProfileImage(jsonObject.getString("profileImage"));
                            muciDataList.add(muciData);

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    muciAdapter = new MuciAdapter(requireActivity().getLayoutInflater(),muciDataList);
                    recycleView.setAdapter(muciAdapter);

                }, error -> DialogUtils.showAlertDialog(getActivity(), "সতর্ক বার্তা", "সার্ভার এরর!"));

        requestQueue.add(jsonArrayRequest);



    }


}