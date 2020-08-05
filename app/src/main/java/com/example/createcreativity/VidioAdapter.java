package com.example.createcreativity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.createcreativity.Helper.VidioList;

import java.util.ArrayList;

public class VidioAdapter extends RecyclerView.Adapter<VidioAdapter.ViewHolder> {
    Context context;
    ArrayList<VidioList> vidioList;

    public VidioAdapter(Context context,ArrayList<VidioList> vidioList){
        this.context = context;
        this.vidioList = vidioList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.vidio_adapter,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VidioList vidioItem = vidioList.get(position);


    }

    @Override
    public int getItemCount() {
        return  vidioList.size();
    }

    public  static  class ViewHolder extends RecyclerView.ViewHolder{
        ImageView vidioImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vidioImage = itemView.findViewById(R.id.vidio_image);
        }
    }
}


