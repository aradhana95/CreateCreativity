package com.example.createcreativity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TxtSlidePresentation extends AppCompatActivity implements  FragmentActionListener {


    @BindView(R.id.img_lay1)
    ImageView img_lay1;
    @BindView(R.id.img_lay2)
    ImageView img_lay2;
    @BindView(R.id.img_lay3)
    ImageView img_lay3;
    @BindView(R.id.img_lay4)
    ImageView img_lay4;
    @BindView(R.id.img_lay5)
    ImageView img_lay5;

    @BindView(R.id.music_lay)
    LinearLayout musivLayout;
    @BindView(R.id.music_list)
    ImageButton music_list;
    @BindView(R.id.record_aud)
    ImageButton rec_audio;
    @BindView(R.id.music_bar)
    LinearLayout musicBar;
    @BindView(R.id.music_name)
    ImageView music_symbol;
    @BindView(R.id.music_seekbar)
    SeekBar music_seekbar;

    @BindView(R.id.fragment_container)
    FrameLayout fragment_container;

    @BindView(R.id.txt_img_lay)
     LinearLayout txtImageLayout;


    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FragmentActionListener fragmentActionListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txt_slide_presentation);
        initialization();
        startViewFlipper(this);
       // MediaPlayer mediaPlayer =   MediaPlayer.create(this,);
        //mediaPlayer.start();



        img_lay1.setOnClickListener(v -> { onClicklistener(this,1); });
        img_lay2.setOnClickListener(v -> { onClicklistener(this,2); });
        img_lay3.setOnClickListener(v -> { onClicklistener(this,3); });
        img_lay4.setOnClickListener(v -> { onClicklistener(this,4); });
        img_lay5.setOnClickListener(v -> { onClicklistener(this,5); });

        music_list.setOnClickListener(view -> {onClicklistener(this,6);});

    }

    public void initialization() {
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        fragmentActionListener = (TxtSlidePresentation)this;
    }

    public  void  startViewFlipper(Context context){
        fragmentTransaction = fragmentManager.beginTransaction();
        ViewFlipperFragment viewFlipperFragment =  new ViewFlipperFragment(this);
        Bundle bundle = new Bundle();
      //  bundle.putC(FragmentActionListener.LAYYOUT_SELECTED,context);
        viewFlipperFragment.setArguments(bundle);
        viewFlipperFragment.setFragmentActionListener(this);
        fragmentTransaction.add(R.id.fragment_container,viewFlipperFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }



    public void onClicklistener(Context context, int id ){
        switch (id)
{
    case 1: case 2: case 3: case 4:case 5 : fragmentTransaction = fragmentManager.beginTransaction();
                                            EditTextVidFragment editTextVidFragment = new EditTextVidFragment(context);
                                            editTextVidFragment.setFragmentActionListener(this);
                                            Bundle bundle = new Bundle();
                                            bundle.putInt(FragmentActionListener.LAYYOUT_SELECTED,id);
                                            editTextVidFragment.setArguments(bundle);
                                            fragmentTransaction.replace(R.id.txt_vid_parent,editTextVidFragment);
                                            fragmentTransaction.addToBackStack(null);
                                            fragmentTransaction.commit();
                                            break;
                                   case 6:  fragment_container.setVisibility(View.GONE);
                                            musivLayout.setVisibility(View.GONE);
                                            txtImageLayout.setVisibility(View.GONE);
                                            fragmentTransaction = fragmentManager.beginTransaction();
                                            MusicListFragment musicListFragment = new MusicListFragment(context);
                                            musicListFragment.setFragmentActionListener(this);
                                            Bundle bundle1 = new Bundle();
                                            fragmentTransaction.add(R.id.music_list_fragment,musicListFragment);
                                            fragmentTransaction.addToBackStack(null);
                                            fragmentTransaction.commit();
                                            break;


}

    }

   /* public void Intent(int requestCode){
        if (requestCode == 10)
       { Intent intent = new Intent(this,EditTxtVidLayot.class);
        startActivityForResult(intent,requestCode);}
    }*/


    @Override
    public void onSelectedLayout(Context context) {

    }

    @Override
    public   void IntentListener(int requstCode) {
        switch (requstCode){
            case 221: Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak");
                try   {
                    startActivityForResult(intent,requstCode);

                }catch (ActivityNotFoundException a){
                    Toast.makeText(this,"Unsupported device",Toast.LENGTH_LONG).show();
                } } }

    @Override
    public void data(Intent  data) {
        ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        switch (requestCode){
            case 221:{
                if (resultCode  == RESULT_OK && data != null) {
                    fragmentActionListener.data(data);
                   // write.setText(result.get(0));
                }
                break;
            }
        }
    }
}
//q