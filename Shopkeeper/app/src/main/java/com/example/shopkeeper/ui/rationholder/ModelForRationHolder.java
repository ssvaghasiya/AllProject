package com.example.shopkeeper.ui.rationholder;

public class ModelForRationHolder {
    long id;
    String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ModelForRationHolder(long id, String status) {
        this.id = id;
        this.status = status;


    }
}
