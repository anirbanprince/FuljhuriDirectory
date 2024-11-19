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
import com.proseobd.fuljhuridirectory.datamodels.BaniyatiData;

import java.util.ArrayList;
import java.util.List;

public class BaniyatiAdapter extends RecyclerView.Adapter<BaniyatiAdapter.ViewHolder>implements Filterable {



    LayoutInflater inflater;
    List<BaniyatiData> baniyatiDataList;
    List<BaniyatiData> backupBaniyatiDataList;;

    public BaniyatiAdapter(LayoutInflater inflater, List<BaniyatiData> baniyatiDataList) {
        this.inflater = inflater;
        this.baniyatiDataList = baniyatiDataList;
        backupBaniyatiDataList = new ArrayList<>(baniyatiDataList);

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.single_layout_shop,parent,false);



        return new BaniyatiAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.name.setText(baniyatiDataList.get(position).getName());
        holder.owner.setText(baniyatiDataList.get(position).getOwner());
        holder.address.setText(baniyatiDataList.get(position).getAddress());
        holder.mobile.setText(baniyatiDataList.get(position).getMobile());
        holder.email.setText(baniyatiDataList.get(position).getEmail());

        Glide.with(holder.profileImage.getContext())
                .load(baniyatiDataList.get(position).getProfileImage())
                .error(R.drawable.dummy_image)
                .into(holder.profileImage);

        holder.profileImage.setOnClickListener(v -> {
            holder.profileImage.setClickable(true);
            holder.imgFrame.setVisibility(View.VISIBLE);
            Glide
                    .with(holder.profileImage.getContext())
                    .load(baniyatiDataList.get(position).getProfileImage())
                    .override(1000, 350)
                    .into(holder.imgFrame);
        });

        holder.setIsRecyclable(false);

        holder.imgCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + baniyatiDataList.get(position).getMobile()));
            holder.imgCall.getContext().startActivity(intent);

        });

        holder.imgEmail.setVisibility(View.GONE);

        holder.imgEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + baniyatiDataList.get(position).getEmail()));
            holder.imgEmail.getContext().startActivity(intent);
        });

        holder.email.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return baniyatiDataList.size();
    }

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

            List<BaniyatiData> filteredData = new ArrayList<>();

            if (keyword.toString().isEmpty()) {
                filteredData.addAll(backupBaniyatiDataList);
            } else {
                for (BaniyatiData item : baniyatiDataList){
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

            baniyatiDataList.clear();
            baniyatiDataList.addAll((List<BaniyatiData>) results.values);
            notifyDataSetChanged();

        }
    };



}
