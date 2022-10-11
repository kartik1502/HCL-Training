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

@WebServlet("/InsertOperation")
public class InsertOperation extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setContentType("text/html");
		//PrintWriter pw = response.getWriter();
		String usn = request.getParameter("usn");
		String name = request.getParameter("name");
		String email = request.getParameter("emailid");
		String phone = request.getParameter("phone");
		try{
			Connection con = JdbcValidation.getConnention("student");
			PreparedStatement ps = con.prepareStatement("insert into Student values(?,?,?,?)");
			ps.setString(1, usn);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.execute();
			response.sendRedirect("Result.jsp?message=Inserted Successfully");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
