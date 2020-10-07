package com.example.shopkeeper.familyforrh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopkeeper.FamilyM.AdapterForFamilyMem;
import com.example.shopkeeper.ModelForFamilyMem;
import com.example.shopkeeper.R;

import java.util.ArrayList;

public class AdapterForFamilyRH extends RecyclerView.Adapter<AdapterForFamilyRH.ViewHolder> {

    ArrayList<ModelForFamilyRH> data;
    LayoutInflater inflater;
    Context ctx;

    public AdapterForFamilyRH(Context ctx, ArrayList<ModelForFamilyRH> data)
    {

        this.data = data;
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
    }
    @NonNull
    @Override
    public AdapterForFamilyRH.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_for_familymem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForFamilyRH.ViewHolder holder, int position) {
        final ModelForFamilyRH obj =data.get(position);
        holder.FRH_Name.setText(obj.getName());
        holder.FRH_Number.setText(String.valueOf(obj.getRation_number()));


    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView FRH_Name,FRH_Number;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            FRH_Name = itemView.findViewById(R.id.f_name);
            FRH_Number = itemView.findViewById(R.id.f_ration_number);

        }
    }
}
