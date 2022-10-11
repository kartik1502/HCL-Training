package com.javaproject.javaoopsconcept;

public class SecondChild extends Parent{
	int k = 200;
	public void display() {
		System.out.println("From Second Child");
	}
	public void display(String name) {
		System.out.println("From Second child: "+name);
	}
}
