package com.example.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle", "oncreate");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "onstart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "onresume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "onDestroy invoked");
    }
}