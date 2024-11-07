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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.proseobd.fuljhuridirectory.adapters.PharmacyAdapter;
import com.proseobd.fuljhuridirectory.adapters.UpMemberAdapter;
import com.proseobd.fuljhuridirectory.controllers.DialogUtils;
import com.proseobd.fuljhuridirectory.controllers.NetworkUtils;
import com.proseobd.fuljhuridirectory.datamodels.PharmacyData;
import com.proseobd.fuljhuridirectory.datamodels.UpMemberData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class PharmacyFragment extends Fragment {

    RecyclerView recycleView;
    ProgressBar progressBar;
    SearchView searchView;
    SwipeRefreshLayout swipeRefreshLayout;

    TextView vdAdd;

    PharmacyAdapter pharmacyAdapter;

    List<PharmacyData> pharmacyDataList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_pharmacy, container, false);

        vdAdd = fragmentView.findViewById(R.id.vdAdd);

        recycleView = fragmentView.findViewById(R.id.recycleView);
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));


        searchView = fragmentView.findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setQueryHint("অনুসন্ধান করুন...");


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
                swipeRefreshLayout.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_dark),
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



    //////////////////   Pars Data Form Server   //////////////////


    private void loadData () {


        RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());
        progressBar.setVisibility(View.VISIBLE);

        String url = "https://proseobd.com/apps/fuljhuridirectory/farmecy/view.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressBar.setVisibility(View.GONE);
                Log.d("ServerRes", response.toString());


                for (int x=0; x<response.length(); x++){

                    try {

                        JSONObject jsonObject = response.getJSONObject(x);
                        PharmacyData pharmacyData = new PharmacyData();
                        pharmacyData.setName(jsonObject.getString("name"));
                        pharmacyData.setOwner(jsonObject.getString("owner"));
                        pharmacyData.setAddress(jsonObject.getString("address"));
                        pharmacyData.setMobile(jsonObject.getString("mobile"));
                        pharmacyData.setEmail(jsonObject.getString("email"));
                        pharmacyData.setProfileImage(jsonObject.getString("profileImage"));
                        pharmacyDataList.add(pharmacyData);

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                pharmacyAdapter = new PharmacyAdapter(getActivity(), pharmacyDataList);
                recycleView.setAdapter(pharmacyAdapter);

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





}