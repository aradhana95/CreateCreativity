package com.example.createcreativity.CaptureAudioVidio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraX;
import androidx.camera.core.VideoCapture;
import androidx.camera.view.CameraView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.example.createcreativity.R;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecordVidio extends AppCompatActivity {
    @BindView(R.id.camera_view)
    CameraView cameraView;
    File vidiopath;
    File vidiofile;
    File audioPath;
    File audioFile;
    MediaPlayer mediaPlayer;
    MediaRecorder mediaRecorder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_vidio);
        init();


    }

   /* @Override
    public void onRequestPermissionResult(int requestCode, String permissions[], int[] grantResults) {

        switch (requestCode) {

            case 11:
                if (grantResults.length > 0) {
                    boolean recordPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean storage = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (recordPermission & storage) {
                        Toast.makeText(RecordVidio.this, "Permissions granted", Toast.LENGTH_LONG);
                    } else {
                        Tgit oast.makeText(RecordVidio.this, "Permissions denied", Toast.LENGTH_LONG);


                    }
                }


        }

    }*/

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

        cameraView.startRecording(new File(""), null, new VideoCapture.OnVideoSavedCallback() {

            @Override
            public void onVideoSaved(@NonNull File file) {
                Toast.makeText(RecordVidio.this, "vidio has been saved to" + file, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(int videoCaptureError, @NonNull String message, @Nullable Throwable cause) {
                Toast.makeText(RecordVidio.this, message, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void MediaRecorder() {
        if (checkPermission()) {
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.setOutputFile(audioFile);

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







}


