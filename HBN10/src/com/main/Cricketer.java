package com.main;

import javax.persistence.Entity;

@Entity
public class Cricketer extends Player {
    private int crun;
    private String ctype;

    // Constructor
    public Cricketer() {
    }

    public Cricketer(int pid,String pname,int crun, String ctype) {
    	super(pid,pname);
        this.crun = crun;
        this.ctype = ctype;
    }

    // Getters and Setters
    public int getCrun() {
        return crun;
    }

    public void setCrun(int crun) {
        this.crun = crun;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    // toString Method
    @Override
    public String toString() {
        return "Cricketer{" +
                "crun=" + crun +
                ", ctype='" + ctype + '\'' +
                '}';
    }
}