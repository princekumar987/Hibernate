package com.main;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Player {
	
	@Id
    private int pid;
    private String pname;

    // Constructor
    public Player() {
    }

    public Player(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
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

    // toString Method
    @Override
    public String toString() {
        return "Player{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
