package com.example.createcreativity.HomeScreen.HomeLayouts;

import com.example.createcreativity.HomeScreen.HomeLayouts.NewsLayouts.NewsList;

import java.util.ArrayList;

public class HomeList {

    String layName;
    String[] newsArrayList;



    public HomeList(String layName, String[] newsArrayList  ) {
        this.layName = layName;
        this.newsArrayList = newsArrayList;


    }

    public String getlayName() {
        return layName;
    }

    public void setlayName(String layCatogaryName) {
        this.layName = layCatogaryName;
    }

    public String[] getNewsArrayList() {
        return newsArrayList;
    }

    public void setNewsArrayList(String[] newsArrayList) {
        this.newsArrayList = newsArrayList;
    }



}
