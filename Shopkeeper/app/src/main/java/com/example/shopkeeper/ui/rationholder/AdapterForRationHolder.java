package com.example.shopkeeper.ui.rationholder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopkeeper.FamilyMem;
import com.example.shopkeeper.R;
import com.example.shopkeeper.familyforrh.FamilyForRH;
import com.example.shopkeeper.ui.viewremainstock.AdapterForViewRemain;
import com.example.shopkeeper.ui.rationholder.ModelForRationHolder;

import java.util.ArrayList;

public class AdapterForRationHolder extends RecyclerView.Adapter<AdapterForRationHolder.ViewHolder> {

    ArrayList<ModelForRationHolder> data;
    LayoutInflater inflater;
    Context ctx;

    public AdapterForRationHolder(Context ctx, ArrayList<ModelForRationHolder> data)
    {

        this.data = data;
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
    }
    @NonNull
    @Override
    public AdapterForRationHolder.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_ration_holder,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForRationHolder.ViewHolder holder, int position) {
        final ModelForRationHolder obj =data.get(position);
        holder.r_id.setText(String.valueOf(obj.getId()));
        holder.status.setText(String.valueOf(obj.getStatus()));

        if(holder.status.getText().equals("Not Available"))
        {
            holder.cardView.setCardBackgroundColor(Color.RED);
        }

        if(holder.status.getText().equals("Available")) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Intent i = new Intent(v.getContext(), FamilyForRH.class);
                    i.putExtra("id", obj.id);
                    ctx.startActivity(i);

            }
        });
    }
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView r_id,status;
        CardView  cardView;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            r_id = itemView.findViewById(R.id.ration_id);

            status = itemView.findViewById(R.id.status);
            cardView = itemView.findViewById(R.id.cardforrationholder);
        }
    }
}
