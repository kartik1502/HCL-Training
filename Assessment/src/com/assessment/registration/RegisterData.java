package com.assessment.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterData")
public class RegisterData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","root");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String phoneNumber = request.getParameter("phoneNumber");
			String emailId = request.getParameter("emailId");
			String[] languages = request.getParameterValues("lang");
			
			PreparedStatement check = con.prepareStatement("select * from Registration where emailId = ? or phoneNo = ?");
			check.setString(1, emailId);
			check.setString(2, phoneNumber);
			ResultSet rs = check.executeQuery();
			if(rs.next()){
				response.sendRedirect("Result.jsp?message=User Already Present");
				return;
			}
			if(languages == null){
				response.sendRedirect("Result.jsp?message=Please select the language");
				return;
			}
			PreparedStatement ps = con.prepareStatement("insert into Registration values(?,?,?,?)");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, phoneNumber);
			ps.setString(4, emailId);
			ps.execute();
			PreparedStatement lang = con.prepareStatement("insert into Languages values(?,?)");
			for(int i = 0;i < languages.length;i++){
				lang.setString(1, emailId);
				lang.setString(2, languages[i]);
				lang.execute();
			}
			response.sendRedirect("Result.jsp?message=Registered Successfully");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
