package com.main;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;



public class Launch1 {

	public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       SessionFactory sf=getConnection();
       
       Session session=sf.openSession();
       System.out.println(session);
		
		while(true) {
			
			
			System.out.println("p1->Copy->\np2->Read->\np3->Update->\np4->Delete->\np5->InsertAndUpdate->\np6->exit->\nEnter Choice:--");
			
			int choice=sc.nextInt();
			sc.nextLine();
			if(choice==6) {
				System.out.println("thanks for using");
				break;
			}
			
			switch(choice) {
			     case 1:
			    	    
			    	 
			    	 copy(sf);
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
			    	 
				 default:
					 
					 System.out.println("Enter valid choice");
					 break;
				
			}
		}
	 
	   

	}
	
	
	private static void delete(SessionFactory sf) {
		
		
	}

	public static void update(SessionFactory sf) {
		
	  
	}
	
	public static void read(SessionFactory sf) {
		
		
		Session session=sf.openSession();
		
		String hql="from Employee";
		
		Query query=session.createQuery(hql);
		
		List<Employee>list=query.list();
		
		for(Employee e:list) {
			System.out.println(e);
		}
	
	}
	
	public static void copy (SessionFactory sf) {
		
		
		Session session=sf.openSession();
		Transaction trs=session.beginTransaction();
		
		
		String HQL="insert into Employee(eid,ename,eaddress,esalary) select eid,ename,eaddress,esalary from CopyEmployee";
		Query query=session.createQuery(HQL);
		
		int row=query.executeUpdate();
		System.out.println(row);
		trs.commit();
		
		   
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
		   configuration.addAnnotatedClass(CopyEmployee.class);
		   
			
			
			//setup ready
		   SessionFactory sessionFactory=configuration.buildSessionFactory();
		   
		   //now u perform crud (inbuilt connection)
		   
		   return sessionFactory;
		   
		 
		
	}

}
