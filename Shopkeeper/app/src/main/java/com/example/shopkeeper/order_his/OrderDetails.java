package com.example.shopkeeper.order_his;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.shopkeeper.R;
import com.example.shopkeeper.order_his.orderdetail.AdapterForOrderDetails;
import com.example.shopkeeper.order_his.orderdetail.ModelForOrderDetails;

import java.util.ArrayList;

public class OrderDetails extends AppCompatActivity {

    RecyclerView dataList;
    ArrayList<ModelForOrderDetails> al;
    AdapterForOrderDetails adapter;
    TextView od_id,od_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        dataList = findViewById(R.id.recyclerfororderdetail);
        al = new ArrayList<>();
        al.add(new ModelForOrderDetails("rice",21,12.21f));


        adapter = new AdapterForOrderDetails(getApplicationContext(),al);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);

        od_id = findViewById(R.id.OD_ID);
        od_date = findViewById(R.id.OD_Date);

        int  i = getIntent().getExtras().getInt("id");
        String d = getIntent().getExtras().getString("date");
        od_id.setText(String.valueOf(i));
        od_date.setText(d);
    }
}
