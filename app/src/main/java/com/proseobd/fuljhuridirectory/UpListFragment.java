package com.proseobd.fuljhuridirectory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.proseobd.controllers.DialogUtils;
import com.proseobd.controllers.NetworkUtils;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UpListFragment extends Fragment {

    RecyclerView recycleView;
    ProgressBar progressBar;
    SearchView search;
    SwipeRefreshLayout swipeRefreshLayout;

    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> upMemberList = new ArrayList<>();





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_up_list, container, false);

        TextView vdAdd = fragmentView.findViewById(R.id.vdAdd);

        recycleView = (RecyclerView) fragmentView.findViewById(R.id.recycleView);
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        progressBar = fragmentView.findViewById(R.id.progressBar);
        swipeRefreshLayout = fragmentView.findViewById(R.id.swipeRefreshLayout);




        



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
    }

    //-------------------onCreate END--------------------//





    //===================== Data Parsing Privet Methode ====================//
    //===================== Data Parsing Privet Methode ====================//
    //===================== Data Parsing Privet Methode ====================//


    public void loadData () {

        upMemberList = new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        String url ="https://proseobd.com/apps/fuljhuridirectory/upmembers/view.php";

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

                                String name =  jsonObject.optString("name");
                                String designation = jsonObject.optString("designation");
                                String phone_number = jsonObject.optString("phone_number");
                                String image_link = jsonObject.optString("image_link");
                                String word_no = jsonObject.optString("word_no");
                                String email = jsonObject.optString("email");

                                hashMap = new HashMap<>();
                                hashMap.put("name", name);
                                hashMap.put("designation", designation);
                                hashMap.put("phone_number", phone_number);
                                hashMap.put("image_link", image_link);
                                hashMap.put("word_no", word_no);
                                hashMap.put("email", email);
                                upMemberList.add(hashMap);





                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }


                        }

                        RecycleAdapter recycleAdapter = new RecycleAdapter();
                        recycleView.setAdapter(recycleAdapter);




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

    // =============== Recycler Adapter Start ==========//
    // =============== Recycler Adapter Start ==========//
    // =============== Recycler Adapter Start ==========//

    private class RecycleAdapter extends RecyclerView.Adapter < RecycleAdapter.recycleViewHolder > {


        private class recycleViewHolder extends RecyclerView.ViewHolder{


            ImageView profileImage, imgCall;
            TextView name, designation, wordNo, mobile, email;


            public recycleViewHolder(@NonNull View itemView) {

                super(itemView);


                profileImage = itemView.findViewById(R.id.profileImage);
                imgCall = itemView.findViewById(R.id.imgCall);
                name = itemView.findViewById(R.id.name);
                designation = itemView.findViewById(R.id.designation);
                wordNo = itemView.findViewById(R.id.wordNo);
                mobile = itemView.findViewById(R.id.mobile);
                email = itemView.findViewById(R.id.email);

            }


        }


        @NonNull
        @Override
        public recycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();
            View myView = inflater.inflate(R.layout.up_members_list, parent, false);


            return new recycleViewHolder(myView);
        }



        @Override
        public void onBindViewHolder(@NonNull recycleViewHolder holder, int position) {

            HashMap<String, String> hashMap = upMemberList.get(position);
            String s_profileImage = hashMap.get("image_link");
            String s_name = hashMap.get("name");
            String s_designation = hashMap.get("designation");
            String s_wordNo = hashMap.get("word_no");
            String s_mobile = hashMap.get("phone_number");
            String s_email = hashMap.get("email");

            Picasso.get()
                    .load(s_profileImage)
                    .into(holder.profileImage);

            holder.name.setText(s_name);
            holder.designation.setText(s_designation);
            holder.wordNo.setText(s_wordNo);
            holder.mobile.setText(s_mobile);
            holder.email.setText(s_email);


            holder.imgCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String pNumbre = holder.mobile.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(pNumbre));
                    startActivity(intent);
                }
            });



        }



        @Override
        public int getItemCount() {


            return upMemberList.size();
        }





    }






    // =============== Recycler Adapter END ==========//
    // =============== Recycler Adapter END ==========//
    // =============== Recycler Adapter END ==========//



    /////////////////////////////////////////////////////////////////////////







}






