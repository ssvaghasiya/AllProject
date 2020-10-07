package com.example.firebasefetchh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    RecyclerView mrecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;
    FirebaseRecyclerAdapter<Model,ViewHolder> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<Model> options;
    LinearLayoutManager linearLayoutManager;
    Button callk;
    String sNUm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        mrecyclerView = findViewById(R.id.recyclerview);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("Data");
        callk = findViewById(R.id.call);
        showData();
    }



    private void showData()
    {
        options = new FirebaseRecyclerOptions.Builder<Model>().setQuery(mDatabaseReference,Model.class).build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull final Model model) {

                viewHolder.setDetails(getApplicationContext(),model.getNumber());

//                callk.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent i = new Intent(Intent.ACTION_CALL);
//                        sNUm = String.valueOf(model.getNumber());
//                        i.setData(Uri.parse("tel:"+sNUm));
//                        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
//                            Toast.makeText(MainActivity.this,"please grant permission",Toast.LENGTH_LONG).show();
//                            requestPermission();
//                        }
//                        else {
    //                        startActivity(i);
//                        }
//
      //              }
//
//
  //             });
            }
//            private void requestPermission(){
//                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
//            }
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);

                ViewHolder viewHolder = new ViewHolder(itemView);
                viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        Toast.makeText(MainActivity.this,"Hello"+position,Toast.LENGTH_LONG).show();

//                        if(position == 0)
//                        {
//                            Intent i = new Intent(MainActivity.this,Savan.class);
//                            startActivity(i);
//                        }
                    }

                    @Override
                    public void onItemLongClick(View v, int position) {
                        Toast.makeText(MainActivity.this,"Long Click",Toast.LENGTH_LONG).show();
                    }
                });
                return viewHolder;
            }
        };
        mrecyclerView.setLayoutManager(linearLayoutManager);
        firebaseRecyclerAdapter.startListening();
        mrecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    protected void onStart()
    {
        super.onStart();

        if(firebaseRecyclerAdapter != null)
        {
            firebaseRecyclerAdapter.startListening();
        }
    }
}
