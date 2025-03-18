package com.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Launch1 {

	public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       SessionFactory sf=getConnection();
		
		while(true) {
			
			
			System.out.println("p1->Insert\np2->Read\np3->Update->\np4->Delete\np5->InsertAndUpdate\np6->exit\nEnter Choice:--");
			
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
			    	  break;
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
		   
		   Employee emp=new Employee(eid,ename,eaddress,esalary);
		   
		    session.saveOrUpdate(emp);
		    trs.commit();
		   
		   
		   
		   session.close();
	}

	private static void delete(SessionFactory sf) {
		// TODO Auto-generated method stub
		
		Session session=sf.openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter eid");
		int eid=sc.nextInt();
		
		Employee emp=session.get(Employee.class, eid);
		Transaction trs=session.beginTransaction();
		
		if(emp!=null) {
			 session.delete(emp);
			 trs.commit();
			 System.out.println("data deleetd");
		}
		else {
			System.out.println("not exist");
		}
		
		session.close();
		
	}

	public static void update(SessionFactory sf) {
	     Session session=sf.openSession();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter eid");
		int eid=sc.nextInt();
		
		System.out.println("enter youe new salary");
		int newsalary=sc.nextInt();
		Transaction trs=session.beginTransaction();
		
		Employee emp=session.get(Employee.class, eid);
		
		if(emp!=null) {
			 emp.setEsalary(newsalary);
			 session.update(emp);
			 System.out.println("updated");
			 trs.commit();
		}
		else {
			System.out.println("not exist");
		}
		
		session.close();
	}
	
	public static void read(SessionFactory sf) {
		Session session=sf.openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter eid");
		int eid=sc.nextInt();
		
		Employee emp=session.get(Employee.class, eid);
		
		if(emp!=null) {
			System.out.println(emp);
		}
		else {
			System.out.println("not exist");
		}
		
		session.close();
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
		   
		   Employee emp=new Employee(eid,ename,eaddress,esalary);
		   
		   int pk=(int) session.save(emp);
		   trs.commit();
		   
		   
		   
		   session.close();
		
	}
	
	public static SessionFactory getConnection() {
		
		   Configuration configuration =new Configuration ();
			configuration.configure();
			
			//setup ready
		   SessionFactory sessionFactory=configuration.buildSessionFactory();
		   
		   //now u perform crud (inbuilt connection)
		   
		   return sessionFactory;
		   
		 
		
	}

}
