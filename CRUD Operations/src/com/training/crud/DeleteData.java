package com.training.crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.jdbc.JdbcValidation;


@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usn = request.getParameter("usn");
		try{
			Connection con = JdbcValidation.getConnention("student");
			PreparedStatement ps = con.prepareStatement("delete from Student where usn = ?");
			ps.setString(1, usn);
			ps.executeUpdate();
			response.sendRedirect("Result.jsp?message=Deleted Successfully");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
