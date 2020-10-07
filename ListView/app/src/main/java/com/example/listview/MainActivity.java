package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.lst);

        final ArrayList<String> places = new ArrayList<>();

        places.add("Surat");

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,places);

        listView.setAdapter(adapter);

    }
}
