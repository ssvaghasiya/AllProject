package com.example.vanda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.vanda.GallaryPhto.AdapterforGallary;
import com.example.vanda.ui.home.Adapter;

import java.util.ArrayList;

public class GallaryPhoto extends AppCompatActivity {
    RecyclerView dataList;

    ArrayList<Integer> images;

    AdapterforGallary adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary_photo);
        getSupportActionBar().setTitle("ગેલેરી");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dataList = findViewById(R.id.recycleforgallary);


        images = new ArrayList<>();




        images.add(R.drawable.nb);



        adapter = new AdapterforGallary(this,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);

    }
}
