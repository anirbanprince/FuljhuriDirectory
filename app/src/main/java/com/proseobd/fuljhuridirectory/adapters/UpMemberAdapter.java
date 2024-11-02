package com.proseobd.fuljhuridirectory.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.proseobd.fuljhuridirectory.R;
import com.proseobd.fuljhuridirectory.datamodels.UpMemberData;

import java.util.List;

public class UpMemberAdapter extends RecyclerView.Adapter<UpMemberAdapter.vHolder> {

    LayoutInflater inflater;
    List<UpMemberData> upMemberDataList;

    public UpMemberAdapter (Context cTx, List<UpMemberData> upMemberDataList) {
        this.inflater = LayoutInflater.from(cTx);
        this.upMemberDataList = upMemberDataList;
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




    }

    @Override
    public int getItemCount() {
        return upMemberDataList.size();
    }
//// new line
    public void setFilteredList(List<UpMemberData> upMemberDataList) {
        this.upMemberDataList = upMemberDataList;
        notifyDataSetChanged();
    }

    public class vHolder extends RecyclerView.ViewHolder {

        TextView name, designation, mobile, wordNo, email;
        ImageView profileImage;

        public vHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            designation = itemView.findViewById(R.id.designation);
            mobile = itemView.findViewById(R.id.mobile);
            wordNo = itemView.findViewById(R.id.wordNo);
            email = itemView.findViewById(R.id.email);
            profileImage = itemView.findViewById(R.id.profileImage);
        }
    }

}
