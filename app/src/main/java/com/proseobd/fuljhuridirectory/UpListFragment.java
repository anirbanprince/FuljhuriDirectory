package com.proseobd.fuljhuridirectory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;


public class UpListFragment extends Fragment {

    GridView gridView;

    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_up_list, container, false);

        gridView = fragmentView.findViewById(R.id.gridView);










        return fragmentView;
    }


    //===================== Base Adapter Start Here ==========================//
    //===================== Base Adapter Start Here ==========================//
    //===================== Base Adapter Start Here ==========================//

    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
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
            View myView = layoutInflater.inflate(R.layout.up_members_list, parent,false);


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

    private void createTable(){

        arrayList = new ArrayList<>();


        String url = "https://proseobd.com/apps/fuljhuridirectory/upmembers/up_members.json";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {


                        Log.d("ServerRes", response.toString());

                        for (int x=0; x<response.length(); x++){

                            try {

                                JSONObject jsonObject = response.getJSONObject(x);

                                String name =  jsonObject.optString("name");
                                String designation = jsonObject.optString("designation");
                                String phone_number = jsonObject.optString("phone_number");
                                String word_no = jsonObject.optString("word_no");
                                String image_link = jsonObject.optString("image_link");
                                String email = jsonObject.optString("email");

                                hashMap = new HashMap<>();
                                hashMap.put("name", name);
                                hashMap.put("designation", designation);
                                hashMap.put("phone_number", phone_number);
                                hashMap.put("word_no", word_no);
                                hashMap.put("image_link", image_link);
                                hashMap.put("email", email);
                                arrayList.add(hashMap);



                                MyAdapter myAdapter = new MyAdapter();
                                gridView.setAdapter(myAdapter);


                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }



                        }



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(jsonArrayRequest);




    }

    //===================== Data Parsing Privet Methode ====================//
    //===================== Data Parsing Privet Methode ====================//
    //===================== Data Parsing Privet Methode ====================//

}