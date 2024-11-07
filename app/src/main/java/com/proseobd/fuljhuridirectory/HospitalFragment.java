package com.proseobd.fuljhuridirectory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class HospitalFragment extends Fragment {

    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_hospital, container, false);

        TextView titleText = fragmentView.findViewById(R.id.titleText);
        ListView listView = fragmentView.findViewById(R.id.listView);

        table();

        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);


        return fragmentView;

    }

    ////////////// Fragment END ////////////////////

/////////////// createTable  START /////////////

    private void table() {


        arrayList.clear();

        hashMap = new HashMap<>();
        hashMap.put("name", "* জেনারেল হাসপাতাল, বরগুনা।");
        hashMap.put("address", "* বরগুনা জেলা সদর।");
        hashMap.put("nameOH", "* ডা: এ.এইচ,এম জহিরুল ইসলাম সিভিল। সার্জন,বরগুনা।");
        hashMap.put("mobileOH", "০৪৪৮৬২৩৮৬");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name", "* আমতলী উপজেলা স্বাস্থ্য কমপ্লেক্স।");
        hashMap.put("address", "* আমতলী উপজেলা সদর।");
        hashMap.put("nameOH", "* ডা: মদন গোপাল পাল। উপজেলা স্বাস্থ্য ও প: প: কর্মকর্তা।");
        hashMap.put("mobileOH", "০৪৪৫২৫৬০১৬");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name", "* বেতাগী উপজেলা স্বাস্থ্য কমপ্লেক্স।");
        hashMap.put("address", "* বেতাগী উপজেলা সদর।");
        hashMap.put("nameOH", "* ডা মো:আলমগীর হোসেন। উপজেলা স্বাস্থ্য ও প: প: কর্মকর্তা।");
        hashMap.put("mobileOH", "০৪৪৫৪৫৬০৩০");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "* বামনা উপজেলা স্বাস্থ্য কমপ্লেক্স।");
        hashMap.put("address", "* বামনা উপজেলা সদর।");
        hashMap.put("nameOH", "* ডা: মো: আবুল কালাম আজাদ। উপজেলা স্বাস্থ্য ও প: প: কর্মকর্তা।");
        hashMap.put("mobileOH", "০৪৪৫৩৫৬০৭৬");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name", "* পাথরঘাটা উপজেলা স্বাস্থ্য কমপ্লেক্সপ্লক্স।");
        hashMap.put("address", "* পাথরঘাটা উপজেলা সদর।");
        hashMap.put("nameOH", "* ডা: অমল চন্দ্র রায়। উপজেলা স্বাস্থ্য ও প: প: কর্মকর্তা।");
        hashMap.put("mobileOH", "০৪৪৫৫৭৫০০২");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name", "* বরগুনা সেন্ট্রাল ক্লিনিক।");
        hashMap.put("address", "* ডিকেপি রোড, বরগুনা।");
        hashMap.put("nameOH", "* প্রো: মো: মনিরুল ইসলাম।");
        hashMap.put("mobileOH", "০১৭২৫২৫৫১৮০");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name", "* ডক্টরস কেয়ার ক্লিনিক ও হসপিটাল।");
        hashMap.put("address", "* বকলেজ রোড, বরগুনা।");
        hashMap.put("nameOH", "* প্রো: আকলিমা বেগম।");
        hashMap.put("mobileOH", "০১৭১২৬২৭৯৮৯");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name", "* শাপলা ক্লিনিক।");
        hashMap.put("address", "* হাসপাতাল রোড, পাথরঘাটা।");
        hashMap.put("nameOH", "* প্রো: মো: মকবুল হোসেন মিলন।");
        hashMap.put("mobileOH", "০১৭২২৫৪৬৩৮২");
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

            View myView = getLayoutInflater().inflate(R.layout.hospital_single_layout, parent, false);

            Animation title_animation;
            title_animation = AnimationUtils.loadAnimation(getContext(),R.anim.title_anim);
            TextView name = myView.findViewById(R.id.name);
            TextView address = myView.findViewById(R.id.address);
            TextView nameOH = myView.findViewById(R.id.nameOH);
            TextView mobileOH = myView.findViewById(R.id.mobileOH);
//            ImageView profileImage = myView.findViewById(R.id.profileImage);
            ImageView imgCall = myView.findViewById(R.id.imgCall);

            nameOH.startAnimation(title_animation);

            hashMap = arrayList.get(position);

            name.setText(hashMap.get("name"));
            address.setText(hashMap.get("address"));
            nameOH.setText(hashMap.get("nameOH"));
            mobileOH.setText(hashMap.get("mobileOH"));

            imgCall.setOnClickListener(v -> {
                nameOH.setClickable(true);
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + arrayList.get(position).get("mobileOH")));
                nameOH.getContext().startActivity(intent);
            });



            return myView;
        }
    }







    /////////////// Adapter  END /////////////


}