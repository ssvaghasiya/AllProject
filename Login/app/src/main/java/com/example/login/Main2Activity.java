package com.example.login;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView txt;
    EditText edt;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = (Button)findViewById(R.id.button2);
        edt = (EditText)findViewById(R.id.editText);
        txt = (TextView)findViewById(R.id.textView2);
        Intent intent = getIntent();

        String uname = intent.getStringExtra("user");
        txt.setText(uname);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = edt.getText().toString();

                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent1);
            }
        });


    }
}
