package com.example.myapplication.Recy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Model> al;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recycler);
        al = new ArrayList<>();
        al.add(new Model("savan",123));

        adapter = new Adapter(getApplicationContext(),al);

        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(),1,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);







    }
}
