package com.example.createcreativity.Helper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.VideoCapture;
import androidx.camera.view.CameraView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.example.createcreativity.R;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecordVidio extends AppCompatActivity {
   /* @BindView(R.id.camera_view)
    CameraView cameraView;
    File vidiopath;
    File vidiofile;
    File audioPath;
    File audioFile;
    MediaPlayer mediaPlayer;
    MediaRecorder mediaRecorder;
    Context context;

    public RecordVidio() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_vidio);
        init();


    }

    @Override
    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) {

        switch (requestCode) {

            case 11:
                if (grantResults.length > 0) {
                    boolean recordPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean storage = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (recordPermission & storage) {
                        Toast.makeText(RecordVidio.this, "Permissions granted", Toast.LENGTH_LONG);
                    } else {
                        Toast.makeText(RecordVidio.this, "Permissions denied", Toast.LENGTH_LONG);


                    }
                }
            case 12: if (grantResults.length > 0) {
                boolean cameraPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean storage = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                if (cameraPermission & storage) {
                    initCamera();
                } else {
                    Toast.makeText(RecordVidio.this, "Permissions denied", Toast.LENGTH_LONG);


                }
            }


        }

    }

    public void init() {
        ButterKnife.bind(this);
        cameraView.bindToLifecycle(this);
        vidiopath = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_MOVIES);
        vidiofile = new File(vidiopath, "News Vidios");
        audioPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        audioFile = new File(audioPath, "News Audios");

    }

    public void initCamera() {
        if(ContextCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED)

       { cameraView.startRecording(new File(""), null, new VideoCapture.OnVideoSavedCallback() {

            @Override
            public void onVideoSaved(@NonNull File file) {
                Toast.makeText(RecordVidio.this, "vidio has been saved to" + file, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(int videoCaptureError, @NonNull String message, @Nullable Throwable cause) {
                Toast.makeText(RecordVidio.this, message, Toast.LENGTH_SHORT).show();

            }
        });}
        else{
            ActivityCompat.requestPermissions((Activity) getApplicationContext(), new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 12);

        }
    }

    public  void playVidio(Context context){

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void RecordAudio(File audiostorage) {
        if (checkPermission()) {
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.setOutputFile(audiostorage);

            try {
                mediaRecorder.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

            mediaRecorder.start();
        } else {
            requestPermission(11);

        }


    }
    //stop audio recording
    public void StopAudioRecording(){
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder= null;
    }

    public void PLayAudioRecording(Context context,Uri audioUri){
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(context,audioUri);
            mediaPlayer.prepare();
            mediaPlayer.start();
        }catch (Exception e){

        }
    }

    public void requestPermission(int requestCode) {
        switch (requestCode) {
            case 11:
                ActivityCompat.requestPermissions(RecordVidio.this, new String[]{Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE}, requestCode);
        }
    }

    //checkPermission
    public boolean checkPermission() {
        boolean audiopermissions = ContextCompat.checkSelfPermission(RecordVidio.this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED ;
        boolean writePermissions = ContextCompat.checkSelfPermission(RecordVidio.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ;
        boolean readPermissions = ContextCompat.checkSelfPermission(RecordVidio.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED;

        return audiopermissions && writePermissions && readPermissions;
    }
*/






}


