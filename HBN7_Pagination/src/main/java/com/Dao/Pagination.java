package com.Dao;

import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.NativeQuery;


public class Pagination {
	
	
	public List<Employee> read(int start) {
		
		 SessionFactory sf=getConnection();
		
		 Session session=sf.openSession();
		
         NativeQuery nq= session.getNamedNativeQuery("read");
         nq.setFirstResult(start);
         nq.setMaxResults(4);
         
		
	     nq.addEntity(Employee.class);
		 List<Employee>list=nq.getResultList();
		
		 return list;
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
