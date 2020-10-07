package com.example.vanda.models;

public class Surname_Model {

    int id;
    String surname;

    public Surname_Model(int id, String surname) {
        this.id = id;
        this.surname = surname;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Surname_Model{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                '}';
    }
}
