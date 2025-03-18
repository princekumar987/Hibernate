package com.main;

import java.util.Properties;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;



public class Launch1 {

	public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       SessionFactory sf=getConnection();
       
       Session session=sf.openSession();
       System.out.println(session);
		
		while(true) {
			
			
			System.out.println("p1->Insert->\np2->Read->\np3->Update->\np4->Delete->\np5->InsertAndUpdate->\np6->exit->\nEnter Choice:--");
			
			int choice=sc.nextInt();
			sc.nextLine();
			if(choice==6) {
				System.out.println("thanks for using");
				break;
			}
			
			switch(choice) {
			     case 1:
			    	    
			    	 
			    	 insert(sf);
			    	 break;
			    	 
			     case 2:
			    	 read(sf);
				     break;
				     
			     case 3:
			    	 update(sf);
			    	 break;
			    	
			     case 4:
			    	 
			    	 delete(sf);
			    	 break;
				     
			     case 5:
			    	 
			    	  saveandupdate(sf);
				 default:
					 
					 System.out.println("Enter valid choice");
					 break;
				
			}
		}
	 
	   

	}
	
	private static void saveandupdate(SessionFactory sf) {
		
		   Session session=sf.openSession();
		
		   Transaction trs=session.beginTransaction();
		   
		   
		   Scanner sc=new Scanner(System.in);
		   
		   System.out.println("Enter your Eid");
		   int eid=sc.nextInt();
		   System.out.println("Enter your Ename");
		   String ename=sc.next();
		   System.out.println("Enter your Eaddress");
		   String eaddress=sc.next();
		   System.out.println("Enter your Esalary");
		   int esalary=sc.nextInt();
		   
		   System.out.println("********* Enter Account Details********");
		   
		   System.out.println("Enter your Accountnumber");
		   int acc=sc.nextInt();
		   System.out.println("Enter your Bankname");
		   String bank=sc.next();
		   System.out.println("Enter your Amount");
		   int amount=sc.nextInt();
		   
		   Account account=new Account(acc,bank,amount);
		   
           System.out.println("********* Enter Education Details********");
		   
		   System.out.println("Enter your Rollnumber");
		   int roll=sc.nextInt();
		   System.out.println("Enter your Clgname");
		   String clgname=sc.next();
		   System.out.println("Enter your Subject");
		   String subject=sc.next();
		   
		   Education education=new Education(roll,clgname,subject);
		   
		   
		   Employee emp=new Employee(eid,ename,eaddress,esalary,account,education);
		   
		    session.saveOrUpdate(emp);
		   trs.commit();
		   
		    
		   session.close();
		
		
		  
	}

	private static void delete(SessionFactory sf) {
		
		Session session=sf.openSession();
		 
		Transaction trs=session.beginTransaction();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter your Eid");
		int eid=sc.nextInt();
		
		Employee emp=session.get(Employee.class, eid);
		if(emp!=null) {
			session.delete(emp);
			trs.commit();
			System.out.println("data deleted");
		}
		else {
			 System.out.println("Data not Exist");
		 }

		 
		
		
	}

	public static void update(SessionFactory sf) {
		
		 Session session=sf.openSession();
		 
		 Transaction trs=session.beginTransaction();
		 Scanner sc=new Scanner(System.in);
				
		   
		 System.out.println("Enter your Eid");
		 int eid=sc.nextInt();
		 
		 System.out.println("Enter youe salary");
		 int salry=sc.nextInt();
		 
		 
		 System.out.println("Enter your BankAmount");
		 int amount=sc.nextInt();
		 
		 System.out.println("Enter your newsubjectt");
		 String ewSubject=sc.next();
		 
		 Employee emp=session.get(Employee.class, eid);
		 
		 if(emp!=null) {
			 
			 
			 emp.setEsalary(salry);
			 emp.getEdu().setSubject(ewSubject);
			 emp.getAcc().setAmount(amount);
			 session.update(emp);
			 trs.commit();
			 
			 System.out.println("data updated");
			 
			 
		 }
		 else {
			 System.out.println("Data not Exist");
		 }
		
	    
	}
	
	public static void read(SessionFactory sf) {
		
		 Session session=sf.openSession();
		 Scanner sc=new Scanner(System.in);
		   
		 System.out.println("Enter your Eid");
		 int eid=sc.nextInt();
		 
		 Employee emp=session.get(Employee.class, eid);
		 
		 if(emp!=null) {
			 
			 System.out.println("************Employee all details**********");
			  
			 System.out.println(emp.getEid());
			 System.out.println(emp.getEname());
			 System.out.println(emp.getEaddress());
			 System.out.println(emp.getEsalary());
			 
			 System.out.println("******* Educations detainls*********");
			 
			 Education ed=emp.getEdu();
			 
			 System.out.println(ed.getRoll());
			 System.out.println(ed.getClgname());
			 System.out.println(ed.getSubject());
			 
			 System.out.println("************ Account details**********");
			 
			 Account ac= emp.getAcc();
			 
			 System.out.println(ac.getAccn());
			 System.out.println(ac.getAmount());
			 System.out.println(ac.getBankname());
			 
			 
			 
		 }
		 else {
			 System.out.println("Data Not Exist");
		 }
		
	}
	
	public static void insert (SessionFactory sf) {
		
		   Session session=sf.openSession();
			
		   Transaction trs=session.beginTransaction();
		   
		   
		   Scanner sc=new Scanner(System.in);
		   
		   System.out.println("Enter your Eid");
		   int eid=sc.nextInt();
		   System.out.println("Enter your Ename");
		   String ename=sc.next();
		   System.out.println("Enter your Eaddress");
		   String eaddress=sc.next();
		   System.out.println("Enter your Esalary");
		   int esalary=sc.nextInt();
		   
		   System.out.println("********* Enter Account Details********");
		   
		   System.out.println("Enter your Accountnumber");
		   int acc=sc.nextInt();
		   System.out.println("Enter your Bankname");
		   String bank=sc.next();
		   System.out.println("Enter your Amount");
		   int amount=sc.nextInt();
		   
		   Account account=new Account(acc,bank,amount);
		   
           System.out.println("********* Enter Education Details********");
		   
		   System.out.println("Enter your Rollnumber");
		   int roll=sc.nextInt();
		   System.out.println("Enter your Clgname");
		   String clgname=sc.next();
		   System.out.println("Enter your Subject");
		   String subject=sc.next();
		   
		   Education education=new Education(roll,clgname,subject);
		   
		   Employee emp=new Employee(eid,ename,eaddress,esalary,account,education);
		   
		   int pk=(int) session.save(emp);
		   trs.commit();
		   
		    
		   session.close();
	}
	
	public static SessionFactory getConnection() {
		   //load
		   Configuration configuration =new Configuration ();
		   
		   Properties properties=new Properties();
		   
		   properties.put(Environment.URL,"jdbc:mysql://localhost:3306/hibernate" );
		   properties.put(Environment.USER,"root" );
		   properties.put(Environment.PASS, "Prince@0717");
		   properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver" );
		   properties.put(Environment.HBM2DDL_AUTO, "update");
		   properties.put(Environment.SHOW_SQL,true );
		   properties.put(Environment.FORMAT_SQL,true );
		   
		   configuration.setProperties(properties);
		   configuration.addAnnotatedClass(Employee.class);
			
			
			//setup ready
		   SessionFactory sessionFactory=configuration.buildSessionFactory();
		   
		   //now u perform crud (inbuilt connection)
		   
		   return sessionFactory;
		   
		 
		
	}

}
