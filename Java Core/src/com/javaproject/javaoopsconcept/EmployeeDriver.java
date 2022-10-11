package com.javaproject.javaoopsconcept;
public class EmployeeDriver {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.empid = 1;
		e1.name = "Karthik";
		e1.salary = 60000;
		System.out.println(e1);
		Employee e2 = new Employee();
		e2.empid = 2;
		e2.name = "Arya";
		e2.salary = 65000;
		System.out.println(e2);
	}
}