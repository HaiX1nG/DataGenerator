package com.datagenerator.dao;

import java.util.Date;

public class DataDao {
    private String Accessed;
    private Integer visits;

    public DataDao(String accessed, Integer visits) {
        Accessed = accessed;
        this.visits = visits;
    }

    public String getAccessed() {
        return Accessed;
    }

    public void setAccessed(String accessed) {
        Accessed = accessed;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }
}
