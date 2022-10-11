package org.training.customercrud.controller;

import java.util.Scanner;

import org.training.customer.dao.CustomerDao;
import org.training.customer.dto.Customer;

public class CustomerController {

	public static void main(String[] args) {

		CustomerDao customerDao = new CustomerDao();
		boolean execute = true;
		Scanner sc = new Scanner(System.in);
		while (execute) {
			System.out.println("1.Save Customer.\n2.Update Customer.\n3.Delete Customer.\n4.Get Customer By Name.\n5.Get Customer Details.\n6.Terminate\nEnter your choice");
			int choice = sc.nextInt();
			switch (choice) {
				case 1: {
					Customer customer = new Customer();
					System.out.println("Enter the Customer Name: ");
					customer.setName(sc.next());
					System.out.println("Enter the Customer EMail Id: ");
					customer.setEmailId(sc.next());
					System.out.println("Enter the Customer Phone Number: ");
					customer.setPhoneNo(sc.nextLong());
					customerDao.saveCustomer(customer);
				}
					break;
				case 2:{
					Customer customer = new Customer();
					System.out.println("Enter the Customer Id: ");
					int id = sc.nextInt();
					System.out.println("Enter the Customer Name: ");
					customer.setName(sc.next());
					System.out.println("Enter the Customer EMail Id: ");
					customer.setEmailId(sc.next());
					System.out.println("Enter the Customer Phone Number: ");
					customer.setPhoneNo(sc.nextLong());
					customerDao.updateCustomer(customer, id);
				}
					break;
				case 3:{
					Customer customer = new Customer();
					System.out.println("Enter the Customer Id: ");
					customer.setId(sc.nextInt());
					customerDao.deleteCustomer(customer);
				}
					break;
				case 4:{
					System.out.println("Enter the Customer Name: ");
					String name = sc.next();
					System.out.println(customerDao.getCustomerByName(name));
				}
					break;
				case 5:{
					System.out.println(customerDao.getCustomersDetails());
				}
					break;
				case 6:execute = false;
					break;
				default:System.out.println("Invalid Choice");

			}
		}
		sc.close();
	}
}
