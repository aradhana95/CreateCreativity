package com.example.createcreativity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class PlayMusicFragment extends Fragment  {
    Context context;
    MediaPlayer mediaPlayer;
private  MediaPlayerService mediaPlayerService ;
boolean serviceBound = false;


@Override
public void onSaveInstanceState(Bundle savedInstanceState){
    savedInstanceState.putBoolean("serviceState",serviceBound);
    super.onSaveInstanceState(savedInstanceState);
}
public  void setContext(Context context){
    this.context = context;

}

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      //  serviceBound = savedInstanceState.getBoolean("ServiceState");
    }



    public PlayMusicFragment() {
        // Required empty public constructor
    }
    public PlayMusicFragment(Context context){
        this.context = context;
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
       /* mediaPlayer = MediaPlayer.create(getActivity(),R.raw.newssong);
        mediaPlayer.start();
*/
        if(!serviceBound){
            Intent mediaIntent = new Intent(context,MediaPlayerService.class);
            mediaIntent.putExtra("media",musicName);
            context.startService(mediaIntent);
            context.bindService(mediaIntent,serviceConnection,Context.BIND_AUTO_CREATE);}
            else {

            Toast.makeText(context, "connection established", Toast.LENGTH_SHORT).show();
            Log.d("this","established");

            }
    }



    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MediaPlayerService.LocalBinder binder = ( MediaPlayerService.LocalBinder) iBinder;
            mediaPlayerService = binder.getService();
            serviceBound =  true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            serviceBound = false;

        }
    };
}