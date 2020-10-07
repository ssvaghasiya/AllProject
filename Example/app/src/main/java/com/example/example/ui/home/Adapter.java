package com.example.example.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.example.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<String> titles;
    Context context;
    LayoutInflater inflater;

    public Adapter(Context ctx, List<String> titles)
    {
        this.titles = titles;
        this.context = ctx;
        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_for_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, final int position) {
        holder.title.setText(titles.get(position));


    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.quan);

        }
    }
}
