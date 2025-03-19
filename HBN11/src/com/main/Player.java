package com.main;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {
    @Id
    @Column(name="pid")
    private int pid;

    @Column(name="pname")
    private String pname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aadhar_no") // Ensure proper join column mapping
    private Aadhar aadhar;

    // Constructors
    public Player() {
    }

    public Player(int pid, String pname, Aadhar aadhar) {
        this.pid = pid;
        this.pname = pname;
        this.aadhar = aadhar;
    }

    // Getters and Setters
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Aadhar getAadhar() {
        return aadhar;
    }

    public void setAadhar(Aadhar aadhar) {
        this.aadhar = aadhar;
    }

    // toString Method
    
   
}
