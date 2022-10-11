package com.training.registrationlogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.jdbc.JdbcValidation;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String emailId = request.getParameter("loginEmail");
			String pswd = request.getParameter("loginPassword");
			Connection con = JdbcValidation.getConnention("users");
			PreparedStatement ps = con.prepareStatement("select * from users where emaidId = ? and Password = ?");
			ps.setString(1, emailId);
			ps.setString(2, pswd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				response.sendRedirect("Welcome.jsp");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
