package org.training.manytomanymapping.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.training.manytomanymapping.dao.StudentDao;
import org.training.manytomanymapping.dto.Student;
import org.training.manytomanymapping.dto.Subject;

public class StudentController {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentDao studentDao = new StudentDao();
		boolean execute = true;
		while (execute) {
			System.out.println(
					"1.Save the Student.\n2.Get Student By Id.\n3.Update Student.\n4.Delete Student.\n5.Terminate.\nEnter your choice\n");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					List<Subject> subjects = new ArrayList<Subject>();
					List<Student> students = new ArrayList<>();
					System.out.println("Enter the Number of Students: ");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						Student student = new Student();
						System.out.println("Enter the Student Name: ");
						student.setName(sc.next());
						System.out.println("Enter the Student Phone Number: ");
						student.setPhoneNo(sc.nextLong());
						System.out.println("Enter the number of subjects: ");
						int sub = sc.nextInt();
						for (int j = 0; j < sub; j++) {
							Subject subject = new Subject();
							System.out.println("Enter the subject Name: ");
							subject.setSubName(sc.next());
							System.out.println("Enter the subject Author: ");
							subject.setSubAuthor(sc.next());
							subjects.add(subject);
						}
						student.setSubject(subjects);
						students.add(student);
					}
					studentDao.saveStudent(students, subjects);
				}
				break;
			case 2:{
				System.out.println("Enter the Sudent Id: ");
				int id = sc.nextInt();
				System.out.println(studentDao.getStudentSubjectDetails(id));
			}
				break;
			case 3:{
				System.out.println("Enter the Student Id: ");
				int id = sc.nextInt();
				System.out.println("Enter the Student Name: ");
				
			}
				break;
			case 4:{
				System.out.println("Enter the Student Id: ");
				int id = sc.nextInt();
				studentDao.deleteStudentSubjectDetails(id);
			}
				break;
			case 5: execute = false;
			}
		}
	}
}
