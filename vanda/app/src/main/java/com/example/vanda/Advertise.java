package com.example.vanda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.vanda.Advertisepackage.AdapterforAds;

import java.util.ArrayList;

public class Advertise extends AppCompatActivity {

    RecyclerView dataList;

    ArrayList<Integer> images;

    AdapterforAds adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertise);
        getSupportActionBar().setTitle("જાહેરાત");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dataList = findViewById(R.id.recycleforAds);


        images = new ArrayList<>();




        images.add(R.drawable.nb);


        adapter = new AdapterforAds(this,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);

    }
}
