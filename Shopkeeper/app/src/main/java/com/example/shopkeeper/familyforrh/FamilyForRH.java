package com.example.shopkeeper.familyforrh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.shopkeeper.FamilyM.AdapterForFamilyMem;
import com.example.shopkeeper.ModelForFamilyMem;
import com.example.shopkeeper.R;

import java.util.ArrayList;

public class FamilyForRH extends AppCompatActivity {
    RecyclerView dataList;
    ArrayList<ModelForFamilyRH> al;
    AdapterForFamilyRH adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_for_r_h);


        dataList = findViewById(R.id.recyclerviewforfamilyrh);
        al = new ArrayList<>();
        al.add(new ModelForFamilyRH("Harshit",21345655));

        adapter = new AdapterForFamilyRH(getApplicationContext(),al);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);

        long id = getIntent().getExtras().getLong("id");
        Toast.makeText(getApplicationContext(),"ID "+String.valueOf(id),Toast.LENGTH_LONG).show();
    }
}
