package com.xworkz.dog.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.dog.Dog;

public class DogDAOImpl implements DogDAO{

	public void insertDog(Dog dog) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Dog.class);
		SessionFactory sessionFactory1 = configuration.buildSessionFactory();
		Session session1 = sessionFactory1.openSession();
		Dog dog1 = new Dog(13, "charli", "male", "run", "white", 30.5);
		session1.save(dog);
		//session.persist(dog);
		Transaction transaction1 = session1.beginTransaction();

		transaction1.commit();
		session1.close();
		System.out.println("save succusfully");

	}

	public void getDogById(int id) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Dog.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
//Dog dog = new Dog(12, "charli", "male", "run", "white", 30.5);
//session.save(dog);
//session.persist(dog);
		Transaction transaction = session.beginTransaction();
		Dog db = session.get(Dog.class, 10);
		System.out.println("Nameof dog is "+db.getName());
		transaction.commit();
		session.close();
		System.out.println("data added succusfully");
	}

}
