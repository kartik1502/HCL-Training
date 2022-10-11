package com.javaproject.employeecrud;

public class EmployeeData {

	private int id;
	private String name;
	private String emailId;
	private double salary;
	public EmployeeData(int id, String name, String emailId, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.salary = salary;
	}
	
	public EmployeeData(int id, String name, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
	}

	public EmployeeData(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee Id: " + getId() + "\nEmployee Name: " + getName() + "\nEmployee Email Id: " + getEmailId()
				+ "\nEmployee Salary: " + getSalary();
	}
	public EmployeeData() {
		super();
	}
	
}
