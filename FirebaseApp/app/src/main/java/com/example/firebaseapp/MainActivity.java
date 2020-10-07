package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        editText = (EditText)findViewById(R.id.editText);
//        button = (Button)findViewById(R.id.button);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference();





    }

    public void  runCode(View view)
    {
        String data =  editText.getText().toString();

        reference.setValue(data);

        Toast.makeText(getApplicationContext(),"Data Inserted...",Toast.LENGTH_SHORT).show();
    }
}
