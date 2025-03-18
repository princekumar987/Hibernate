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
		   
		   

	}

	private static void delete(SessionFactory sf) {
		
	}

	public static void update(SessionFactory sf) {
		
	}
	
	public static void read(SessionFactory sf) {
		
		Session session=sf.openSession();
		
		String sql="select * from employee";
		NativeQuery nq= session.createNativeQuery(sql);
		
		nq.addEntity(Employee.class);
		List<Employee>list=nq.getResultList();
		
		for(Employee e:list) {
			System.out.println(e);
		}
		
//		List ResultSet=nq.getResultList();
		
//		List<Object[]>list=nq.getResultList();
//		
//		for(Object[]o:list) {
//			for(Object e:o) {
//				System.out.println(e);
//			}
//			System.out.println();
//		}
		
		
		
		
		
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
		   
		   String sql="insert into employee(eid,ename,eaddress,esalary) values (:eid,:ename,:eaddress,:esalary)";
		   
		   NativeQuery nq= session.createNativeQuery(sql);
		   nq.setParameter("eid", eid);
		   nq.setParameter("ename", ename);
		   nq.setParameter("eaddress", eaddress);
		   nq.setParameter("esalary", esalary);
		   
		   int row=nq.executeUpdate();
		   
		   trs.commit();
		   
		   System.out.println(row);
		   
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
