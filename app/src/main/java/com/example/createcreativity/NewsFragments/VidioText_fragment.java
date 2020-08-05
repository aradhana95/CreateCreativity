package com.example.createcreativity.NewsFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.ViewFlipper;

import com.example.createcreativity.FragmentActionListener;
import com.example.createcreativity.R;
import com.example.createcreativity.TxtSlidePresentation;

import butterknife.BindView;
import butterknife.ButterKnife;


public class VidioText_fragment extends Fragment {
    Context context;
    @BindView(R.id.view_flipper1)
    ViewFlipper viewFlipper;
    @BindView(R.id.vidio_view1)
    VideoView videoView;
    FragmentActionListener fragmentActionListener;


    public VidioText_fragment() {
    }

    public VidioText_fragment(Context context) {
        this.context = context;

    }
    public void setFragmentActionListener(FragmentActionListener fragmentActionListener) {
        this.fragmentActionListener = fragmentActionListener;
    }


  /*  public static VidioText_fragment newInstance(String param1, String param2) {
        VidioText_fragment fragment = new VidioText_fragment();
        Bundle args = new Bundle();
       *//* args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;*//*
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initUI();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vidio_text_fragment, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void initUI() {
        ButterKnife.bind((TxtSlidePresentation) context);


        int[] images = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background};
        for (int image : images) {
            viewFlipping(image);
        }
    }
    public void viewFlipping(int image) {
        ImageView imageView = new ImageView(context);
        viewFlipper.addView(imageView);
        imageView.setBackgroundResource(image);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setInAnimation(context, R.anim.move_in);
        //viewFlipper.setOutAnimation();}
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public  void playVidio(Uri vidioPath){
        MediaController mediaController = new MediaController(context);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.newsvidio));
        videoView.requestFocus();
        videoView.start();
    }
}