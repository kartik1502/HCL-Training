package com.javaproject.javaoopsconcept;

public class Human {
	String name = "Arya";
	int age = 23;
	String bloodGroup = "B+";
	Heart heart = new Heart();
	public Human(String name, int age, String bloodGroup, Heart heart) {
		this.name = name;
		this.age = age;
		this.bloodGroup = bloodGroup;
		this.heart = heart;
	}
	public void humanDisplay() {
		System.out.println("Human Name: "+name+"\nAge: "+age+"\nBlood Group: "+bloodGroup);
	}
}
