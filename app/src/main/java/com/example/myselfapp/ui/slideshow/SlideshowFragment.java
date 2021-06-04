package com.example.myselfapp.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myselfapp.MusicAdapter;
import com.example.myselfapp.R;
//Tanggal Pengerjaan : 1 Juni 2021
//NIM   : 10118007
//Nama  : Rama Al Halik
//Kelas : IF-1
public class SlideshowFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewMusic);
        MusicAdapter listAdapter = new MusicAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        VideoView itemVideo = view.findViewById(R.id.recyclerViewVideo);
        itemVideo.setVideoPath("android.resource://" + getActivity().getPackageName() + "/" + R.raw.mayoizuki);
        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(itemVideo);
        itemVideo.setMediaController(mediaController);

        return view;
    }
}