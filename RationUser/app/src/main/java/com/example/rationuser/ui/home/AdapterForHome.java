package com.example.rationuser.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rationuser.R;

import java.util.ArrayList;

public class AdapterForHome extends RecyclerView.Adapter<AdapterForHome.ViewHolder> {

    ArrayList<Model> data;
    LayoutInflater inflater;

    public AdapterForHome(Context ctx, ArrayList<Model> data)
    {

        this.data = data;
        this.inflater = LayoutInflater.from(ctx);

    }


    @NonNull
    @Override
    public AdapterForHome.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_for_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForHome.ViewHolder holder, int position) {
        final Model obj =data.get(position);
        holder.i_name.setText(obj.getItem_name());
        holder.quan.setText(String.valueOf(obj.getQuantity()));
        holder.price.setText(String.valueOf(obj.getPrice()));
        holder.req.setText(String.valueOf(obj.getRequire()));
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView i_name,quan,price;
        EditText req;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            i_name = itemView.findViewById(R.id.h_item);
            quan = itemView.findViewById(R.id.h_quan);
            price = itemView.findViewById(R.id.h_price);
            req = itemView.findViewById(R.id.h_require);
        }
    }
}
