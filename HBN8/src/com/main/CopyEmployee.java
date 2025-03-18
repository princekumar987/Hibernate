package com.main;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class CopyEmployee {
	
	     @Id
	     private int eid;
		
	    private String ename;
		
	    private String eaddress;
		
	    private int esalary;
	    
	    public CopyEmployee(){
	    	
	    }

	    // Constructor
	    public CopyEmployee(int eid, String ename, String eaddress, int esalary) {
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
