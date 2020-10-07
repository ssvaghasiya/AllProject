package com.example.shopkeeper.ui.slideshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopkeeper.R;
import com.example.shopkeeper.order_his.AdapterforOrder;
import com.example.shopkeeper.order_his.ModelForOrder;

import java.util.ArrayList;

public class AdapterForViewStock extends RecyclerView.Adapter<AdapterForViewStock.ViewHolder> {

    ArrayList<ModelForViewStock> data;
    LayoutInflater inflater;
    Context ctx;

    public AdapterForViewStock(Context ctx, ArrayList<ModelForViewStock> data)
    {

        this.data = data;
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
    }
    @NonNull
    @Override
    public AdapterForViewStock.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_for_viewstock,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForViewStock.ViewHolder holder, int position) {
        final ModelForViewStock obj =data.get(position);
        holder.V_item.setText(obj.getVitem_name());
        holder.V_quan.setText(String.valueOf(obj.getVquantity()));
        holder.V_remain.setText(String.valueOf(obj.getVremain()));
        holder.V_price.setText(String.valueOf(obj.getVprice()));


    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView V_item,V_quan,V_remain,V_price;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            V_item = itemView.findViewById(R.id.item_name);
            V_quan = itemView.findViewById(R.id.quantityforview);
            V_remain = itemView.findViewById(R.id.remainforview);
            V_price = itemView.findViewById(R.id.priceforview);
        }
    }
}
