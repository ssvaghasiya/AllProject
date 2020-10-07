package com.example.shopkeeper.ui.models;

public class Item {
    String item_name;
    float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Item(String item_name, float price) {
        this.item_name = item_name;
        this.price = price;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
}
