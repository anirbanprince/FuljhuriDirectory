package com.proseobd.fuljhuridirectory;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class HomeFragment extends Fragment {
    GridView gridView;

    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_home, container, false);

        gridView = fragmentView.findViewById(R.id.gridView);

        creattable();

        MyAdapter myAdapter = new MyAdapter();

        gridView.setAdapter(myAdapter);






        return fragmentView;

    }

//======================= Base Adapter =============================//
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
        View myView = layoutInflater.inflate(R.layout.categories, parent, false);

        RelativeLayout relLayout = myView.findViewById(R.id.relLayout);
        TextView catName = myView.findViewById(R.id.catName);


        hashMap = arrayList.get(position);
        String cName = hashMap.get("catName");

 //       Random rnd = new Random();
 //       int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
  //      relLayout.setBackgroundColor(color);
        catName.setText(cName);

        relLayout.setOnClickListener(v -> {

            if (catName.getText().equals("ইউপি সদস্য")){

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment_container, new UpListFragment());
                fragmentTransaction.commit();
            }

        });






        return myView;
    }
}



//======================   ArrayList ========================//
    public void creattable () {

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ইউপি সদস্য");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ইট , বালু , সিমেন্টের দোকান");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ওয়াইফাই এবং ডিস কন্ট্রোল");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ওয়ার্কসপ");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "কসমেটিকস");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "কাচা বাজার ");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "কামার - কুমারের দোকান");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "কীটনাশক এবং পোল্ট্রি ফিড");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "গ্যার্মেন্টস এবং কাপড়ের দোকান");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ঘাট এবং গাড়ি স্ট্যান্ড");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "চায়ের দোকান");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "চায়ের দোকান");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "জুতোর দোকান");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "জুয়েলার্স");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "টিনের দোকান");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ধোপা");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "পানের দোকান");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ফলের দোকান");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ফার্মেসি");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "বানিয়াতি দোকান");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "বিকাশ,নগদ,মোবাইল রিচার্জ");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "বিশেষ ব্যাক্তিবর্গের নাম");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ব্যাংক এবং এনজিও");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "মসজিদ এবং মন্দির");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "মাংসের দোকান");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "মাছের দোকান ");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "মুচি");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "মুদি দোকান");
        arrayList.add(hashMap);


        hashMap =new HashMap<>();
        hashMap.put("catName" , "মোবাইল এবং অন্যান্য ইলেকট্রনিক্স রিপেয়ার");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "শিক্ষা প্রতিষ্ঠান");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "সিলভার এবং ম্যালামাইন");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "স-মিল");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "স্টেডিও এবং কম্পিউটার টাইপ");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "স্যালুন");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "হার্ডওয়্যার এন্ড স্যানিটেশন");
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "হোটেল এবং রেস্টুরেস্ট");
        arrayList.add(hashMap);


    }



}