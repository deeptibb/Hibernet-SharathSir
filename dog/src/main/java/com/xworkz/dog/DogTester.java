package com.xworkz.dog;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DogTester {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		//configuration.addAnnotatedClass(Dog.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Dog dog = new Dog(12, "charli", "male", "run", "white", 30.5);
		//session.save(dog);
		session.persist(dog);
		Transaction transaction = session.beginTransaction();
	
		transaction.commit();
		session.close();
		System.out.println("save succusfully");
	}

}
