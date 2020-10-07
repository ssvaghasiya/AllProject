package com.example.vanda.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vanda.R;
import com.example.vanda.admin.ads.AdminAds;
import com.example.vanda.admin.glry.Admingalary;
import com.example.vanda.admin.impcon.AdminImpCon;
import com.example.vanda.admin.mem.AdminMem;

public class Admin extends AppCompatActivity {

    Button admads,admgal,admmem,admimpco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        admads = findViewById(R.id.adminads);
        admads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AdminAds.class));
            }
        });

        admgal = findViewById(R.id.admingallary);
        admgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Admingalary.class));
            }
        });

                admmem = findViewById(R.id.adminmem);
                admmem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), AdminMem.class));
                    }
                });

        admimpco =  findViewById(R.id.adminimportantco);
        admimpco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AdminImpCon.class));
            }
        });
    }
}
