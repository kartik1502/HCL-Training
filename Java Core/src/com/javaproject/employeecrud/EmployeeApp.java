package com.javaproject.employeecrud;

import java.util.Scanner;

public class EmployeeApp {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean execute = true;
		EmployeeEntry e = new EmployeeEntry();
		while(execute){
			System.out.println("1.Add Employee Details\n2.View Employee Details\n3.Get Employee Details\n4.Update Employee Details\n5.Delete Employee Details\n6.Terminate\nEnter your choice");
			int choice = sc.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter the Employee Id: ");
					int empId = sc.nextInt();
					System.out.println("Enter the Employee Name: ");
					String empName = sc.next();
					System.out.println("Enter the Employee Emaild Id: ");
					String empEmail = sc.next();
					System.out.println("Enter the Employee salary: ");
					double salary = sc.nextDouble();
					e.insertEmployee(new EmployeeData(empId, empName, empEmail, salary));
					break;
				case 2:
					System.out.println(e.getEmployeeDetails());
					break;
				case 3:
					System.out.println("Enter the Employee Id whose details has to be reterived: ");
					empId = sc.nextInt();
					System.out.println(e.getById(new EmployeeData(empId)));
					break;
				case 4:
					System.out.println("Enter the Employee Id whose details has to be updated: ");
					empId = sc.nextInt();
					System.out.println("Enter the new name: ");
					empName = sc.next();
					System.out.println("Ente the new Email Id: ");
					empEmail = sc.next();
					e.updateEmployee(new EmployeeData(empId, empName, empEmail));
					break;
				case 5:
					System.out.println("Enter the Employee Id whose details has to be deleted: ");
					empId = sc.nextInt();
					e.deleteEmployee(new EmployeeData(empId));
					break;
				case 6:execute = false;
					break;
				default:System.out.println("Invalid Choice");
			}
		}
		sc.close();
	}
}