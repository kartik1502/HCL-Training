package com.training.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateTable {

	public static void main(String[] args){
		try (Connection con = JdbcValidation.getConnention("onlineshoping")){
			System.out.println(JdbcValidation.tableExist("goldusers","onlineshoping"));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}