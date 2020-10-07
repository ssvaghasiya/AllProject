package com.example.vanda.Advertisepackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vanda.R;

import java.util.ArrayList;

public class AdapterforAds extends RecyclerView.Adapter<AdapterforAds.ViewHolder> {

    ArrayList<Integer> images;
    LayoutInflater inflater;

    public AdapterforAds(Context ctx, ArrayList<Integer> images)
    {

        this.images = images;
        this.inflater = LayoutInflater.from(ctx);

    }
    @NonNull
    @Override
    public AdapterforAds.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.cutomforgallary,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterforAds.ViewHolder holder, int position) {
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
