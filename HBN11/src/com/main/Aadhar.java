package com.main;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="aadhar")
public class Aadhar {
    @Id
    @Column(name="aadharNo")
    private int aadharNo;

    @Column(name="aadharName")
    private String aadharName;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="pid")
    private Player player;
    

    // Constructors
    public Aadhar() {
    }

    public Aadhar(int aadharNo, String aadharName) {
        this.aadharNo = aadharNo;
        this.aadharName = aadharName;
    }

    // Getters and Setters
    
    
    public Player getPlayer() {
    	return player;
    }
    
    public void setPlayer(Player player) {
    	this.player=player;
    }
    public int getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(int aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getAadharName() {
        return aadharName;
    }

    public void setAadharName(String aadharName) {
        this.aadharName = aadharName;
    }

    // toString Method
   
}
