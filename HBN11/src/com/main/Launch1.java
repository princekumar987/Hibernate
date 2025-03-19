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
			
			
			System.out.println("p1->Insert->\np2->ReadFromPlayer->\np3->ReadFromAddhar->\np6->exit->\nEnter Choice:--");
			
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
			    	    
			    	 
			    	 readfromplayer(sf);
			    	 break; 
                  case 3:
			    	    
			    	 
			         readfromadhar(sf);
			    	 break; 	 
			    	 
				 default:
					 
					 System.out.println("Enter valid choice");
					 break;
				
			}
		}
	 
	   

	}
	
	
	
	
	
	private static void readfromadhar(SessionFactory sf) {
		
		Session session=sf.openSession();
		Aadhar a=session.get(Aadhar.class,12121);
		System.out.println(a.getAadharNo());
		System.out.println(a.getAadharName());
		System.out.println(a.getPlayer().getPname());
		System.out.println(a.getPlayer().getPid());
		
	}





	private static void readfromplayer(SessionFactory sf) {
		
		Session session=sf.openSession();
		Player player=session.get(Player.class,1);
		System.out.println(player.getPid());
		System.out.println(player.getPname());
		System.out.println(player.getAadhar().getAadharName());
		System.out.println(player.getAadhar().getAadharNo());
		
	}





	public static void insert (SessionFactory sf) {
		
		   Session session=sf.openSession();
		
		   Transaction trs=session.beginTransaction();
		   
		   
		   Aadhar addhar=new Aadhar(12121,"prince Kumar");
		   
		   Player p=new Player(1,"Prince",addhar);
		   
		   addhar.setPlayer(p);
		   
		   session.save(p);
		   trs.commit();
		   
		   System.out.println("data inserted");
		   
		   
		   
		
	}
	
	public static SessionFactory getConnection() {
		   //load
		   Configuration configuration =new Configuration ();
		   
		   Properties properties=new Properties();
		   
		   properties.put(Environment.URL,"jdbc:mysql://localhost:3306/hibernateinherritance" );
		   properties.put(Environment.USER,"root" );
		   properties.put(Environment.PASS, "Prince@0717");
		   properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver" );
		   properties.put(Environment.HBM2DDL_AUTO, "create");
		   properties.put(Environment.SHOW_SQL,true );
		   properties.put(Environment.FORMAT_SQL,true );
		   
		   configuration.setProperties(properties);
		   configuration.addAnnotatedClass(Player.class);
		   configuration.addAnnotatedClass(Aadhar.class);
			
			
			//setup ready
		   SessionFactory sessionFactory=configuration.buildSessionFactory();
		   
		   //now u perform crud (inbuilt connection)
		   
		   return sessionFactory;
		   
		 
		
	}

}
