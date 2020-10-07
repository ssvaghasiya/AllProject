package com.example.vanda;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vanda.Vaghasiya.Vaghasiya;
import com.example.vanda.Vaghasiya.vagha1.Vaghasiya1;
import com.example.vanda.models.Surname_Model;

import java.util.List;

public class Adapterforsur extends RecyclerView.Adapter<Adapterforsur.ViewHolder> {
    List<Surname_Model> titles;
Context context;
    LayoutInflater inflater;

    public Adapterforsur(Context ctx, List<Surname_Model> titles)
    {
        this.titles = titles;
        this.context = ctx;
        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public Adapterforsur.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.customforsur,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterforsur.ViewHolder holder, final int position) {
        holder.title.setText(titles.get(position).getSurname());


        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(position == 0)
//                {

                    Intent i = new Intent(v.getContext(), Vaghasiya1.class);
                    i.putExtra("id",titles.get(position).getId());
                    Toast.makeText(context,String.valueOf(titles.get(position).getId()),Toast.LENGTH_LONG).show();
//                    context.startActivity(i);


            }
        });


    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_surname);


        }
    }
}
