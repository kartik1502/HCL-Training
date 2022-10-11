package com.training.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Savepoint;

public class Transcation {
	public static void main(String[] args) {
		try(Connection con = JdbcValidation.getConnention()){
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement("insert into orders values(?,?,?,?,?,?,?)");
			ps.setInt(1,11);
			ps.setInt(2,11);
			ps.setInt(3,11);
			ps.setInt(4,5);
			ps.setString(5,"Gadag");
			ps.setString(6,"2020-12-2");
			ps.setString(7,"Delivered");
			ps.execute();
			Savepoint sp = con.setSavepoint();
			ps.setInt(1,12);
			ps.setInt(2,13);
			ps.setInt(3,14);
			ps.setInt(4,3);
			ps.setString(5,"Belguam");
			ps.setString(6,"2020-2-2");
			ps.setString(7,"Shipped");
			ps.execute();
			con.rollback(sp);
			con.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
