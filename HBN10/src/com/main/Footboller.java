package com.main;

import javax.persistence.Entity;

@Entity
public class Footboller extends Player {
    private int fgoal;
    private String ftype;

    // Constructor
    public Footboller() {
    }

    public Footboller(int pid,String pname,int fgoal, String ftype) {
    	super(pid,pname);
        this.fgoal = fgoal;
        this.ftype = ftype;
    }

    // Getters and Setters
    public int getFgoal() {
        return fgoal;
    }

    public void setFgoal(int fgoal) {
        this.fgoal = fgoal;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    // toString Method
    @Override
    public String toString() {
        return "Footboller{" +
                "fgoal=" + fgoal +
                ", ftype='" + ftype + '\'' +
                '}';
    }
}