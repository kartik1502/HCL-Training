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

@WebServlet("/DataUpdate")
public class DataUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String usn = request.getParameter("usn");
		String name = request.getParameter("name");
		String email = request.getParameter("emailid");
		String phone = request.getParameter("phone");
		try{
			Connection con = JdbcValidation.getConnention("student");
			PreparedStatement ps = con.prepareStatement("update Student set name = ?,emailid = ?,phone = ? where usn = ?");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, usn);
			ps.executeUpdate();
			response.sendRedirect("Result.jsp?message=Update Successfull");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
