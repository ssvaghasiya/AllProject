package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.core.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

   RecyclerView dataList;
   List<String> titles;
   List<Integer> images;

   Adapter adapter;
    TextView mtxt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dataList = (RecyclerView)findViewById(R.id.dataList);






//         mtxt = (TextView) findViewById(R.id.text);
//
//        Typeface face1 = Typeface.createFromAsset(getAssets(),
//
//                "shruti.ttf");
//
//        mtxt.setTypeface(face1);



        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("ગેલેરી");
        titles.add("ગામ ના સભ્યો");
        titles.add("જાહેરાત");
        titles.add("અગત્યના નંબર");
        titles.add("ગેલેરી");
        titles.add("ગામ ના સભ્યો");
        titles.add("જાહેરાત");
        titles.add("અગત્યના નંબર");


        images.add(R.drawable.gallaryg);
        images.add(R.drawable.gallaryga);
        images.add(R.drawable.jaherat);
        images.add(R.drawable.book);
        images.add(R.drawable.gallaryg);
        images.add(R.drawable.gallaryga);
        images.add(R.drawable.jaherat);
        images.add(R.drawable.book);


        adapter = new Adapter(this,titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);



    }

}
