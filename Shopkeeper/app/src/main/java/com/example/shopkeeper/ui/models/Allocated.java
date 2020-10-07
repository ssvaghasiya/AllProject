package com.example.shopkeeper.ui.models;

public class Allocated {
    int Allocated;
    String name,phn;

    public Allocated(int allocated, String name, String phn) {
        Allocated = allocated;
        this.name = name;
        this.phn = phn;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAllocated() {
        return Allocated;
    }

    public void setAllocated(int allocated) {
        Allocated = allocated;
    }
}
