package com.example.shopkeeper.order_his.orderdetail;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopkeeper.R;
import com.example.shopkeeper.order_his.AdapterforOrder;
import com.example.shopkeeper.order_his.ModelForOrder;
import com.example.shopkeeper.orderindetail;

import java.util.ArrayList;

public class AdapterForOrderDetails extends RecyclerView.Adapter<AdapterForOrderDetails.ViewHolder>{

    ArrayList<ModelForOrderDetails> data;
    LayoutInflater inflater;
    Context ctx;

    public AdapterForOrderDetails(Context ctx, ArrayList<ModelForOrderDetails> data)
    {

        this.data = data;
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
    }
    @NonNull
    @Override
    public AdapterForOrderDetails.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_for_order_detail,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForOrderDetails.ViewHolder holder, int position) {
        final ModelForOrderDetails obj =data.get(position);
        holder.od_itemname.setText(obj.getOD_itemname());
        holder.od_quan.setText(String.valueOf(obj.getOD_quan()));
        holder.od_price.setText(String.valueOf(obj.getOD_price()));
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView od_itemname,od_quan,od_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            od_itemname = itemView.findViewById(R.id.Od_item);
            od_quan = itemView.findViewById(R.id.Od_quan);
            od_price = itemView.findViewById(R.id.Od_price);


        }
    }
}

