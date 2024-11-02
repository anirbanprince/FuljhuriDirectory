package com.proseobd.fuljhuridirectory;

import static java.util.Locale.filter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.proseobd.fuljhuridirectory.adapters.UpMemberAdapter;
import com.proseobd.fuljhuridirectory.controllers.DialogUtils;
import com.proseobd.fuljhuridirectory.controllers.NetworkUtils;
import com.proseobd.fuljhuridirectory.datamodels.UpMemberData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UpListFragment extends Fragment {

    RecyclerView recycleView;
    ProgressBar progressBar;
    SearchView searchView;
    SwipeRefreshLayout swipeRefreshLayout;

    List<UpMemberData> upMemberDataList;
    private static String url = "https://proseobd.com/apps/fuljhuridirectory/upmembers/view.php";
    UpMemberAdapter upMemberAdapter;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_up_list, container, false);

        TextView vdAdd = (TextView) fragmentView.findViewById(R.id.vdAdd);

        recycleView = (RecyclerView) fragmentView.findViewById(R.id.recycleView);
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

        upMemberDataList = new ArrayList<>();

        searchView = (SearchView) fragmentView.findViewById(R.id.searchView);
        searchView.clearFocus();

        progressBar = (ProgressBar) fragmentView.findViewById(R.id.progressBar);
        swipeRefreshLayout = (SwipeRefreshLayout) fragmentView.findViewById(R.id.swipeRefreshLayout);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filterList(newText);

                return true;
            }
        });






        if (NetworkUtils.isInternetAvailable(getActivity())) {
            loadData();
        } else {
            DialogUtils.showAlertDialog(getActivity(), "সতর্ক বার্তা", "আপনার মোবাইলে ইন্টারনেট নেই!");
            swipeRefreshLayout.setRefreshing(false);
        }





        if (NetworkUtils.isInternetAvailable(getActivity())) {
            loadData();
        } else {
            DialogUtils.showAlertDialog(getActivity(), "সতর্ক বার্তা", "আপনার মোবাইলে ইন্টারনেট নেই!");
            swipeRefreshLayout.setRefreshing(false);
        }



        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                if (NetworkUtils.isInternetAvailable(getActivity())) {
                    loadData();
                    swipeRefreshLayout.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_dark),
                            getResources().getColor(android.R.color.holo_orange_dark),
                            getResources().getColor(android.R.color.holo_green_dark),
                            getResources().getColor(android.R.color.holo_red_dark));

                    swipeRefreshLayout.setRefreshing(false);
                } else {
                    DialogUtils.showAlertDialog(getActivity(), "সতর্ক বার্তা", "আপনার মোবাইলে ইন্টারনেট নেই!");
                    swipeRefreshLayout.setRefreshing(false);
                }

            }
        });







        return fragmentView;


    }      //-------------------onCreate END--------------------//




    //===================== Data Parsing Privet Methode ====================//
    //===================== Data Parsing Privet Methode ====================//
    //===================== Data Parsing Privet Methode ====================//


    public void loadData () {

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        progressBar.setVisibility(View.VISIBLE);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        progressBar.setVisibility(View.GONE);

                        Log.d("ServerRes", response.toString());

                        for (int x=0; x<response.length(); x++){

                            try {

                                JSONObject jsonObject = response.getJSONObject(x);
                                UpMemberData upMemberData = new UpMemberData();
                                upMemberData.setName(jsonObject.getString("name"));
                                upMemberData.setDesignation(jsonObject.getString("designation"));
                                upMemberData.setMobile(jsonObject.getString("mobile"));
                                upMemberData.setWordNo(jsonObject.getString("wordno"));
                                upMemberData.setProfileImage(jsonObject.getString("profileImage"));
                                upMemberData.setEmail(jsonObject.getString("email"));
                                upMemberDataList.add(upMemberData);


                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }

                        }

                        upMemberAdapter = new UpMemberAdapter(getActivity(), upMemberDataList);
                        recycleView.setAdapter(upMemberAdapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                DialogUtils.showAlertDialog(getActivity(), "সতর্ক বার্তা", "সার্ভার এরর!");

            }
        });


        requestQueue.add(jsonArrayRequest);

    }


    //===================== Data Parsing END ====================//
    //===================== Data Parsing END ====================//
    //===================== Data Parsing PEND ====================//

    /////////////////////////////////////////////////////////////////////////



    // Search View Filter Method /////////////////////////
    // Search View Filter Method  /////////////////////////
    // Search View Filter Method  /////////////////////////

    private void filterList(String text) {

        List<UpMemberData> filteredList = new ArrayList<>();
        for (UpMemberData item : upMemberDataList) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        if (filteredList.isEmpty()) {
            upMemberAdapter.setFilteredList(upMemberDataList);
        } else {
            upMemberAdapter.setFilteredList(filteredList);
        }

    }

    // Search View Filter Method  END /////////////////////////
    // Search View Filter Method  END /////////////////////////
    // Search View Filter Method  END /////////////////////////



    

}