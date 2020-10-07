package com.example.firebasefetch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        showData();
    }

    private void showData()
    {
        options = new FirebaseRecyclerOptions.Builder<Model>().setQuery(mDatabaseReference,Model.class).build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull Model model) {

                viewHolder.setDetails(getApplicationContext(),model.getTitle());
            }

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
