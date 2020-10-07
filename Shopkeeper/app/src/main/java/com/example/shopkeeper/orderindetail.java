package com.example.shopkeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class orderindetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderindetail);

        int id=getIntent().getExtras().getInt("id");
        Toast.makeText(getApplicationContext(),"Id"+String.valueOf(id),Toast.LENGTH_LONG).show();
    }
}
