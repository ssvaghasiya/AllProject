package com.example.vanda.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vanda.Advertise;
import com.example.vanda.GallaryPhoto;
import com.example.vanda.ImportantCon;
import com.example.vanda.R;
import com.example.vanda.surname;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList<String> titles;
    ArrayList<Integer> images;
    LayoutInflater inflater;
    private Context context;
    public Adapter(Context ctx,ArrayList<String> titles, ArrayList<Integer> images)
    {
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);
        this.context = ctx;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_grid,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.title.setText(titles.get(position));
        holder.gridicon.setImageResource(images.get(position));


//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(),"click"+ position,Toast.LENGTH_LONG).show();
//            }
//        });

                holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 1)
                {
                    Intent i = new Intent(v.getContext(),surname.class);
                   context.startActivity(i);
                }
                else if(position == 0)
                {
                    Intent i = new Intent(v.getContext(),GallaryPhoto.class);
                    context.startActivity(i);
                }
                else if(position==2)
                {
                    Intent i = new Intent(v.getContext(),Advertise.class);
                    context.startActivity(i);
                }
                else if(position == 3)
                {
                    Intent i = new Intent(v.getContext(),ImportantCon.class);
                    context.startActivity(i);
                }
                else
                {
                    Toast.makeText(v.getContext(),"Under Construction",Toast.LENGTH_LONG).show();
                }
            }
        });


//        holder.gridicon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

//               Intent i = new Intent(v.getContext(),surname.class);
//                context.startActivity(i);
//            }
//        });
//        holder.title.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(v.getContext(),surname.class);
//                context.startActivity(i);
//            }
//        });
//
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(v.getContext(),surname.class);
//                context.startActivity(i);
//            }
//        });
  }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView gridicon;
        CardView cardView;

        public ViewHolder(@NonNull View itemView){

    super(itemView);
            title = itemView.findViewById(R.id.info);
            gridicon = itemView.findViewById(R.id.shareimg);
            cardView = itemView.findViewById(R.id.cardforhome);
    }
    }
}
