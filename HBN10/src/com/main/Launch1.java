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
			
			
			System.out.println("p1->Insert->\np2->ReadSQL->\np3->ReadHQL->\np6->exit->\nEnter Choice:--");
			
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
			    	    
			    	 
			    	 readSql(sf);
			    	 break; 
                  case 3:
			    	    
			    	 
			         readHql(sf);
			    	 break; 	 
			    	 
				 default:
					 
					 System.out.println("Enter valid choice");
					 break;
				
			}
		}
	 
	   

	}
	
	
	
	
	
	private static void readHql(SessionFactory sf) {
		
		Session session=sf.openSession();
		
		String sql="from Player";
		
		Query query=session.createQuery(sql);
		List<Player >list=query.list();
		
		for(Player p:list) {
			
			if(p instanceof Cricketer) {
				 Cricketer c=(Cricketer)p;
				 System.out.println("c-->"+c);
			}
			else {
				Footboller f=(Footboller)p;
				System.out.println("f-->"+f);
			}
		}
		
	}





	private static void readSql(SessionFactory sf) {
		
		Session session=sf.openSession();
		
		String query = "SELECT p.pid, p.pname, c.crun, c.ctype " 
	             + "FROM player p "
	             + "JOIN cricketer c ON p.pid = c.pid "
	             + "UNION ALL "
	             + "SELECT p.pid, p.pname, f.fgoal, f.ftype " 
	             + "FROM player p " 
	             + "JOIN footboller f ON p.pid = f.pid;";

		
		NativeQuery nq=session.createNativeQuery(query);
		
		List<Object[]>list=nq.getResultList();
		
		for(Object []o:list) {
			
			for(Object e:o) {
				System.out.println(e);
			}
		}
		System.out.println();
	}





	public static void insert (SessionFactory sf) {
		
		   Session session=sf.openSession();
		
		   Transaction trs=session.beginTransaction();
		   
		   
		   Footboller f=new Footboller(11,"ronaldo",80,"attack");
		   
		   Cricketer c=new Cricketer(7,"Msdhoni",300,"wk");
		   
		   session.save(c);
		   session.save(f);
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
		   properties.put(Environment.HBM2DDL_AUTO, "update");
		   properties.put(Environment.SHOW_SQL,true );
		   properties.put(Environment.FORMAT_SQL,true );
		   
		   configuration.setProperties(properties);
		   configuration.addAnnotatedClass(Player.class);
		   configuration.addAnnotatedClass(Cricketer.class);
		   configuration.addAnnotatedClass(Footboller.class);
			
			
			//setup ready
		   SessionFactory sessionFactory=configuration.buildSessionFactory();
		   
		   //now u perform crud (inbuilt connection)
		   
		   return sessionFactory;
		   
		 
		
	}

}
