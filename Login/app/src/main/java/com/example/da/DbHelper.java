package com.example.da;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, "register.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(email TEXT PRIMARY KEY,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists user");
        onCreate(db);
    }

    public boolean insert1(String email,String password)
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
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE email=?",new String[]{email});
        if(cursor.getCount()>0){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean checkmailpass(String email,String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
        if(c.getCount()>0)
        {
            return true;
        }
        else {
            return false;
        }
    }



}
