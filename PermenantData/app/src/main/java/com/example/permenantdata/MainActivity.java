package com.example.permenantdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = this.getSharedPreferences("com.robpercival.sharedpreference", Context.MODE_PRIVATE);
        preferences.edit().putString("username","savan").apply();

        String username = preferences.getString("username","");

        Log.i("username",username);
    }
}
