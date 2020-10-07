package com.example.vanda.Vaghasiya.vagha1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.vanda.Advertisepackage.AdapterforAds;
import com.example.vanda.R;

import java.util.ArrayList;
import java.util.List;

public class Vaghasiya1 extends AppCompatActivity {
    RecyclerView dataList;

    List<ModelforVagha1> images;

    Adapterforvagha1 adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaghasiya1);

        dataList = findViewById(R.id.recyclefordetail);

        int id1=getIntent().getExtras().getInt("id");
        Toast.makeText(getApplicationContext(),id1,Toast.LENGTH_LONG).show();


        images = new ArrayList<>();

        images.add(new ModelforVagha1("savan vaghasiya","7990558210","BE","student","self"));





        adapter = new Adapterforvagha1(this,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);

    }
}
