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


public class PoliceStationFragment extends Fragment {

    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_police_station, container, false);

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
        hashMap.put("name", "মোঃ আলী আহমেদ");
        hashMap.put("designation", "অফিসার ইনচার্জ, বরগুনা থানা, বরগুনা।");
        hashMap.put("mobile", "০১৩২০১৫৬১৬১");
        hashMap.put("email", "ocbrg.bar@police.gov.bd");
        hashMap.put("profileImage", "");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "মোঃ শহিদুল ইসলাম");
        hashMap.put("designation", "পুলিশ পরিদর্শক(নিঃ) তদন্ত, বরগুনা থানা,বরগুনা");
        hashMap.put("mobile", "০১৭১৬৭৮৪০৫৭");
        hashMap.put("email", "moslehuddin995@yahoo.com");
        hashMap.put("profileImage", "");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "শরজিৎ কুমার ঘোষ");
        hashMap.put("designation", "পুলিশ পরিদর্শক (অপারেশন এন্ড কমিউনিটি পুলিশিং)");
        hashMap.put("mobile", "০১৭২২৪১৮৫৯২");
        hashMap.put("email", "sharajitghosh4038@gmail.com");
        hashMap.put("profileImage", "");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "মোঃ ইয়াকুব হোসাইন");
        hashMap.put("designation", "সাব-ইন্সপেক্টর(নিঃ)");
        hashMap.put("mobile", "০১৭১০৫০৬৬৯৮");
        hashMap.put("email", "eakub08@yahoo.com");
        hashMap.put("profileImage", "");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "মোঃ রুহুল আমিন");
        hashMap.put("designation", "সাব-ইন্সপেক্টর (নিঃ) বরগুনা থানা, বরগুনা।");
        hashMap.put("mobile", "০১৭১৮১২৭৬৬২");
        hashMap.put("email", "ruhulamin9823@gmail.com");
        hashMap.put("profileImage", "");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "সামসুন নাহার আক্তার");
        hashMap.put("designation", "সাব-ইন্সপেক্টর (নিঃ),বরগুনা থানা");
        hashMap.put("mobile", "০১৭১৬১৮০৪৩৫");
        hashMap.put("email", "sumsunnaher435@gmail.com");
        hashMap.put("profileImage", "");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "মোঃ মোশারফ হোসেন");
        hashMap.put("designation", "সাব-ইন্সপেক্টর (নিঃ) বরগুনা থানা, বরগুনা।");
        hashMap.put("mobile", "০১৭৬৬৮২৫২১৪");
        hashMap.put("email", "mosharof7696@gmail.com");
        hashMap.put("profileImage", "");
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

            View myView = getLayoutInflater().inflate(R.layout.emergency_single_layout, parent, false);

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
            Glide.with(requireActivity())
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