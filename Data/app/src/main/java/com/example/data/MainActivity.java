package com.example.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CpuUsageInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.text);


//        SQLiteDatabase database = dbHelper.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put("sid",1);
//        values.put("sname","savan");
//        values.put("marks","50");
//
//        long row = database.insert("student",null,values);
//
//        System.out.println("Number Of Row = "+row);
//
//        textView.setText("R="+row);

//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        String projection[] = {"sid","sname","marks"};
//
//        Cursor c = db.query("student",projection,null,null,null,null,null);
//
//        c.moveToFirst();
//
//        System.out.println("First row is : "+c.getString(1));

        StudntDbHelper dbHelper = new StudntDbHelper(this);



    }
}
