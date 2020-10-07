package com.example.shopkeeper.checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shopkeeper.PopUp;
import com.example.shopkeeper.R;

public class CheckoutDetails extends AppCompatActivity {

    Button verify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_details);

        verify = findViewById(R.id.verification);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(), PopUp.class);
                startActivity(i);
            }
        });

    }
}
