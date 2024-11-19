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
import com.proseobd.fuljhuridirectory.datamodels.KamarData;

import java.util.ArrayList;
import java.util.List;

public class KamarAdapter extends RecyclerView.Adapter<KamarAdapter.ViewHolder> implements Filterable {

    LayoutInflater inflater;
    List<KamarData> kamarDataList;
    List<KamarData> backupKamarDataList;

    public KamarAdapter(LayoutInflater inflater, List<KamarData> kamarDataList) {
        this.inflater = inflater;
        this.kamarDataList = kamarDataList;
        backupKamarDataList = new ArrayList<>(kamarDataList);

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.single_layout_shop,parent,false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.name.setText(kamarDataList.get(position).getName());
        holder.owner.setText(kamarDataList.get(position).getOwner());
        holder.address.setText(kamarDataList.get(position).getAddress());
        holder.mobile.setText(kamarDataList.get(position).getMobile());
        holder.email.setText(kamarDataList.get(position).getEmail());

        Glide.with(holder.profileImage.getContext())
                .load(kamarDataList.get(position).getProfileImage())
                .error(R.drawable.dummy_image)
                .into(holder.profileImage);

        holder.profileImage.setOnClickListener(v -> {
            holder.profileImage.setClickable(true);
            holder.imgFrame.setVisibility(View.VISIBLE);
            Glide
                    .with(holder.profileImage.getContext())
                    .load(kamarDataList.get(position).getProfileImage())
                    .override(1000, 350)
                    .into(holder.imgFrame);
        });

        holder.setIsRecyclable(false);

        holder.imgCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + kamarDataList.get(position).getMobile()));
            holder.imgCall.getContext().startActivity(intent);

        });

        holder.imgEmail.setVisibility(View.GONE);

        holder.imgEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + kamarDataList.get(position).getEmail()));
            holder.imgEmail.getContext().startActivity(intent);
        });

        holder.email.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return kamarDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


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

            List<KamarData> filteredData = new ArrayList<>();

            if (keyword.toString().isEmpty()) {
                filteredData.addAll(backupKamarDataList);
            } else {
                for (KamarData item : backupKamarDataList){
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

            kamarDataList.clear();
            kamarDataList.addAll((List<KamarData>) results.values);
            notifyDataSetChanged();

        }
    };

}
