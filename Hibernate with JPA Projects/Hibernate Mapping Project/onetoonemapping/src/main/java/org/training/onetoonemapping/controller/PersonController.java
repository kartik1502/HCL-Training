package org.training.onetoonemapping.controller;

import java.util.Scanner;

import org.training.onetoonemapping.dao.PersonDao;
import org.training.onetoonemapping.dto.Aadhar;
import org.training.onetoonemapping.dto.Person;

public class PersonController {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PersonDao personDao = new PersonDao();
		boolean execute = true;
		while(execute){
			System.out.println("1.Save Person\n2.Get Person Details.\n3.Update Person Details.\n4.Delete Person.\n5.Terminate\nEnter your choice");
			int choice = sc.nextInt();
			switch(choice){
				case 1:{
					Person person = new Person();
					Aadhar aadhar = new Aadhar();
					System.out.println("Enter the Person Name: ");
					person.setName(sc.next());
					System.out.println("Enter the Person Email id:");
					person.setEmailId(sc.next());
					System.out.println("Enter the Person Aadhar details");
					System.out.println("Enter the Aadhar number: ");
					aadhar.setAadharNumber(sc.nextLong());
					System.out.println("Enter the Person Address: ");
					aadhar.setAddress(sc.next());
					person.setAadhar(aadhar);
					personDao.savePerson(person,aadhar);
				}
					break;
				case 2:{
					System.out.println("Enter the Person Id: ");
					int id = sc.nextInt();
					System.out.println(personDao.getPersonDetails(id));
				}
					break;
				case 3:{
					System.out.println("Enter the Person Id: ");
					int id = sc.nextInt();
					System.out.println("Enter the Person Name: ");
					String name = sc.next();
					System.out.println("Enter the aadhar Number: ");
					long aadharNumber = sc.nextLong();
					personDao.updatePersonDetails(id, name, aadharNumber);
				}
					break;
				case 4:{
					System.out.println("Enter the Person Id: ");
					int id = sc.nextInt();
					personDao.deletePersonDetails(id);
				}
					break;
				case 5:execute = false;
					
			}
		}
		sc.close();
	}

}
