package com.example.eration;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class stockdetail extends Fragment {

    View view;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//         setContentView(R.layout.activity_stockdetail);
//        super.onCreate(savedInstanceState);
//        super.onCreate(savedInstanceState);
//        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View contentView = inflater.inflate(R.layout.help,null,false);
//        mDrawer.addView(contentView,0);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.activity_stockdetail,container,false);
        return view;
    }
}
