package com.example.shopkeeper.ui.models;

import java.io.Serializable;

public class Transfer_Model implements Serializable {

    int id;
    String item_name;
    int quantity;
    float price;

    public Transfer_Model(int id, String item_name, int quantity, float price) {
        this.id = id;
        this.item_name = item_name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transfer_Model{" +
                "id=" + id +
                ", item_name='" + item_name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
