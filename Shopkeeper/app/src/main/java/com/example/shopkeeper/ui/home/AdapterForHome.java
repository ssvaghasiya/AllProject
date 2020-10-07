package com.example.shopkeeper.ui.home;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopkeeper.R;

import java.util.ArrayList;

public class AdapterForHome extends RecyclerView.Adapter<AdapterForHome.ViewHolder> {
    ArrayList<Model> data;
    LayoutInflater inflater;
//    Model obj;

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
    public void onBindViewHolder(@NonNull final AdapterForHome.ViewHolder holder, final int position) {
        Model obj=data.get(position);
        holder.i_name.setText(obj.getU1().getItem_id().getItem_name());
        holder.quan.setText(String.valueOf(obj.getAllocated()));
        holder.req.setText(String.valueOf(obj.getRequirement()));

        holder.req.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    data.get(position).setRequirement(Integer.parseInt(s.toString()));
                }
                catch (Exception e)
                {
                    data.get(position).setRequirement(0);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView i_name,quan;
        EditText req;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            i_name = itemView.findViewById(R.id.it_name);
            quan = itemView.findViewById(R.id.quan);
            req = itemView.findViewById(R.id.require);
        }
    }
}
