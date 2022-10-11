package com.training.school.dto;

import java.util.Scanner;

public class StudentDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean execute = true;
		StudentController s = new StudentController();
		while(execute){
			System.out.println("1.Add Student Details\n2.View Student Details\n3.Update Student Details\n4.Delete Student Details\n5.Terminate\nEnter your choice");
			int choice = sc.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter the Student Id: ");
					int Id = sc.nextInt();
					System.out.println("Enter the Student Name: ");
					String Name = sc.next();
					System.out.println("Enter the Student Email Id: ");
					String emailId = sc.next();
					System.out.println("Enter the Student Phone Number: ");
					long studPhoneNo = sc.nextLong();
					s.saveStudent(new Student(Id, Name, emailId, studPhoneNo));
					break;
				case 2:
					System.out.println(s.displayStudentDetails());
					break;
				case 3:
					System.out.println("Enter the Student Id: ");
					Id = sc.nextInt();
					System.out.println("Enter the Student Name: ");
					Name = sc.next();
					System.out.println("Enter the Student Email Id: ");
					emailId = sc.next();
					System.out.println("Enter the Student Phone Number: ");
					studPhoneNo = sc.nextLong();
					s.updateStudent(new Student(Id, Name, emailId, studPhoneNo));
					break;
				case 4:
					System.out.println("Enter the Student Id whose details has to be deleted: ");
					Id = sc.nextInt();
					s.deleteById(new Student(Id));
					break;
				case 5:execute = false;
					break;
				default:System.out.println("Invalid Choice");
			}
		}
		sc.close();
	}
}
