package com.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="myemployee")  //optional

public class Employee {
	
	@Id
	@Column(name="id")
    private int eid;
	@Column(name="name",  length=30 , nullable=true)
    private String ename;
	@Column(name="address", unique = true)
    private String eaddress;
	@Column(name="salary")
    private int esalary;
    
    public Employee(){
    	
    }

    // Constructor
    public Employee(int eid, String ename, String eaddress, int esalary) {
        this.eid = eid;
        this.ename = ename;
        this.eaddress = eaddress;
        this.esalary = esalary;
    }

    // Getters
    public int getEid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }

    public String getEaddress() {
        return eaddress;
    }

    public int getEsalary() {
        return esalary;
    }

    // Setters
    public void setEid(int eid) {
        this.eid = eid;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setEaddress(String eaddress) {
        this.eaddress = eaddress;
    }

    public void setEsalary(int esalary) {
        this.esalary = esalary;
    }

    // toString method
    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", eaddress='" + eaddress + '\'' +
                ", esalary=" + esalary +
                '}';
    }
}