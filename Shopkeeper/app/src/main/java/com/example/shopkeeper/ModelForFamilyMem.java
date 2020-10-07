package com.example.shopkeeper;

public class ModelForFamilyMem {
    String name,relation;
    int age;

    @Override
    public String toString() {
        return "ModelForFamilyMem{" +
                "name='" + name + '\'' +
                ", relation='" + relation + '\'' +
                ", age=" + age +
                '}';
    }

    public ModelForFamilyMem(String name, String relation, int age) {
        this.name = name;
        this.relation = relation;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
