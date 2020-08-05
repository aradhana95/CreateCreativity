package com.example.createcreativity.HomeScreen.HomeLayouts;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.createcreativity.HomeScreen.HomeLayouts.NewsLayouts.NewsAdapter;
import com.example.createcreativity.HomeScreen.HomeLayouts.NewsLayouts.NewsList;
import com.example.createcreativity.R;
import com.example.createcreativity.VidioAdapter;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class HomeAdapter  extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    Context context;
    ArrayList<HomeList> homeList;
    ArrayList<NewsList> newsArrayList;

    public HomeAdapter(Context context,  ArrayList<HomeList> homeList){
        this.context= context;
        this.homeList = homeList;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_layout_adapter,parent,false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      HomeList  homeListItem = homeList.get(position);
      String catogaryName = homeListItem.getlayName();
        String[] newsListArray = homeListItem.getNewsArrayList();
        newsArrayList = new ArrayList<NewsList>();

        holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder.recyclerView.getContext(),LinearLayoutManager.HORIZONTAL,false));

        Log.d("newslayouts","newslayouts"+newsListArray);

        for (String newsItem:newsListArray){
           newsArrayList.add(new NewsList(newsItem)) ;
            Log.d("newsItem","newsItem"+newsItem);

        }




        Log.d("layoutViews","layoutViews"+newsArrayList);

        NewsAdapter newsAdapter = new NewsAdapter(context,newsArrayList);
        holder.recyclerView.setAdapter(newsAdapter);
        holder.recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());



    }



    @Override
    public int getItemCount() {
        return homeList.size();
    }

    public  static  class ViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        TextView catogaryTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.home_recycler);
            catogaryTv =  itemView.findViewById(R.id.catogary_name);
        }
    }


}
