package com.example.shopkeeper.ui.viewremainstock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopkeeper.R;
import com.example.shopkeeper.ui.slideshow.AdapterForViewStock;
import com.example.shopkeeper.ui.slideshow.ModelForViewStock;

import java.util.ArrayList;
import java.util.List;

public class AdapterForViewRemain  extends RecyclerView.Adapter<AdapterForViewRemain.ViewHolder> {

    ArrayList<ModelForViewRemain> data;
    LayoutInflater inflater;
    Context ctx;

    public AdapterForViewRemain(Context ctx, ArrayList<ModelForViewRemain> data)
    {

        this.data = data;
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public AdapterForViewRemain.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_for_viewremain,parent,false);
        return new AdapterForViewRemain.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ModelForViewRemain obj =data.get(position);
        holder.VR_item.setText(obj.getItem_name());

        holder.VR_remain.setText(String.valueOf(obj.getRemain()));
        holder.VR_price.setText(String.valueOf(obj.getPrice()));
    }



    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView VR_item,VR_remain,VR_price;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            VR_item = itemView.findViewById(R.id.vrit_name);

            VR_remain = itemView.findViewById(R.id.vr_remain);
            VR_price = itemView.findViewById(R.id.vr_price);
        }
    }
}
