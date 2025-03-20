package com.main;


import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.Query;





public class Launch1 {

	public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       SessionFactory sf=getConnection();
       
       Session session=sf.openSession();
       System.out.println(session);
		
		while(true) {
			
			
			System.out.println("p1->insert->\np2->Read->\np3->update->\np4->delete->\np5->exit-> \np6->test->\nEnter Choice:--");
			
			int choice=sc.nextInt();
			sc.nextLine();
			if(choice==5) {
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
                  case 6:
			    	    
  			    	 
    			       test(sf);
    			    	 break; 	 
			    	 
				 default:
					 
					 System.out.println("Enter valid choice");
					 break;
				
			}
		}
	 
	   

	}
	
	
	
	
	




	


	private static void test(SessionFactory sf) {
		
		Session session=sf.openSession();
		
		Criteria criteria=session.createCriteria(Player.class);
		
		
		//pid pname
		
		ProjectionList projectionList=Projections.projectionList() ;
		
		projectionList.add(Projections.property("pid"));
		projectionList.add(Projections.property("pname"));
		
		SimpleExpression it=Restrictions.lt("pid", 4);
		
		criteria.setProjection(projectionList);
        List<Object[]>list=criteria.list();
		
		for(Object[]o:list) {
			for(Object l:o) {
				
				System.out.println(l);
				
			}
		}
		
		System.out.println(list);
		
	}












	private static void delete(SessionFactory sf) {
		
		Session session=sf.openSession();
		Transaction trs=session.beginTransaction();
		
        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		
        CriteriaDelete<Player>deleteCriteria=criteriaBuilder.createCriteriaDelete(Player.class);
        Root<Player>root=deleteCriteria.from(Player.class);
        
        deleteCriteria.where(criteriaBuilder.greaterThan(root.get("pid"), 6));
        
        Query<Player>query=session.createQuery(deleteCriteria);
		query.executeUpdate();
		trs.commit();
		System.out.println("Data deletd");
		
		
		
		
		
	}

	private static void update(SessionFactory sf) {
		Session session=sf.openSession();
		Transaction trs=session.beginTransaction();
		
        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		
        CriteriaUpdate<Player>updateCriteria=criteriaBuilder.createCriteriaUpdate(Player.class);
		
		Root<Player>root=updateCriteria.from(Player.class);
		
		updateCriteria.set(root.get("pname"), "ram");
		updateCriteria.where(criteriaBuilder.lessThan(root.get("pid"), 6));
		
		Query<Player>query=session.createQuery(updateCriteria);
		query.executeUpdate();
		trs.commit();
		System.out.println("Data Updated");
		
		
		
	}



	private static void read(SessionFactory sf) {
		
		
		Session session=sf.openSession();
		
		//it will provide critiria ex--read upate delete
		
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		
		CriteriaQuery<Player>readCriteria=criteriaBuilder.createQuery(Player.class);
		
		Root<Player>root=readCriteria.from(Player.class);
		
		//select * from critiria player
		
		readCriteria.multiselect(root.get("pid"),root.get("pname"));
		
		Predicate c1=criteriaBuilder.lessThan(root.get("pid"), 6);
		Predicate c2=criteriaBuilder.like(root.get("pname"), "%2");
		
		readCriteria.where(criteriaBuilder.and(c1,c2));
		
		
		
		Query<Player>query=session.createQuery(readCriteria);
		
		List<Player>list=query.list();
		
		System.out.println(list);
		
		
	}



	public static void insert (SessionFactory sf) {
		
		   Session session=sf.openSession();
		
		   Transaction trs=session.beginTransaction();
		   
		   for(int i=1;i<=10;i++) {
		   
		       Player p=new Player("CSK"+i,"Chennai"+i);
		   
		       session.save(p);
		   }
		   trs.commit();
		   
		   System.out.println("Data Inserted");
		   
		
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
			
			//setup ready
		   SessionFactory sessionFactory=configuration.buildSessionFactory();
		   
		   //now u perform crud (inbuilt connection)
		   
		   return sessionFactory;
		   
		 
		
	}

}