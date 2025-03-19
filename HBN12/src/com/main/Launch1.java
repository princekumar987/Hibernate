package com.main;

import java.util.ArrayList;
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
			    	    
			    	 
			         readfromaccount(sf);
			    	 break; 	 
			    	 
				 default:
					 
					 System.out.println("Enter valid choice");
					 break;
				
			}
		}
	 
	   

	}
	
	
	
	
	
	private static void readfromaccount(SessionFactory sf) {
		
		Session session=sf.openSession();
		
		System.out.println("***********Account detaisls***********");
		Account acc=session.get(Account.class, 1);
		
		System.out.println(acc.getAccountno());
		System.out.println(acc.getAccountaddress());
		System.out.println(acc.getAccountName());
		
	    
	    
	    List<Player>list= acc.getPlayer();
	    
	    for(Player player :list) {
	    	
	    	System.out.println("**********player details***********");
	    	System.out.println(player.getPid());
	    	System.out.println(player.getPname());
	    	System.out.println(player.getAccounts());
	    }
		
	}





	private static void readfromplayer(SessionFactory sf) {
	     
		
		       Session session=sf.openSession();
		       
		       Player p=session.get(Player.class, 12);
		       
		       System.out.println("player details");
		       
		       System.out.println(p.getPid());
		       System.out.println(p.getPname());
		       
		       
		       System.out.println("Account details");
		       List<Account>list= p.getAccounts();
		       
		       for(Account a:list) {
		    	   System.out.println("------");
		    	   System.out.println(a.getAccountno());
		    	   System.out.println(a.getAccountName());
		    	   System.out.println(a.getAccountaddress());
		       }
		       
		       
		
	}





	public static void insert (SessionFactory sf) {
		
		   Session session=sf.openSession();
		
		   Transaction trs=session.beginTransaction();
		   
		   Account acc1=new Account(1,"a","Add1");
		   Account acc2=new Account(2,"b","Add2");
		   Account acc3=new Account(3,"c","Add3");
		   
		   List<Account>alist=new ArrayList<>();
		   alist.add(acc1);
		   alist.add(acc2);
		   alist.add(acc3);
		   
		   Player player1=new Player(11,"prince",alist);
		   Player player2=new Player(12,"Rakj",alist);
		   
		   
		   session.save(player1);
		   session.save(player2);
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
		  // properties.put(Environment.SHOW_SQL,true );
		  // properties.put(Environment.FORMAT_SQL,true );
		   
		   configuration.setProperties(properties);
		   configuration.addAnnotatedClass(Player.class);
		   configuration.addAnnotatedClass(Account.class);
			
			
			//setup ready
		   SessionFactory sessionFactory=configuration.buildSessionFactory();
		   
		   //now u perform crud (inbuilt connection)
		   
		   return sessionFactory;
		   
		 
		
	}

}
