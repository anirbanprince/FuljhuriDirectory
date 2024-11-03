package com.proseobd.fuljhuridirectory.adapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
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
import com.proseobd.fuljhuridirectory.datamodels.UpMemberData;

import java.util.ArrayList;
import java.util.List;

public class UpMemberAdapter extends RecyclerView.Adapter<UpMemberAdapter.vHolder> implements Filterable {

    LayoutInflater inflater;
    List<UpMemberData> upMemberDataList;
    List<UpMemberData> backUpUpMemberDataList;

    public UpMemberAdapter (Context cTx, List<UpMemberData> upMemberDataList) {
        this.inflater = LayoutInflater.from(cTx);
        this.upMemberDataList = upMemberDataList;
        backUpUpMemberDataList = new ArrayList<>(upMemberDataList);
    }

    @NonNull
    @Override
    public vHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myView = inflater.inflate(R.layout.up_members_list, parent, false);

        return new vHolder(myView) ;
    }

    @Override
    public void onBindViewHolder(@NonNull vHolder holder, int position) {

        holder.name.setText(upMemberDataList.get(position).getName());
        holder.designation.setText(upMemberDataList.get(position).getDesignation());
        holder.mobile.setText(upMemberDataList.get(position).getMobile());
        holder.wordNo.setText(upMemberDataList.get(position).getWordNo());
        holder.email.setText(upMemberDataList.get(position).getEmail());
        Glide.with(holder.profileImage.getContext())
                .load(upMemberDataList.get(position).getProfileImage())
                .into(holder.profileImage);

        holder.setIsRecyclable(false);

        holder.imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.mobile.setClickable(true);
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + upMemberDataList.get(position).getMobile()));
                holder.mobile.getContext().startActivity(intent);

            }

        });

        holder.imgEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imgEmail.setClickable(true);
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + upMemberDataList.get(position).getEmail()));
                holder.email.getContext().startActivity(intent);
            }
        });


    }

    public class vHolder extends RecyclerView.ViewHolder {

        TextView name, designation, mobile, wordNo, email;
        ImageView profileImage, imgCall, imgEmail;

        public vHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            designation = itemView.findViewById(R.id.designation);
            mobile = itemView.findViewById(R.id.mobile);
            wordNo = itemView.findViewById(R.id.wordNo);
            email = itemView.findViewById(R.id.email);
            profileImage = itemView.findViewById(R.id.profileImage);

            imgCall = itemView.findViewById(R.id.imgCall);
            imgEmail = itemView.findViewById(R.id.imgEmail);
        }
    }

    @Override
    public int getItemCount() {
        return upMemberDataList.size();
    }

    @Override
    public Filter getFilter() {


        return filter;
    }


    Filter filter = new Filter() {
        @Override

        //backgroudn thread
        protected FilterResults performFiltering(CharSequence keyword) {
            List<UpMemberData> filteredList = new ArrayList<>();
            if (keyword.toString().isEmpty()) {
                filteredList.addAll(backUpUpMemberDataList);
            } else {
                for (UpMemberData singleMemberData : backUpUpMemberDataList) {
                    if (singleMemberData.getName().toString().toLowerCase().contains(keyword.toString().toLowerCase())) {
                        filteredList.add(singleMemberData);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;

        }

        //main UI thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            upMemberDataList.clear();
            upMemberDataList.addAll((List<UpMemberData>) results.values);
            notifyDataSetChanged();

        }
    };

}
