package com.example.shopkeeper.order_his.orderdetail;

public class ModelForOrderDetails {

    String OD_itemname;
    int OD_quan;
    float OD_price;

    public ModelForOrderDetails(String OD_itemname, int OD_quan, float price) {
        this.OD_itemname = OD_itemname;
        this.OD_quan = OD_quan;
        this.OD_price = price;
    }

    public String getOD_itemname() {
        return OD_itemname;
    }

    public void setOD_itemname(String OD_itemname) {
        this.OD_itemname = OD_itemname;
    }

    public int getOD_quan() {
        return OD_quan;
    }

    public void setOD_quan(int OD_quan) {
        this.OD_quan = OD_quan;
    }

    public float getOD_price() {
        return OD_price;
    }

    public void setOD_price(float OD_price) {
        this.OD_price = OD_price;
    }
}
