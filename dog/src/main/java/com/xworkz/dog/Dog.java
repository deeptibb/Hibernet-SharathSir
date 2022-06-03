package com.xworkz.dog;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dogdb")
public class Dog {

	@Id
	@Column(name = "DOG_ID")
	private int dogId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "BREED")
	private String breed;
	@Column(name = "COLOR")
	private String color;
	@Column(name = "WEIGHT")
	private double weight;
	

	public Dog(int dogId, String name, String gender, String breed, String color, double weight) {
		super();
		this.dogId = dogId;
		this.name = name;
		this.gender = gender;
		this.breed = breed;
		this.color = color;
		this.weight = weight;
		
	}


	public Dog() {
		super();
	}


	public int getDogId() {
		return dogId;
	}


	public void setDogId(int dogId) {
		this.dogId = dogId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	@Override
	public String toString() {
		return "Dog [dogId=" + dogId + ", name=" + name + ", gender=" + gender + ", breed=" + breed + ", color=" + color
				+ ", weight=" + weight + "]";
	}


	

}
