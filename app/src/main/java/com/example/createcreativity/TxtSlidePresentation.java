package com.example.createcreativity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TxtSlidePresentation extends AppCompatActivity {
    @BindView(R.id.view_animator)
    ViewFlipper viewFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txt_slide_presentation);
        initialization();

        int images[] = {R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background};
        for(int image:images){
            viewFlipping(image);
        }




    }
    public void initialization(){
        ButterKnife.bind(this);
    }

    public  void viewFlipping(int image){
        ImageView imageView = new ImageView(this);
        viewFlipper.addView(imageView);
        imageView.setBackgroundResource(image);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setInAnimation(this,R.anim.move_in);
        //viewFlipper.setOutAnimation();


    }
}