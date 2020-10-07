package com.example.shopkeeper.order_his;

public class ModelForOrder {

    int id;
    String date;
    int bill,quantity;

    public ModelForOrder(int id, String date, int bill, int quantity) {
        this.id = id;
        this.date = date;
        this.bill = bill;
        this.quantity = quantity;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
