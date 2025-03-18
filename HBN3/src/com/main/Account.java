package com.main;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;


@Embeddable
public class Account {
    
	
	@Column(name="accnumber" , unique=true)
    private int accn;
    private String bankname;
    private int amount;

    // Non-parameterized constructor
    public Account() {
    }

    // Parameterized constructor
    public Account(int accn, String bankname, int amount) {
    	super();
        this.accn = accn;
        this.bankname = bankname;
        this.amount = amount;
    }

    // Getters
    public int getAccn() {
        return accn;
    }

    public String getBankname() {
        return bankname;
    }

    public int getAmount() {
        return amount;
    }

    // Setters
    public void setAccn(int accn) {
        this.accn = accn;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    // toString method
    @Override
    public String toString() {
        return "Account{" +
                "accn=" + accn +
                ", bankname='" + bankname + '\'' +
                ", amount=" + amount +
                '}';
    }
}
