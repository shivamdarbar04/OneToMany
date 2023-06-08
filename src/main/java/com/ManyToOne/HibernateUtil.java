package com.ManyToOne;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil

{
	 private static final SessionFactory sessionFactory = buildSessionFactoy(); 
	 public static SessionFactory buildSessionFactoy()
	 {
		 SessionFactory sessionFactory = null;
		 try
		 {
			 Configuration configuration = new Configuration();
			 configuration.configure("hibernate.cfg.xml");
			 sessionFactory = configuration.buildSessionFactory();
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return sessionFactory;
	 }
	 public static SessionFactory getSessionFactory()
	 {
		 return sessionFactory;
	 }
}
