package com.example.rationuser.ui.home;

public class Model  {

    String item_name;
    int quantity,require;
    float price;

    public Model(String item_name, int quantity, int require, float price) {
        this.item_name = item_name;
        this.quantity = quantity;
        this.require = require;
        this.price = price;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRequire() {
        return require;
    }

    public void setRequire(int require) {
        this.require = require;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
