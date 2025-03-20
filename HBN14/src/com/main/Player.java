package com.main;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="critriaplayer")
public class Player {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    @Column(name="name")
    private String pname;
    
    @Column(name="address")
    private String paddress;
    
 
   

  
    public Player( String pname, String address) {
    
        this.pname = pname;
        this.paddress = address;
    }
    
    public Player( int pid, String pname) {
        
        this.pid = pid;
        this.pname = pname;
    }
    
    public Player() {
    	
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
    

    public String getPaddress() {
        return pname;
    }

    public void setPaddress(String  paddress) {
        this.paddress=  paddress;
    }

   

    // toString Method
    
    @Override
    public String toString() {
        return "Player{" +
               "pid=" + pid +
               ", pname='" + pname + '\'' +
               ", paddress='" + paddress + '\'' +
               '}';
    }

   
    
   
}
