package com.training.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewDetails {
	
		public static void main(String[] args) {
			try (Connection con = JdbcValidation.getConnention()){
				Statement st = con.createStatement();
				ResultSet rs =  st.executeQuery("select * from users");
				while(rs.next()) {
					System.out.println("User Id: "+rs.getInt(1)+"\nFirst Name: "+rs.getString(2)+"\nLast Name: "+rs.getString(3)+"\nEmail Id: "+rs.getString(4)+"\nCity: "+rs.getString(5)+"\nPhone Number: "+rs.getString(6));
					System.out.println("--------------------------------------------------");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
}