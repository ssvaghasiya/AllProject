package com.example.shopkeeper.ui.home;

import com.example.shopkeeper.ui.models.user_Stock;

public class Model {

    user_Stock u1;
    int allocated;
   int requirement;

    public Model(user_Stock u1, int allocated, int requirement) {
        this.u1 = u1;
        this.allocated = allocated;
        this.requirement = requirement;
    }

    public int getAllocated() {
        return allocated;
    }

    public void setAllocated(int allocated) {
        this.allocated = allocated;
    }

    public user_Stock getU1() {
        return u1;
    }

    public void setU1(user_Stock u1) {
        this.u1 = u1;
    }

    public int getRequirement() {
        return requirement;
    }

    public void setRequirement(int requirement) {
        this.requirement = requirement;
    }

    public Model() {
    }

    @Override
    public String toString() {
        return "Model{" +
                "u1=" + u1 +
                ", allocated=" + allocated +
                ", requirement=" + requirement +
                '}';
    }
}
