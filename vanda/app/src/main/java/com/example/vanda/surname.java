package com.example.vanda;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vanda.models.Surname_Model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class surname extends AppCompatActivity {
    RecyclerView dataList;
    List<Surname_Model> titles;


    Adapterforsur adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surname);
        getSupportActionBar().setTitle("ગામ ના સભ્યો");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dataList = findViewById(R.id.sur_recycle);
        titles = new ArrayList<>();


//        titles.add("વઘાસીયા પરિવાર");

Call<List<Surname_Model>>  call =RetrofitClient.getInstance().getApi().get_surnames();
call.enqueue(new Callback<List<Surname_Model>>() {
    @Override
    public void onResponse(Call<List<Surname_Model>> call, Response<List<Surname_Model>> response) {
        titles= response.body();

//        Toast.makeText(getApplicationContext(),l1.toString(),Toast.LENGTH_LONG).show();
//        for(Surname_Model m1 :l1)
//        {
//            titles.add(m1.getSurname());
//        }
        adapter = new Adapterforsur(getApplicationContext(),titles);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);



    }

    @Override
    public void onFailure(Call<List<Surname_Model>> call, Throwable t) {
        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
    }
});




    }
}
