package com.example.rationuser.check;

public class ModelForCheckOut {

    String C_item;
    int C_quan;
    float C_price;

    public ModelForCheckOut(String c_item, int c_quan, float c_price) {
        C_item = c_item;
        C_quan = c_quan;
        C_price = c_price;
    }

    public String getC_item() {
        return C_item;
    }

    public void setC_item(String c_item) {
        C_item = c_item;
    }

    public int getC_quan() {
        return C_quan;
    }

    public void setC_quan(int c_quan) {
        C_quan = c_quan;
    }

    public float getC_price() {
        return C_price;
    }

    public void setC_price(float c_price) {
        C_price = c_price;
    }
}
