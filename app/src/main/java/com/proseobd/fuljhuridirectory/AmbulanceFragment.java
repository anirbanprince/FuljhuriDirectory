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

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

public class AmbulanceFragment extends Fragment {

    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_ambulance, container, false);

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
        hashMap.put("name", "বরগুনা অ্যাম্বুলেন্স সার্ভিস");
        hashMap.put("designation", "বরগুনা");
        hashMap.put("mobile", "01789159780");
        hashMap.put("email", "01731150135");
        hashMap.put("profileImage", "https://proseobd.com/apps/fuljhuridirectory/emergency/ambulance/barguna_ambulance.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "সেবা এ্যাম্বুলেন্স সার্ভিস");
        hashMap.put("designation", "বরগুনা");
        hashMap.put("mobile", "01720666691");
        hashMap.put("email", "");
        hashMap.put("profileImage", "https://proseobd.com/apps/fuljhuridirectory/emergency/ambulance/seba_ambulance.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "শিকদার এ্যাম্বুলেন্স সার্ভিস");
        hashMap.put("designation", "বরগুনা");
        hashMap.put("mobile", "01713260042");
        hashMap.put("email", "");
        hashMap.put("profileImage", "https://proseobd.com/apps/fuljhuridirectory/emergency/ambulance/labib.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "অনলাইন এ্যাম্বুলেন্স সার্ভিস");
        hashMap.put("designation", "বরগুনা");
        hashMap.put("mobile", "01627669222");
        hashMap.put("email", "");
        hashMap.put("profileImage", "https://proseobd.com/apps/fuljhuridirectory/emergency/ambulance/labib.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "টুয়েন্টিফোর এ্যাম্বুলেন্স সার্ভিস");
        hashMap.put("designation", "বরগুনা");
        hashMap.put("mobile", "01911125156");
        hashMap.put("email", "");
        hashMap.put("profileImage", "https://proseobd.com/apps/fuljhuridirectory/emergency/ambulance/labib.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "লাবিব এ্যাম্বুলেন্স সার্ভিস।");
        hashMap.put("designation", "মন্সিরহাট,পাথরঘাটা,বরগুনা।");
        hashMap.put("mobile", "01894011359");
        hashMap.put("email", "");
        hashMap.put("profileImage", "https://proseobd.com/apps/fuljhuridirectory/emergency/ambulance/labib.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "");
        hashMap.put("designation", "");
        hashMap.put("mobile", "");
        hashMap.put("email", "");
        hashMap.put("profileImage", "");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name", "");
        hashMap.put("designation", "");
        hashMap.put("mobile", "");
        hashMap.put("email", "");
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
            imgEmail.setImageResource(R.drawable.call);
            Glide.with(requireActivity())
                    .load(hashMap.get("profileImage"))
                    .error(R.drawable.dummy_image)
                    .into(profileImage);

            imgCall.setOnClickListener(v -> {
                mobile.setClickable(true);
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + arrayList.get(position).get("mobile")));
                mobile.getContext().startActivity(intent);
            });


            imgEmail.setOnClickListener(v -> {
                mobile.setClickable(true);
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + arrayList.get(position).get("mobile")));
                mobile.getContext().startActivity(intent);
            });



            return myView;
        }
    }


    /////////////// Adapter  END /////////////


}