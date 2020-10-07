package com.example.demoapp2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle: Bundle = intent.extras
        val msg =  bundle.getString("user")
//        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()

        val ms = intent.extras.getString("user").toString()
       Toast.makeText(this,ms,Toast.LENGTH_SHORT).show()
    }

}