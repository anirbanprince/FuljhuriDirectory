package com.proseobd.fuljhuridirectory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class HomeFragment extends Fragment {
    GridView gridView;

    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_home, container, false);

        gridView = fragmentView.findViewById(R.id.gridView);

        createtable();

        MyAdapter myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);



        return fragmentView;

    }

//======================= Base Adapter =============================//
    private class MyAdapter extends BaseAdapter{

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
        ImageView catImg = myView.findViewById(R.id.catImg);


        hashMap = arrayList.get(position);
        String cName = hashMap.get("catName");
        String cImg = hashMap.get("img");

        catName.setText(cName);
        catImg.setImageResource(Integer.parseInt(cImg));



        relLayout.setOnClickListener(v -> {

            assert cName != null;
            if (cName.contains("ইউপি সদস্য")){
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new UpListFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("জরুরী সেবা সমূহ")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new EmergencyFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("ফার্মেসি")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new PharmacyFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("ইট , বালু , সিমেন্টের দোকান")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("ইন্টারনেট এবং কেবল টিভি")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("ওয়ার্কসপ")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("কসমেটিকস")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("কাচা বাজার")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("কাঠমিস্ত্রী / ফার্নিচার")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("কামার এবং কুমারের দোকান")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("কীটনাশক এবং পোল্ট্রি ফিড")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("গ্যারেজ")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("গার্মেন্টস এবং কাপড়ের দোকান")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("চায়ের দোকান")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("জুতার দোকান")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("জুয়েলার্স")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("টিনের দোকান")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("ধোপা")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("নৌ-পরিসেবা")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("পাইকারি দোকান")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("পানের দোকান")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("পেট্রল / ডিজেল")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("ফলের দোকান")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("বানিয়াতি দোকান")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }
            else if (cName.contains("বিকাশ, নগদ, মোবাইল রিচার্জ")) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BricksFragment());
                fragmentTransaction.commit();
            }

        });




        return myView;
    }



}



//======================   ArrayList ========================//
    public void createtable () {

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ইউপি সদস্য");
        hashMap.put("img" , String.valueOf(R.drawable.government));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "জরুরী সেবা সমূহ");
        hashMap.put("img" , String.valueOf(R.drawable.emergency_icon));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ফার্মেসি");
        hashMap.put("img" , String.valueOf(R.drawable.medicine));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ইট , বালু , সিমেন্টের দোকান");
        hashMap.put("img" , String.valueOf(R.drawable.cement_icon));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ইন্টারনেট এবং কেবল টিভি");
        hashMap.put("img" , String.valueOf(R.drawable.wifi));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ওয়ার্কসপ");
        hashMap.put("img" , String.valueOf(R.drawable.welding));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "কসমেটিকস");
        hashMap.put("img" , String.valueOf(R.drawable.cosmetics));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "কাচা বাজার");
        hashMap.put("img" , String.valueOf(R.drawable.organic_food));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "কাঠমিস্ত্রী / ফার্নিচার");
        hashMap.put("img" , String.valueOf(R.drawable.carpenter));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "কামার এবং কুমারের দোকান");
        hashMap.put("img" , String.valueOf(R.drawable.pottery));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "কীটনাশক এবং পোল্ট্রি ফিড");
        hashMap.put("img" , String.valueOf(R.drawable.pesticide));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "গ্যারেজ");
        hashMap.put("img" , String.valueOf(R.drawable.garage));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "গার্মেন্টস এবং কাপড়ের দোকান");
        hashMap.put("img" , String.valueOf(R.drawable.thrift_shop));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "চায়ের দোকান");
        hashMap.put("img" , String.valueOf(R.drawable.tea_cup));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "জুতার দোকান");
        hashMap.put("img" , String.valueOf(R.drawable.shoes));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "জুয়েলার্স");
        hashMap.put("img" , String.valueOf(R.drawable.jewelry));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "টিনের দোকান");
        hashMap.put("img" , String.valueOf(R.drawable.roof));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ধোপা");
        hashMap.put("img" , String.valueOf(R.drawable.washing_clothes));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "নৌ-পরিসেবা");
        hashMap.put("img" , String.valueOf(R.drawable.steering_wheel));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "পাইকারি দোকান");
        hashMap.put("img" , String.valueOf(R.drawable.shop));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "পানের দোকান");
        hashMap.put("img" , String.valueOf(R.drawable.betel_leaf));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "পেট্রল / ডিজেল");
        hashMap.put("img" , String.valueOf(R.drawable.gas_station));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ফলের দোকান");
        hashMap.put("img" , String.valueOf(R.drawable.fruits));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "বানিয়াতি দোকান");
        hashMap.put("img" , String.valueOf(R.drawable.mix_mashala));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "বিকাশ, নগদ, মোবাইল রিচার্জ");
        hashMap.put("img" , String.valueOf(R.drawable.money_tranjection));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "বিশেষ ব্যাক্তিবর্গ");
        hashMap.put("img" , String.valueOf(R.drawable.vip));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ব্যাংক এবং এনজিও");
        hashMap.put("img" , String.valueOf(R.drawable.bank));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "ভ্যারাইটিস স্টোর");
        hashMap.put("img" , String.valueOf(R.drawable.marketplace));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "মসজিদ এবং মন্দির");
        hashMap.put("img" , String.valueOf(R.drawable.akshardham_temple));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "মাংসের দোকান");
        hashMap.put("img" , String.valueOf(R.drawable.meat_counter));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "মাছের দোকান ");
        hashMap.put("img" , String.valueOf(R.drawable.fish));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "মুচি");
        hashMap.put("img" , String.valueOf(R.drawable.cobbler));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "মুদি দোকান");
        hashMap.put("img" , String.valueOf(R.drawable.shopping_cart));
        arrayList.add(hashMap);


        hashMap =new HashMap<>();
        hashMap.put("catName" , "মোবাইল এবং অন্যান্য ইলেকট্রনিক্স রিপেয়ার");
        hashMap.put("img" , String.valueOf(R.drawable.technician));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "যানবাহন");
        hashMap.put("img" , String.valueOf(R.drawable.vehicle));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "লাইব্রেরি এবং স্টেশনারি");
        hashMap.put("img" , String.valueOf(R.drawable.library));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "শিক্ষা প্রতিষ্ঠান");
        hashMap.put("img" , String.valueOf(R.drawable.education));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "স-মিল এবং রাইচ মিল");
        hashMap.put("img" , String.valueOf(R.drawable.woodcutting));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "সিলভার এবং ম্যালামাইন");
        hashMap.put("img" , String.valueOf(R.drawable.plate));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "সেলুন এবং বিউটি পার্লার");
        hashMap.put("img" , String.valueOf(R.drawable.salon));
        arrayList.add(hashMap);


        hashMap =new HashMap<>();
        hashMap.put("catName" , "স্টুডিও এবং কম্পিউটার টাইপ");
        hashMap.put("img" , String.valueOf(R.drawable.studio));
        arrayList.add(hashMap);


        hashMap =new HashMap<>();
        hashMap.put("catName" , "হার্ডওয়্যার এন্ড স্যানিটেশন");
        hashMap.put("img" , String.valueOf(R.drawable.water));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "হোটেল এবং রেস্টুরেন্ট");
        hashMap.put("img" , String.valueOf(R.drawable.restaurant));
        arrayList.add(hashMap);

        hashMap =new HashMap<>();
        hashMap.put("catName" , "অন্যান্য");
        hashMap.put("img" , String.valueOf(R.drawable.more));
        arrayList.add(hashMap);




    }



}