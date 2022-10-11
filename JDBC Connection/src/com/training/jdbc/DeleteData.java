package com.training.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteData {
	
	public static void main(String[] args) {
		try(Connection con = JdbcValidation.getConnention()){
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the user Id:");
			int userId = sc.nextInt();
			PreparedStatement ps = con.prepareStatement("delete from users where userId = ?");
			ps.setInt(1, userId);
			ps.execute();
			sc.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}