package com.example.navigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    void messageSend(View v)
    {
        txt = (EditText)findViewById(R.id.editText);
        String val = txt.getText().toString();
        Intent intent = new Intent(this,Message.class);
        intent.putExtra("value",val);
        startActivity(intent);

    }



}
