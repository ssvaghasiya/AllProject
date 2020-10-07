package com.example.shopkeeper.order_his;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopkeeper.R;
import com.example.shopkeeper.RetrofitClient;
import com.example.shopkeeper.ui.home.AdapterForHome;
import com.example.shopkeeper.ui.home.Model;
import com.example.shopkeeper.ui.models.Order_Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order_History extends AppCompatActivity {


    RecyclerView dataList;
    ArrayList<ModelForOrder> al;
    int ration;
    AdapterforOrder adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__history);
        ration=getIntent().getExtras().getInt("ration_id");

        dataList = findViewById(R.id.recyclerfororder);
//        Call<List<>>
//        Toast.makeText()

        Call<List<Order_Model>> call= RetrofitClient.getInstance().getApi().get_orders(ration);
        call.enqueue(new Callback<List<Order_Model>>() {
            @Override
            public void onResponse(Call<List<Order_Model>> call, Response<List<Order_Model>> response) {
                al = new ArrayList<>();
                List<Order_Model> list=response.body();
                for(Order_Model obj:list) {
                    Date d = obj.getCreated_at();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String sb = formatter.format(d);
                                    al.add(new ModelForOrder(obj.getId(),sb,obj.getTotal_bill(),obj.getTotal_quantity()));
                }
//                String sb=d.toString();


//                al.add(new ModelForOrder(1,"1-1-20"));

                adapter = new AdapterforOrder(getApplicationContext(),al);

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,GridLayoutManager.VERTICAL,false);
                dataList.setLayoutManager(gridLayoutManager);
                dataList.setAdapter(adapter);
//                Toast.makeText(getApplicationContext(),sb,Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<List<Order_Model>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

//        Date d=new Date(2020,1,1);



    }
}
