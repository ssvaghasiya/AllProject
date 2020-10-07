package com.example.loginapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    TextView txt;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          et1 = (EditText)findViewById(R.id.editText);
          et2 = (EditText)findViewById(R.id.editText2);
          txt = (TextView)findViewById(R.id.txtv);
         button = (Button)findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



               // txt.setText(str + str1);
              if(et2.getText().toString().equals("admin") && et1.getText().toString().equals("admin"))
               {
//                    txt.setText("Successfull Login");
//                    txt.setTextColor(Color.GREEN);
                    Toast.makeText(getApplicationContext(),"SuccessFull Login",Toast.LENGTH_SHORT).show();
                }
                else {
//                    txt.setText("Incorrect UserName or Password");
//                    txt.setTextColor(Color.RED);
                    Toast.makeText(getApplicationContext(),"Username And Password is Incorrect",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
