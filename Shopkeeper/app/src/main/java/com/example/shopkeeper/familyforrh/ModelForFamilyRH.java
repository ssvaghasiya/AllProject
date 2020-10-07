package com.example.shopkeeper.familyforrh;

public class ModelForFamilyRH {

    String name;
    long ration_number;

    public ModelForFamilyRH(String name, long ration_number) {
        this.name = name;
        this.ration_number = ration_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRation_number() {
        return ration_number;
    }

    public void setRation_number(long ration_number) {
        this.ration_number = ration_number;
    }
}
