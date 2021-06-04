package com.example.myselfapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myselfapp.LocalImage;
import com.example.myselfapp.R;

import java.util.ArrayList;
import com.example.myselfapp.R;
//Tanggal Pengerjaan : 25 Mei 2021
//NIM   : 10118007
//Nama  : Rama Al Halik
//Kelas : IF-1
public class GalleryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        setupRecyclerView(view);
        return view;
    }

    private void setupRecyclerView(View view) {
        ArrayList<LocalImage> data = new ArrayList<>();

        data.add(new LocalImage(R.drawable.gal1));
        data.add(new LocalImage(R.drawable.gal2));
        data.add(new LocalImage(R.drawable.gal3));
        data.add(new LocalImage(R.drawable.gal4));
        data.add(new LocalImage(R.drawable.gal5));
        data.add(new LocalImage(R.drawable.gal6));




        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewGallery);
        com.example.myselfapp.ImageAdapter adapter = new  com.example.myselfapp.ImageAdapter(data, getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }
}