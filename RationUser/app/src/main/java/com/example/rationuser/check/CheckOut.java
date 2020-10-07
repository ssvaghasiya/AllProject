package com.example.rationuser.check;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rationuser.R;
import com.example.rationuser.pay.Pay;

import java.util.ArrayList;

public class CheckOut extends AppCompatActivity {

    RecyclerView dataList;
    ArrayList<ModelForCheckOut> al;
    AdapterForCheckOut adapter;

    Button P2Pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        dataList = findViewById(R.id.recyclerforcheckout);
        al = new ArrayList<>();
        al.add(new ModelForCheckOut("rice",21,12.21f));


        adapter = new AdapterForCheckOut(getApplicationContext(),al);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);

        P2Pay = findViewById(R.id.p2pay);
        P2Pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Pay.class);
                startActivity(i);
            }
        });




    }
}