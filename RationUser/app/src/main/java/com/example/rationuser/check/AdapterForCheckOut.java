package com.example.rationuser.check;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rationuser.R;

import java.util.ArrayList;

public class AdapterForCheckOut extends RecyclerView.Adapter<AdapterForCheckOut.ViewHolder>{

    ArrayList<ModelForCheckOut> data;
    LayoutInflater inflater;
    Context ctx;

    public AdapterForCheckOut(Context ctx, ArrayList<ModelForCheckOut> data)
    {

        this.data = data;
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
    }
    @NonNull
    @Override
    public AdapterForCheckOut.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_checkout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForCheckOut.ViewHolder holder, int position) {
        final ModelForCheckOut obj =data.get(position);
        holder.od_itemname.setText(obj.getC_item());
        holder.od_quan.setText(String.valueOf(obj.getC_quan()));
        holder.od_price.setText(String.valueOf(obj.getC_price()));
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView od_itemname,od_quan,od_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            od_itemname = itemView.findViewById(R.id.c_item);
            od_quan = itemView.findViewById(R.id.c_quan);
            od_price = itemView.findViewById(R.id.c_price);


        }
    }
}

