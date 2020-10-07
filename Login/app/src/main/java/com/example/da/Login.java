package com.example.da;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    DbHelper db = new DbHelper(this);
    Button login ;
    EditText email,pass;
    TextView reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button)findViewById(R.id.button2);
        email= (EditText)findViewById(R.id.editText4);
        pass = (EditText)findViewById(R.id.editText5);
        reg = (TextView)findViewById(R.id.textView);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = email.getText().toString();
                String s2 = pass.getText().toString();

                if(s1.equals("")||s2.equals("")) {
                    Toast.makeText(getApplicationContext(), "Field is empty", Toast.LENGTH_SHORT).show();
                }else {
                    boolean check = db.checkmailpass(s1, s2);

                    if (check == true) {
                        Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong email or Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




    }
}
