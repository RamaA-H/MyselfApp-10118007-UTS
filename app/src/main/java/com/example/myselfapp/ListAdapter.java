package com.example.myselfapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
//Tanggal Pengerjaan : 25 Mei 2021
//NIM   : 10118007
//Nama  : Rama Al Halik
//Kelas : IF-1
    public class ListAdapter extends RecyclerView.Adapter {
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_friend_item, parent, false);
            return new ListViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ((ListViewHolder)holder).bindView(position);
        }

        @Override
        public int getItemCount() {
            return Data.hari_daily.length;
        }


        public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            public TextView mItemText;
            public ImageView mItemImage;

            public ListViewHolder(View itemView){
                super(itemView);
                mItemText = (TextView) itemView.findViewById(R.id.textItem);
                mItemImage = (ImageView) itemView.findViewById(R.id.imageItem);
                itemView.setOnClickListener(this);
            }

            public void bindView(int position){
                mItemText.setText(Data.hari_daily[position]);
                mItemImage.setImageResource(Data.dailyPicturePath[position]);


            }



            @Override
            public void onClick(View v) {

            }
        }

    }

