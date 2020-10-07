package com.example.rationuser.ui.slideshow;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rationuser.R;
import com.example.rationuser.orderindetail;

import java.util.ArrayList;

public class AdapterforOrder extends RecyclerView.Adapter<AdapterforOrder.ViewHolder>{

    ArrayList<ModelForOrder> data;
    LayoutInflater inflater;
    Context ctx;

    public AdapterforOrder(Context ctx, ArrayList<ModelForOrder> data)
    {

        this.data = data;
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
    }
    @NonNull
    @Override
    public AdapterforOrder.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_ohistory,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterforOrder.ViewHolder holder, int position) {
        final ModelForOrder obj =data.get(position);
        holder.o_id.setText(String.valueOf(obj.getId()));
        holder.o_date.setText(obj.getDate());


        holder.dorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(v.getContext(), orderindetail.class);
             //   i.putExtra("id",obj.id);
                ctx.startActivity(i);
//                Toast.makeText(v.getContext(),"Order details",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView o_id,o_date;
        Button dorder;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            o_id = itemView.findViewById(R.id.order_id);
            o_date = itemView.findViewById(R.id.date);
            dorder = itemView.findViewById(R.id.btn_for_dorder);
        }
    }
}


