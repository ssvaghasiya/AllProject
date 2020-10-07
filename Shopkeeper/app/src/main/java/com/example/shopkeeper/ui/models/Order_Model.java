package com.example.shopkeeper.ui.models;

import java.util.Date;

public class Order_Model {

    int id,total_bill,total_quantity,method,user_id,region_id,history_id;
    Date created_at;

    public Order_Model(int id, int total_bill, int total_quantity, int method, int user_id, int region_id, int history_id, Date created_at) {
        this.id = id;
        this.total_bill = total_bill;
        this.total_quantity = total_quantity;
        this.method = method;
        this.user_id = user_id;
        this.region_id = region_id;
        this.history_id = history_id;
        this.created_at = created_at;



    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal_bill() {
        return total_bill;
    }

    public void setTotal_bill(int total_bill) {
        this.total_bill = total_bill;
    }

    public int getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
