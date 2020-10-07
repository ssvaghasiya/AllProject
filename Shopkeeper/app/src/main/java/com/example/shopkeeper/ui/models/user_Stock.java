package com.example.shopkeeper.ui.models;

public class user_Stock {
    int id;
    Item item_id;
    int quantity;

    public user_Stock(int id, Item item_id, int quantity) {
        this.id = id;
        this.item_id = item_id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem_id() {
        return item_id;
    }

    public void setItem_id(Item item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "user_Stock{" +
                "id=" + id +
                ", item_id=" + item_id +
                ", quantity=" + quantity +
                '}';
    }
}
