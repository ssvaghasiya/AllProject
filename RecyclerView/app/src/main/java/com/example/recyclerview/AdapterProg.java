package com.example.recyclerview;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterProg extends RecyclerView.Adapter<AdapterProg.progViewHolder> {

    String []data;

    public AdapterProg(String[] data ) {
        this.data = data;
    }

    @NonNull
    @Override
    public progViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View v = layoutInflater.inflate(R.layout.layout_recycle,viewGroup,false);
        return new  progViewHolder(v);
    }

    @Override
    public void onBindViewHolder(progViewHolder viewHolder, int i) {

        //progViewHolder viewHolder1 = new progViewHolder();
        String title = data[i];
        viewHolder.textView.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class progViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public progViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            textView = (TextView)itemView.findViewById(R.id.textView);
        }
    }
}
