package com.training.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertData {

	public static void main(String[] args) {
		
		try (Connection con = JdbcValidation.getConnention()){
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the user Id: ");
			int userId = sc.nextInt();
			System.out.println("Enter the first name:");
			String fname = sc.next();
			System.out.println("Enter the last name:");
			String lname = sc.next();
			System.out.println("Enter the Email Id:");
			String emailId = sc.next();
			System.out.println("Enter the city name:");
			String city = sc.next();
			System.out.println("Enter the phone number:");
			String phoneNumber = sc.next();
			PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?,?,?)");
			ps.setInt(1, userId);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, emailId);
			ps.setString(5, city);
			ps.setString(6, phoneNumber);
			ps.execute();
			sc.close();
			System.out.println("Insertion Success");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
