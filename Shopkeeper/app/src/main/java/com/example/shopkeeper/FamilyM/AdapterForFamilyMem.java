package com.example.shopkeeper.FamilyM;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopkeeper.ModelForFamilyMem;
import com.example.shopkeeper.R;
import com.example.shopkeeper.order_his.AdapterforOrder;
import com.example.shopkeeper.order_his.ModelForOrder;
import com.example.shopkeeper.ui.viewremainstock.ModelForViewRemain;

import java.util.ArrayList;
import java.util.List;

public class AdapterForFamilyMem extends RecyclerView.Adapter<AdapterForFamilyMem.ViewHolder> {

    List<ModelForFamilyMem> data;
    LayoutInflater inflater;
    Context ctx;

    public AdapterForFamilyMem(Context ctx, List<ModelForFamilyMem> data)
    {

        this.data = data;
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
    }
    @NonNull
    @Override
    public AdapterForFamilyMem.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_for_familymem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForFamilyMem.ViewHolder holder, int position) {
        final ModelForFamilyMem obj =data.get(position);
        holder.F_Name.setText(obj.getName());
        holder.F_Number.setText(String.valueOf(obj.getAge()));


    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView F_Name,F_Number;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            F_Name = itemView.findViewById(R.id.f_name);
            F_Number = itemView.findViewById(R.id.f_ration_number);

        }
    }
}
