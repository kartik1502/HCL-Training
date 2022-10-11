package com.training.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcValidation {

	static Connection con = null;
	public static Connection getConnention(String database) {
		if(con != null) {
			return con;
		}
		String username = "root";
		String password = "root";
		return getConnection(database,username,password);
	}
	private static Connection getConnection(String databaeName,String userName,String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaeName,userName,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static boolean tableExist(String tableName,String database) {
		try {
			PreparedStatement ps = getConnention(database).prepareStatement("select count(*) from information_schema.tables where table_name = ? limit 1");
			ps.setString(1, tableName);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1) != 0;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
