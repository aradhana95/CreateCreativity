package com.example.createcreativity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.speech.RecognizerIntent;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;


public class EditTextVidFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    @BindView(R.id.max_hint_tv)
    TextView text_hint;
    @BindView(R.id.audio_converter_ib)
    ImageButton audio_conv;
    @BindView(R.id.wrt_etv)
    EditText write;
    @BindView(R.id.ok_btn)
    Button ok_btn;

    // TODO: Rename and change types of parameters
    private Context context;
    private int id;
    private FragmentActionListener fragmentActionListener;

    public EditTextVidFragment() {
        // Required empty public constructor
    }
    public EditTextVidFragment(Context context){
        this.context = context;
        this.id= id;

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getInt(FragmentActionListener.LAYYOUT_SELECTED);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View viewInflated= inflater.inflate(R.layout.fragment_edit_txt_vid_layot, container, false);
        initialization(viewInflated);
        audio_conv.setOnClickListener(view -> { onClickListener(context,"audio_conv");});
        ok_btn.setOnClickListener(view -> { onClickListener(context,"ok_btn");});
        return viewInflated;
    }

    public void initialization(View view){
        ButterKnife.bind(this,view);
    }

    public  void setFragmentActionListener(FragmentActionListener fragmentActionListener){
        this.fragmentActionListener = fragmentActionListener;
    }








    public void onClickListener(Context context, String view){
        switch (view){

            case  "audio_conv": {
                if (fragmentActionListener!= null){
              fragmentActionListener. IntentListener(221);}
            }
           /* case "ok_btn":{
                Intent(211);
            }*/
        }
    }

    //Intents
  /*  public void Intent(int requestCode){
        switch (requestCode)
        {case 211: Intent intent1 = new Intent();
        Editable texts = write.getText();
        intent1.putExtra("text",texts);
        startActivity(intent1);}
    }*/

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        switch (requestCode){
            case 221:{
                if (resultCode  == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    write.setText(result.get(0));
                }
                break;
            }
        }
    }*/

    public void resultIntent(){

    }
}