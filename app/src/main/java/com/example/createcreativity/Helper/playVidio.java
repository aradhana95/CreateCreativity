package com.example.createcreativity.Helper;

import android.content.Context;
import android.net.Uri;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import static android.provider.Settings.System.getString;

public class playVidio {
   /* SimpleExoPlayer simpleExoPlayer ;
    long playCurrentPosition;
    int currentWindow ;
    boolean playWhenReady ;
    Context context;
    private String status;
    private void initializePlayer(Context context,Uri uri) {
        this.context = context;
        if (simpleExoPlayer == null) {
            TrackSelector trackSelector = new DefaultTrackSelector();
             simpleExoPlayer =   ExoPlayerFactory.newSimpleInstance((RenderersFactory) this,trackSelector);
            simpleExoPlayer.setPlayWhenReady(true);

            MediaSource mediaSource =  buildMediaSource(Uri.parse(getString("")));
            simpleExoPlayer.prepare(mediaSource,true,false);
            simpleExoPlayer.addListener(new Player.EventListener() {
                @Override
                public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {

                }

                @Override
                public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

                }

                @Override
                public void onLoadingChanged(boolean isLoading) {

                }

                @Override
                public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                    switch (playbackState){

                        case simpleExoPlayer.STATE_BUFFERING :
                        case simpleExoPlayer.STATE_READY:
                        case simpleExoPlayer.STATE_IDLE:
                        case simpleExoPlayer.STATE_ENDED:

                    }

                }

                @Override
                public void onRepeatModeChanged(int repeatMode) {

                }

                @Override
                public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

                }

                @Override
                public void onPlayerError(ExoPlaybackException error) {

                }

                @Override
                public void onPositionDiscontinuity(int reason) {

                }

                @Override
                public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

                }

                @Override
                public void onSeekProcessed() {

                }
            });


        }

    }

    private MediaSource buildMediaSource(Uri uri)

    {
        if (uri.getLastPathSegment().contains("mp3") || uri.getLastPathSegment().contains("mp4")) {
            return new ExtractorMediaSource.Factory(new DefaultDataSourceFactory(context, Util.getUserAgent(context,"ExoPlayer")))
                    .createMediaSource(uri);
        }
    }


    private void releasePlayer() {
        if (simpleExoPlayer != null) {
           playCurrentPosition=  simpleExoPlayer.getCurrentPosition();
          currentWindow = simpleExoPlayer.getCurrentWindowIndex();
         playWhenReady =  simpleExoPlayer.getPlayWhenReady();
          simpleExoPlayer.release();
          simpleExoPlayer= null;

        }
    }*/
}
