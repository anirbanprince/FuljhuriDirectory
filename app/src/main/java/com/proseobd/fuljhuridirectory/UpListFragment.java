package com.proseobd.fuljhuridirectory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.proseobd.controllers.NetworkUtils;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class UpListFragment extends Fragment {

    ListView gridView;
    ProgressBar progressBar;
    SwipeRefreshLayout swipeRefreshLayout;

    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> upMemberList = new ArrayList<>();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_up_list, container, false);

        TextView vdAdd = fragmentView.findViewById(R.id.vdAdd);

        gridView = fragmentView.findViewById(R.id.gridView);
        progressBar = fragmentView.findViewById(R.id.progressBar);
        swipeRefreshLayout = fragmentView.findViewById(R.id.swipeRefreshLayout);

        if (NetworkUtils.isInternetAvailable(getActivity())) {
            loadData();
        } else {
            Toast.makeText(getActivity(), "Please Connect To The Internet", Toast.LENGTH_LONG).show();
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
                    Toast.makeText(getActivity(), "Please Connect To The Internet", Toast.LENGTH_LONG).show();
                    swipeRefreshLayout.setRefreshing(false);
                }

            }
        });



        return fragmentView;
    }


    //===================== Base Adapter Start Here ==========================//
    //===================== Base Adapter Start Here ==========================//
    //===================== Base Adapter Start Here ==========================//


    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return upMemberList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View myView = layoutInflater.inflate(R.layout.up_members_list, parent, false);

            ImageView profileImage = myView.findViewById(R.id.profileImage);
            TextView name = myView.findViewById(R.id.name);
            TextView designation = myView.findViewById(R.id.designation);
            TextView wordNo = myView.findViewById(R.id.wordNo);
            TextView mobile = myView.findViewById(R.id.mobile);
            TextView email = myView.findViewById(R.id.email);


            HashMap<String, String> hashMap = upMemberList.get(position);
            String s_profileImage = hashMap.get("image_link");
            String s_name = hashMap.get("name");
            String s_designation = hashMap.get("designation");
            String s_wordNo = hashMap.get("word_no");
            String s_mobile = hashMap.get("phone_number");
            String s_email = hashMap.get("email");

            Picasso.get()
                    .load(s_profileImage)
                    .into(profileImage);

            name.setText(s_name);
            designation.setText(s_designation);
            wordNo.setText(s_wordNo);
            mobile.setText(s_mobile);
            email.setText(s_email);




            return myView;
        }
    }

    //===================== Base Adapter End Here ==========================//
    //===================== Base Adapter End Here ==========================//
    //===================== Base Adapter End Here ==========================//

    /////////////////////////////////////////////////////////////////////////

    //===================== Data Parsing Privet Methode ====================//
    //===================== Data Parsing Privet Methode ====================//
    //===================== Data Parsing Privet Methode ====================//


    public void loadData () {

        upMemberList = new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

//        String url ="https://proseobd.com/apps/fuljhuridirectory/upmembers/up_members.json";
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

                            if (upMemberList.size()>0) {

                                MyAdapter myAdapter = new MyAdapter();
                                gridView.setAdapter(myAdapter);

                            }

                        }



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue.add(jsonArrayRequest);

    }

    //===================== Data Parsing Privet Methode ====================//
    //===================== Data Parsing Privet Methode ====================//
    //===================== Data Parsing Privet Methode ====================//




}






