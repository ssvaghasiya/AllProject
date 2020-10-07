package com.example.vanda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vanda.admin.Admin;

public class Login extends AppCompatActivity {
EditText uname , passwd;
Button lgn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uname = findViewById(R.id.username);
        passwd = findViewById(R.id.password);
        lgn = findViewById(R.id.button_login);

        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uname.getText().toString().equals("admin") && passwd.getText().toString().equals("1998"))
                {
                    startActivity(new Intent(getApplicationContext(), Admin.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
