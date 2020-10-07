package com.example.vanda.Vaghasiya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vanda.R;
import com.example.vanda.Vaghasiya.vagha1.Adapterforvagha1;
import com.example.vanda.Vaghasiya.vagha1.ModelforVagha1;

import java.util.List;

public class ViewHolder extends RecyclerView.Adapter<Adapterforvagha1.ViewHolder> {
        List<Model> titles;
        Context context;
        LayoutInflater inflater;

    public ViewHolder(Context ctx, List<ModelforVagha1> titles)
        {
            this.titles = titles;
            this.context = ctx;
            this.inflater = LayoutInflater.from(ctx);
        }

        @NonNull
        @Override
        public Adapterforvagha1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.custom_for_vagha1,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Adapterforvagha1.ViewHolder holder, final int position) {

            final ModelforVagha1 obj = titles.get(position);
            holder.title.setText(obj.getName());
            holder.mrela.setText(obj.getRelations());
            holder.mbusiness.setText(obj.getBusines());
            holder.meducation.setText(obj.getEducation());
        }

        @Override
        public int getItemCount() {
            return this.titles.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView title,mrela,mbusiness,meducation;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.mname);
                mrela = itemView.findViewById(R.id.relation);
                mbusiness = itemView.findViewById(R.id.business);
                meducation = itemView.findViewById(R.id.edu);

            }
        }

}
