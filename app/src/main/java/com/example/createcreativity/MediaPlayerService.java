package com.example.createcreativity;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Switch;

import java.io.IOException;

public class MediaPlayerService extends Service implements MediaPlayer.OnCompletionListener,MediaPlayer.OnPreparedListener,MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener,MediaPlayer.OnInfoListener,MediaPlayer.OnBufferingUpdateListener, AudioManager.OnAudioFocusChangeListener {
    public MediaPlayerService() {
    }

    MediaPlayer mediaPlayer;
    int resumePosition;
    AudioManager audioManager;
    String mediaFile;

    private final IBinder iBinder = new LocalBinder();


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            mediaFile = intent.getExtras().getString("mediaFiles");
        } catch (NullPointerException e) {
            stopSelf();
        }
        if (reuestAudioFocus() == false) {
            stopSelf();
        }

        if (mediaFile != null && mediaFile != "") {
            initMediaPlayer();
        }


        return super.onStartCommand(intent, flags, startId);

    }


    private void initMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this,R.raw.newssong);
        mediaPlayer.start();
      /*  mediaPlayer.setOnBufferingUpdateListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setOnInfoListener(this);
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnSeekCompleteListener(this);
        mediaPlayer.reset();*/

      //  mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
       /* try {
            mediaPlayer.setDataSource(mediaFile);
        } catch (IOException e) {
            e.printStackTrace();
            stopSelf();
        }*/
      //  mediaPlayer.prepareAsync();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }


    @Override
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        stopMedia();
        stopSelf();

    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        switch (what) {
            case MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK:
                Log.d("MediaPlayer Error", "Media error:not valid for progressive playback" + extra);
            case MediaPlayer.MEDIA_ERROR_SERVER_DIED:
                Log.d("MediaPlayer Error", "Media error server died" + extra);
            case MediaPlayer.MEDIA_ERROR_UNKNOWN:
                Log.d("MediaPlayer Error", "Media Error Unknown" + extra);
        }
        return false;
    }

    @Override
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {

    }

    @Override
    public void onSeekComplete(MediaPlayer mediaPlayer) {

    }

    @Override
    public void onAudioFocusChange(int focusState) {
        switch (focusState) {

            case AudioManager.AUDIOFOCUS_GAIN:
                if (mediaPlayer == null) {
                    initMediaPlayer();
                } else {
                    if (!mediaPlayer.isPlaying())
                        mediaPlayer.start();
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }
                break;


            case AudioManager.AUDIOFOCUS_LOSS:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                break;
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    break;
                }

            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                if (mediaPlayer.isPlaying()) mediaPlayer.setVolume(0.1f, 0.1f);
        }
    }

    private boolean reuestAudioFocus() {
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int result = audioManager.requestAudioFocus(this, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            return true;
        }
        return false;
    }

    private boolean removeAudioFocus() {
        return AudioManager.AUDIOFOCUS_REQUEST_GRANTED == audioManager.abandonAudioFocus(this);
    }

    private void playMedia() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    private void stopMedia() {
        if (mediaPlayer == null) return;
        ;
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }

    private void pauseMedia() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            resumePosition = mediaPlayer.getCurrentPosition();
        }
    }

    private void resumeMedia() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.seekTo(resumePosition);
            mediaPlayer.start();
        }
    }

    @Override
    public  void onDestroy(){
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.stop();
        }
        mediaPlayer.release();
        reuestAudioFocus();

        }




    public  class  LocalBinder extends Binder {
        public MediaPlayerService getService() {
            return MediaPlayerService.this;
        }
    }
}





