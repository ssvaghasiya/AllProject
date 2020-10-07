package com.example.fire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private Button send;
    private EditText key1;
    private EditText value1;

    private Firebase ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        ref = new Firebase("https://fireapp-82bf4.firebaseio.com/Users");

        send = (Button)findViewById(R.id.button);
        key1 = (EditText) findViewById(R.id.editText2);
        value1 =(EditText) findViewById(R.id.editText);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = key1.getText().toString();
                String val = value1.getText().toString();
                Firebase mref = ref.child(key);
                mref.setValue(val);
            }
        });
    }
}
