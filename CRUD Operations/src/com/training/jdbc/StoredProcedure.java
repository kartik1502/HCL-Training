package com.training.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;

public class StoredProcedure {

	public static void main(String[] args) {
		try(Connection con = JdbcValidation.getConnention("onlineshoping")){
			CallableStatement cs = con.prepareCall("call insertOrders(?,?,?,?,?,?,?)");
			cs.setInt(1, 11);
			cs.setInt(2, 11);
			cs.setInt(3, 11);
			cs.setInt(4, 6);
			cs.setString(5,"Gadag");
			cs.setString(6,"2020-02-05");
			cs.setString(7, "Delivered");
			cs.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
}


//Stored Procedure implemented in SQL
//
//CREATE DEFINER=`root`@`localhost` PROCEDURE `insertOrders`(in orderId int,in prodId int,in userId int,in qty int,in shipAdd varchar(255),in shipDate date,in shipStatus varchar(255))
//BEGIN
//	insert into orders values(orderId,prodId,userId,qty,shipAdd,shipDate,shipStatus);
//END
