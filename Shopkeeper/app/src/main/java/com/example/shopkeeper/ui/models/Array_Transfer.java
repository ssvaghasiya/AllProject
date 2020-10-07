package com.example.shopkeeper.ui.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Array_Transfer {

    @SerializedName("items")
    @Expose
    private ArrayList<Transfer_Model> al;

    @SerializedName("mob")
    @Expose
    private String mob;


    public Array_Transfer(ArrayList<Transfer_Model> al,String mob) {
        this.al = al;
        this.mob=mob;
    }
}
