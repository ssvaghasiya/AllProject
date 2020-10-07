package com.example.shopkeeper.ui.slideshow;

public class ModelForViewStock {

    String vitem_name;
    int vquantity, vremain;
    float vprice;

    public ModelForViewStock(String vitem_name, int vquantity, int vremain, float vprice) {
        this.vitem_name = vitem_name;
        this.vquantity = vquantity;
        this.vremain = vremain;
        this.vprice = vprice;
    }

    public String getVitem_name() {
        return vitem_name;
    }

    public void setVitem_name(String vitem_name) {
        this.vitem_name = vitem_name;
    }

    public int getVquantity() {
        return vquantity;
    }

    public void setVquantity(int vquantity) {
        this.vquantity = vquantity;
    }

    public int getVremain() {
        return vremain;
    }

    public void setVremain(int vremain) {
        this.vremain = vremain;
    }

    public float getVprice() {
        return vprice;
    }

    public void setVprice(float vprice) {
        this.vprice = vprice;
    }
}

