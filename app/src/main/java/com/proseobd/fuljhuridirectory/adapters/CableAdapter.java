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
import com.proseobd.fuljhuridirectory.datamodels.CableData;

import java.util.ArrayList;
import java.util.List;

public class CableAdapter extends RecyclerView.Adapter<CableAdapter.ViewHolder> implements Filterable {

    LayoutInflater inflater;
    List<CableData> cableDataList;
    List<CableData> backupCableDataList;;

    public CableAdapter(LayoutInflater inflater, List<CableData> cableDataList) {
        this.inflater = inflater;
        this.cableDataList = cableDataList;
        backupCableDataList = new ArrayList<>(cableDataList);

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.single_layout_shop,parent,false);



        return new CableAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(cableDataList.get(position).getName());
        holder.owner.setText(cableDataList.get(position).getOwner());
        holder.address.setText(cableDataList.get(position).getAddress());
        holder.mobile.setText(cableDataList.get(position).getMobile());
        holder.email.setText(cableDataList.get(position).getEmail());

        Glide.with(holder.profileImage.getContext())
                .load(cableDataList.get(position).getProfileImage())
                .error(R.drawable.dummy_image)
                .into(holder.profileImage);

        holder.imgCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + cableDataList.get(position).getMobile()));
            holder.imgCall.getContext().startActivity(intent);

        });

        holder.imgEmail.setVisibility(View.GONE);

        holder.imgEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + cableDataList.get(position).getEmail()));
            holder.imgEmail.getContext().startActivity(intent);
        });

        holder.email.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return cableDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView name, owner, address, mobile, email;
        ImageView profileImage, imgCall, imgEmail;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.name);
            owner = itemView.findViewById(R.id.owner);
            address = itemView.findViewById(R.id.address);
            mobile = itemView.findViewById(R.id.mobile);
            email = itemView.findViewById(R.id.email);
            profileImage = itemView.findViewById(R.id.profileImage);
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

            List<CableData> filteredData = new ArrayList<>();

            if (keyword.toString().isEmpty()) {
                filteredData.addAll(backupCableDataList);
            } else {
                for (CableData item : backupCableDataList){
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

            cableDataList.clear();
            cableDataList.addAll((List<CableData>) results.values);
            notifyDataSetChanged();

        }
    };




}
