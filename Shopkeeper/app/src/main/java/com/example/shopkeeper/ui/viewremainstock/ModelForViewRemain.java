package com.example.shopkeeper.ui.viewremainstock;

public class ModelForViewRemain {

    String item_name;
    int remain;
    float price;

    public ModelForViewRemain(String item_name, int remain, float price) {
        this.item_name = item_name;
        this.remain = remain;
        this.price = price;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
