package com.example.shopkeeper.ui.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Order_Array {

    @SerializedName("items")
    @Expose
    private ArrayList<Transfer_Model> al;

    @SerializedName("ration_id")
    @Expose
    private int ration_id ;


    @SerializedName("shop_id")
    @Expose
    private int shop_id ;

    public Order_Array(ArrayList<Transfer_Model> al, int ration_id, int shop_id) {
        this.al = al;
        this.ration_id = ration_id;
        this.shop_id = shop_id;
    }
}
