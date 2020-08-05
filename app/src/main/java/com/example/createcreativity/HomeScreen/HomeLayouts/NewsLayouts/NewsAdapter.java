package com.example.createcreativity.HomeScreen.HomeLayouts.NewsLayouts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.createcreativity.FragmentActionListener;
import com.example.createcreativity.MusicListFragment;
import com.example.createcreativity.R;
import com.example.createcreativity.TxtSlidePresentation;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    Context context;
    ArrayList<NewsList> mlayoutViews;


    public NewsAdapter(Context context,ArrayList<NewsList> mlayoutViews){
        this.context = context;
        this.mlayoutViews = mlayoutViews;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layouts,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("mlayoutViews","mlayoutViews"+mlayoutViews);

        NewsList mlayoutView = mlayoutViews.get(position);
        Log.d("mlayoutView","mlayoutView"+mlayoutView);

        String mlayoutItem = mlayoutView.getLayoutView();
        holder.laynameTv.setText(mlayoutItem);
        Log.d("mlayoutItem","mlayoutItem"+mlayoutItem);


        holder.imageView.setOnClickListener(view -> {
            Intent intent = new Intent(context, TxtSlidePresentation.class);
            Bundle bundle =  new Bundle();
            bundle.putString("layout", mlayoutItem);
            intent.putExtras(bundle);
            context.startActivity(intent);


        });

    }



    @Override
    public int getItemCount() {
      int size =   mlayoutViews.size();
        Log.d("mlayoutSize","mlayoutSize"+mlayoutViews.size());
        return size;

    }

    public  static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView laynameTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.lay_img);
            laynameTv = itemView.findViewById(R.id.lay_name);
        }
    }
}
