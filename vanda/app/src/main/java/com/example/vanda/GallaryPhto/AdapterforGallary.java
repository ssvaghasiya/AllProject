package com.example.vanda.GallaryPhto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vanda.R;
import com.example.vanda.ui.home.Adapter;

import java.util.ArrayList;

public class AdapterforGallary extends RecyclerView.Adapter<AdapterforGallary.ViewHolder>{

    ArrayList<Integer> images;
    LayoutInflater inflater;

    public AdapterforGallary(Context ctx,ArrayList<Integer> images)
    {

        this.images = images;
        this.inflater = LayoutInflater.from(ctx);

    }

    @NonNull
    @Override
    public AdapterforGallary.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.cutomforgallary,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterforGallary.ViewHolder holder, int position) {

        holder.gridicon.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView gridicon;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            gridicon = itemView.findViewById(R.id.gallaryimg);

        }
    }
}
