package com.example.createcreativity;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class PlayMusicFragment extends Fragment  {



    public PlayMusicFragment() {
        // Required empty public constructor
    }

    @Nullable
   // @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_play_music, container, false);
        return  rootView;
    }

    public  void playMusic(String musicName){

    }
}