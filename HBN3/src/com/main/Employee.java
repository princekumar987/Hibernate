package com.main;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="myComplexEmployee")  //optional
public class Employee {
    
	@Id
	@Column(name="id", unique = true, nullable = true)
    private int eid;
    private String ename;
    private String eaddress;
    private int esalary;
    
    @Embedded
    private Account acc;
    
    @Embedded
    private Education edu;

    // No-args constructor
    public Employee() {
    }

    // Parameterized constructor
    public Employee(int eid, String ename, String eaddress, int esalary, Account acc, Education edu) {
        this.eid = eid;
        this.ename = ename;
        this.eaddress = eaddress;
        this.esalary = esalary;
        this.acc = acc;
        this.edu = edu;
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

    public Account getAcc() {
        return acc;
    }

    public Education getEdu() {
        return edu;
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

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public void setEdu(Education edu) {
        this.edu = edu;
    }

    // toString method
    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", eaddress='" + eaddress + '\'' +
                ", esalary=" + esalary +
                ", acc=" + acc +
                ", edu=" + edu +
                '}';
    }
}
