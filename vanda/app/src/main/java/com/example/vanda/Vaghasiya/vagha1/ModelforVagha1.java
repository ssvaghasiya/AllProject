package com.example.vanda.Vaghasiya.vagha1;

public class ModelforVagha1  {

    String name,mo_no,education,busines,relations;

    public ModelforVagha1(String name, String mo_no, String education, String busines, String relations) {
        this.name = name;
        this.mo_no = mo_no;
        this.education = education;
        this.busines = busines;
        this.relations = relations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMo_no() {
        return mo_no;
    }

    public void setMo_no(String mo_no) {
        this.mo_no = mo_no;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBusines() {
        return busines;
    }

    public void setBusines(String busines) {
        this.busines = busines;
    }

    public String getRelations() {
        return relations;
    }

    public void setRelations(String relations) {
        this.relations = relations;
    }
}
