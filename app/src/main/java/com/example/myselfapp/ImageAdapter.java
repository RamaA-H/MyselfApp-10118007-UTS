package com.example.myselfapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
//Tanggal Pengerjaan : 25 Mei 2021
//NIM   : 10118007
//Nama  : Rama Al Halik
//Kelas : IF-1
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.Holder> {


    private List<LocalImage> images;
    private Context context;

    public ImageAdapter(ArrayList<LocalImage> images, Context context) {
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public com.example.myselfapp.ImageAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_gallery_item, parent, false);
        context = parent.getContext();
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  com.example.myselfapp.ImageAdapter.Holder holder, int position) {
        LocalImage allData = images.get(position);
        holder.bind(allData);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        Holder(@NonNull View itemView) {
            super(itemView);
        }

        void bind(LocalImage allData) {
            ImageView ivLocal = itemView.findViewById(R.id.galery_item);
            ivLocal.setImageResource(allData.imageId);
        }
    }
}