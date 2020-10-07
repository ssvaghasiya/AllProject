package com.example.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, "reg.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }

    public boolean insert(String email,String password)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email",email);
        values.put("password",password);
        long i = database.insert("user",null,values);

        if(i==-1)
        {
            return false;
        }
        else {
            return true;
        }

    }

    public boolean checkmail(String email)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=?",new String[]{email});
        if(cursor.getCount()>0){
            return false;
        }
        else {
            return true;
        }
    }
}
