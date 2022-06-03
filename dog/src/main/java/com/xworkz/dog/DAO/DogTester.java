package com.xworkz.dog.DAO;

import com.xworkz.dog.Dog;

public class DogTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Dog dog = new Dog(10,"charli", "male", "run", "white", 30.5);
DogDAO dogImpl=new DogDAOImpl();
dogImpl.insertDog(dog);
System.out.println("Inserted succussfully");
dogImpl.getDogById(1);
System.out.println("getDogById is succussful");


}

}
