package com.example.createcreativity.HomeScreen.HomeLayouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.createcreativity.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeScreen extends AppCompatActivity {
    @BindView(R.id.lay_recycler)
    RecyclerView layRecyclerView;
    ArrayList<HomeList> homeLists;
    String[] layNames;
    String[] newslayouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initUi();


    }

    public  void initUi(){
        ButterKnife.bind(this);
        layRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        homeLists= new ArrayList<HomeList>();

         layNames = getResources().getStringArray(R.array.layout_catogaries);
        Log.d("layNames","layNames"+layNames);
         newslayouts = getResources().getStringArray(R.array.lay_list);

         for(String layName:layNames){
             homeLists.add(new HomeList(layName,newslayouts));
         }

         HomeAdapter homeAdapter = new  HomeAdapter(this,homeLists);

        layRecyclerView.setAdapter(homeAdapter);

    }
}