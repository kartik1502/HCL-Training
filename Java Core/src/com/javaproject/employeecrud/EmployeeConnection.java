package com.javaproject.employeecrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeConnection {
	
	static Connection con = null;
	public static Connection getConnection(String database){
		if(con != null){
			return con;
		}
		String url = "jdbc:mysql://localhost:3306/";
		String userName = "root";
		String password = "root";
		return getConnection(url,database,userName,password);
	}
	private static Connection getConnection(String url,String database,String userName,String password){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url+database,userName,password);
		}
		catch(ClassNotFoundException e){
			System.out.println(e);
			e.printStackTrace();
		}
		catch(SQLException e){
			System.out.println(e);
			e.printStackTrace();
		}
		return con;
	}
}