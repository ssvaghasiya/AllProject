package com.example.da;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DbHelper db = new DbHelper(this);
    EditText e1,p1,p2;
    Button reg;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1= (EditText)findViewById(R.id.editText);
        p1= (EditText)findViewById(R.id.editText3);
        p2= (EditText)findViewById(R.id.editText2);
        reg = (Button)findViewById(R.id.button);
        login = (TextView)findViewById(R.id.textView2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = p1.getText().toString();
                String s3 = p2.getText().toString();

                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Field is Eempty",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(s2.equals(s3)){
                        Boolean checkemail = db.checkmail(s1);
                        if(checkemail==true)
                        {
                            Boolean insert = db.insert1(s1,s2);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Registered Successsfully",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Email is Already exist",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_SHORT).show();
                    }
                    }
            }
        });
    }
}
