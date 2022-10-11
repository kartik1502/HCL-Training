package com.training.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateDetails {

	public static void main(String[] args) {
		try (Connection c = JdbcValidation.getConnention()){
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the userId of which the phone number is to be updated:");
			int userId = sc.nextInt();
			System.out.println("Enter the phone number: ");
			String phoneNumber = sc.next();
			PreparedStatement ps = c.prepareStatement("update users set phone = ? where userId = ?");
			ps.setString(1, phoneNumber);
			ps.setInt(2, userId);
			ps.execute();
			sc.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}