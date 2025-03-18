package com.main;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class Education {
    
	@Column(name="myroll" , unique = true)
    private int roll;
    private String clgname;
    private String subject;

    // Non-parameterized constructor
    public Education() {
    }

    // Parameterized constructor
    public Education(int roll, String clgname, String subject) {
    	super();
        this.roll = roll;
        this.clgname = clgname;
        this.subject = subject;
    }

    // Getters
    public int getRoll() {
        return roll;
    }

    public String getClgname() {
        return clgname;
    }

    public String getSubject() {
        return subject;
    }

    // Setters
    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setClgname(String clgname) {
        this.clgname = clgname;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // toString method
    @Override
    public String toString() {
        return "Education{" +
                "roll=" + roll +
                ", clgname='" + clgname + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
