package com.example.vanda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ImportantCon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important_con);
        getSupportActionBar().setTitle("અગત્યના નંબર");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
