package com.proseobd.fuljhuridirectory.adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.proseobd.fuljhuridirectory.R;
import com.proseobd.fuljhuridirectory.datamodels.CosmeticsData;
import com.proseobd.fuljhuridirectory.datamodels.KamarData;

import java.util.ArrayList;
import java.util.List;

public class CosmeticsAdapter extends RecyclerView.Adapter< CosmeticsAdapter.ViewHolder> implements Filterable {

    LayoutInflater inflater;
    List<CosmeticsData> cosmeticsDataList;
    List<CosmeticsData> backupcosmeticsDataList;

    public CosmeticsAdapter(LayoutInflater inflater, List<CosmeticsData> cosmeticsDataList) {
        this.inflater = inflater;
        this.cosmeticsDataList = cosmeticsDataList;
        backupcosmeticsDataList = new ArrayList<>(cosmeticsDataList);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = inflater.inflate(R.layout.single_layout_shop,parent,false);



        return new CosmeticsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(cosmeticsDataList.get(position).getName());
        holder.owner.setText(cosmeticsDataList.get(position).getOwner());
        holder.address.setText(cosmeticsDataList.get(position).getAddress());
        holder.mobile.setText(cosmeticsDataList.get(position).getMobile());
        holder.email.setText(cosmeticsDataList.get(position).getEmail());

        Glide.with(holder.profileImage.getContext())
                .load(cosmeticsDataList.get(position).getProfileImage())
                .error(R.drawable.dummy_image)
                .into(holder.profileImage);

        holder.profileImage.setOnClickListener(v -> {
            holder.profileImage.setClickable(true);
            holder.imgFrame.setVisibility(View.VISIBLE);
            Glide
                    .with(holder.profileImage.getContext())
                    .load(cosmeticsDataList.get(position).getProfileImage())
                    .override(1000, 350)
                    .into(holder.imgFrame);
        });

        holder.setIsRecyclable(false);

        holder.imgCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + cosmeticsDataList.get(position).getMobile()));
            holder.imgCall.getContext().startActivity(intent);

        });

        holder.imgEmail.setVisibility(View.GONE);

        holder.imgEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + cosmeticsDataList.get(position).getEmail()));
            holder.imgEmail.getContext().startActivity(intent);
        });

        holder.email.setVisibility(View.GONE);


    }

    @Override
    public int getItemCount() {return cosmeticsDataList.size();}

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name, owner, address, mobile, email;
        ImageView profileImage, imgFrame, imgCall, imgEmail;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            owner = itemView.findViewById(R.id.owner);
            address = itemView.findViewById(R.id.address);
            mobile = itemView.findViewById(R.id.mobile);
            email = itemView.findViewById(R.id.email);
            profileImage = itemView.findViewById(R.id.profileImage);
            imgFrame = itemView.findViewById(R.id.imgFrame);
            imgCall = itemView.findViewById(R.id.imgCall);
            imgEmail = itemView.findViewById(R.id.imgEmail);
        }
    }
    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence keyword) {

            List<CosmeticsData> filteredData = new ArrayList<>();

            if (keyword.toString().isEmpty()) {
                filteredData.addAll(backupcosmeticsDataList);
            } else {
                for (CosmeticsData item : backupcosmeticsDataList){
                    if (item.getName().toLowerCase().contains(keyword.toString().toLowerCase())){
                        filteredData.add(item);
                    }
                    else if (item.getOwner().toLowerCase().contains(keyword.toString().toLowerCase())) {
                        filteredData.add(item);
                    }
                    else if (item.getMobile().toLowerCase().contains(keyword.toString().toLowerCase())) {
                        filteredData.add(item);
                    }
                }
            }


            FilterResults results = new FilterResults();
            results.values = filteredData;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            cosmeticsDataList.clear();
            cosmeticsDataList.addAll((List<CosmeticsData>) results.values);
            notifyDataSetChanged();

        }
    };



}
