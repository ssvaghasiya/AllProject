package com.example.androidphp;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUsername,editTextEmail,editTextPassword;
    private Button buttonRegister;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        editTextUsername = (EditText)findViewById(R.id.editTextUsername);

        buttonRegister = (Button)findViewById(R.id.buttonRegister);

        progressDialog = new ProgressDialog(this);
        buttonRegister.setOnClickListener(this);
    }

    private void registerUser(){
        String email = editTextEmail.getText().toString().trim();
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
            },
                    new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){


                }



        });
    }


    @Override
    public void onClick(View v) {
        if(v==buttonRegister)
        {
            registerUser();
        }
    }
}
