package com.example.shopkeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.shopkeeper.FamilyM.AdapterForFamilyMem;
import com.example.shopkeeper.order_his.AdapterforOrder;
import com.example.shopkeeper.order_his.ModelForOrder;
import com.example.shopkeeper.order_his.Order_History;
import com.example.shopkeeper.ui.home.Model;

import java.util.ArrayList;
import java.util.List;

public class FamilyMem extends AppCompatActivity {
    RecyclerView dataList;
    List<ModelForFamilyMem> al;
    AdapterForFamilyMem adapter;
    int ration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_mem);

       ration=getIntent().getExtras().getInt("ration_id");


        dataList = findViewById(R.id.recyclerviewforfamily);
//        al = new ArrayList<>();

        Call<List<ModelForFamilyMem>> call=RetrofitClient.getInstance().getApi().get_family(ration);
        call.enqueue(new Callback<List<ModelForFamilyMem>>() {
            @Override
            public void onResponse(Call<List<ModelForFamilyMem>> call, Response<List<ModelForFamilyMem>> response) {
                al=response.body();
                Toast.makeText(getApplicationContext(),al.toString(),Toast.LENGTH_LONG).show();
                adapter = new AdapterForFamilyMem(getApplicationContext(),al);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,GridLayoutManager.VERTICAL,false);
                dataList.setLayoutManager(gridLayoutManager);
                dataList.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ModelForFamilyMem>> call, Throwable t) {
Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


//        al.add(new ModelForFamilyMem("Harshit","Owner",20));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.oreder_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.order_action:
                Intent i = new Intent(getApplicationContext(), Order_History.class);
                i.putExtra("ration_id",ration);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
