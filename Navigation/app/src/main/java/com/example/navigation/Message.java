package com.example.navigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Message extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        txt = (TextView)findViewById(R.id.textView);
        Intent intent = getIntent();
       String Eval =  intent.getStringExtra("value");
        txt.setText(Eval);

    }
    void last(View v)
    {
        startActivity(new Intent(this,lastActivity.class));
    }
}
