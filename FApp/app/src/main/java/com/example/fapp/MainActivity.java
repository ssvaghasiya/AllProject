package com.example.fapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button send;
    EditText fname;
    EditText fnumber;
    Data data;
DatabaseReference databaseReference;
 //  private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Firebase.setAndroidContext(this);
      //  mRef = new Firebase("https://fapp-61053.firebaseio.com/Name");
        send = findViewById(R.id.button);
        fname = findViewById(R.id.name);
        fnumber = findViewById(R.id.number);
  //      setVal = findViewById(R.id.setval);
//        send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String key = keyed.getText().toString();
//                String value = valueed.getText().toString();
//                Firebase mchild = mRef.child(key);
//                mchild.setValue(value);
//            }
//        });

//        mRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String val = dataSnapshot.getValue(String.class);
//                setVal.setText(val);
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//                Toast.makeText(MainActivity.this,"Value Deleted",Toast.LENGTH_LONG).show();
//            }
//        });
        data = new Data();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Data");
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long phn = Long.parseLong(fnumber.getText().toString().trim());
                data.setName(fname.getText().toString().trim());
                data.setNumber(phn);
                databaseReference.child("1").setValue(data);
                Toast.makeText(MainActivity.this,"data inserted successfully",Toast.LENGTH_LONG).show();

            }
        });


    }
}
