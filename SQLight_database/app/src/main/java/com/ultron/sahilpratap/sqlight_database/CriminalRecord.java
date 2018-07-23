package com.ultron.sahilpratap.sqlight_database;

public class CriminalRecord {

    int id;
    String name;
    String cases;
    String disc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public CriminalRecord(int id, String name, String cases, String disc) {
        this.id = id;
        this.name = name;
        this.cases = cases;
        this.disc = disc;
    }

    public CriminalRecord(){



    }
}
