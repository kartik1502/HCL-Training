package com.javaproject.javaoopsconcept;

public class DriverClass {
	public static void main(String[] args) {
		Child c = new Child();
		SecondChild sc = new SecondChild();
		c.display();
		sc.display();
		sc.display("Karthik");
	}
}