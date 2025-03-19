package com.main;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;


@Entity
@Table(name="account")
public class Account {
    @Id
    @Column(name="accountno")
    private int accountno;

    @Column(name="accountName")
    private String accountName;
    
    @Column(name="acountAddress")
    private String accountaddress;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="pidaa")
    private Player player;
     

    // Constructors
    public Account() {
    }

    public Account(int accountno,String accountName,  String accountaddress) {
        this.accountno= accountno;
        this.accountName=accountName;
        this.accountaddress = accountaddress;
    }

    // Getters and Setters
    
    
    public int getAccountno() {
        return accountno;
    }

    public void setAccountno(int accountno) {
        this.accountno = accountno;
    }

    public String getAccountName() {
        return accountName;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    
    public String getAccountaddress() {
        return accountaddress;
    }

    public void setAccountAddress(String accountaddress) {
        this.accountaddress = accountaddress;
    }

    // toString Method
   
}
