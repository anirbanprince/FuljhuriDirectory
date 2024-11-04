package com.proseobd.fuljhuridirectory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;


public class FireServiceFragment extends Fragment {

    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_fire_service, container, false);

        TextView titleText = fragmentView.findViewById(R.id.titleText);
        ListView listView = fragmentView.findViewById(R.id.listView);


        createTable();

        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);


        return fragmentView;
    }

    ////////////// Fragment END ////////////////////



    /////////////// createTable  START /////////////

    private void createTable() {


        hashMap = new HashMap<>();
        hashMap.put("name", "মজাহাঙ্গীর আহমেদ");
        hashMap.put("designation", "উপসহকারী পরিচালক");
        hashMap.put("mobile", "০১৯০১০২৩৯০৭");
        hashMap.put("email", "dadbgn@fireservice.gov.bd");
        hashMap.put("profileImage", "https://file-barisal.portal.gov.bd/uploads/906443ab-c855-4019-a195-ced32446f0e8//623/0c2/50d/6230c250d618e106326922.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "জনাব কানিজ রোকসানা");
        hashMap.put("designation", " উচ্চমান সহকারী কাম ক্যাশিয়ার");
        hashMap.put("mobile", "০১৮৫১১৩২৫৭৮");
        hashMap.put("email", "pizujamshad@gmail.com");
        hashMap.put("profileImage", "http://file-barisal.portal.gov.bd/media/906443ab-c855-4019-a195-ced32446f0e8/uploaded-files/1663127560111.jpeg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "মজনাব বরুন কুমার মজুমদার");
        hashMap.put("designation", "অফিস সহকারী কাম কম্পিউটার অপারেটর");
        hashMap.put("mobile", "০১৯৫৪৫৮২৭৯১");
        hashMap.put("email", "mazumderborun@gmail.com");
        hashMap.put("profileImage", "http://file-barisal.portal.gov.bd/media/906443ab-c855-4019-a195-ced32446f0e8/uploaded-files/1649489746874.jpeg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "জনাব মো:হাবিবুর রহমান");
        hashMap.put("designation", "অফিস সহায়ক");
        hashMap.put("mobile", "N/A");
        hashMap.put("email", "nokiafrp888@gmail.com");
        hashMap.put("profileImage", "http://file-barisal.portal.gov.bd/media/906443ab-c855-4019-a195-ced32446f0e8/uploaded-files/1649490479285.jpeg");
        arrayList.add(hashMap);






    }



    /////////////// createTable  END /////////////




    /////////////// Adapter  START /////////////

    private class MyAdapter extends BaseAdapter {


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

            View myView = getLayoutInflater().inflate(R.layout.emergency_single_layout, null);

            TextView name = myView.findViewById(R.id.name);
            TextView designation = myView.findViewById(R.id.designation);
            TextView mobile = myView.findViewById(R.id.mobile);
            TextView email = myView.findViewById(R.id.email);
            ImageView profileImage = myView.findViewById(R.id.profileImage);
            ImageView imgCall = myView.findViewById(R.id.imgCall);
            ImageView imgEmail = myView.findViewById(R.id.imgEmail);


            hashMap = arrayList.get(position);

            name.setText(hashMap.get("name"));
            designation.setText(hashMap.get("designation"));
            mobile.setText(hashMap.get("mobile"));
            email.setText(hashMap.get("email"));
            Glide.with(getActivity())
                    .load(hashMap.get("profileImage"))
                    .error(R.drawable.dummy_image)
                    .into(profileImage);

            imgCall.setOnClickListener(v -> {
                mobile.setClickable(true);
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + hashMap.get("mobile")));
                mobile.getContext().startActivity(intent);
            });

            imgEmail.setOnClickListener(v ->{
                email.setClickable(true);
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + hashMap.get("email")));
                email.getContext().startActivity(intent);
            });




            return myView;
        }
    }







    /////////////// Adapter  END /////////////
}