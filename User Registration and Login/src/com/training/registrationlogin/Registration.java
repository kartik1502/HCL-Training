package com.training.registrationlogin;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.jdbc.*;

public class Registration extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			Connection con = JdbcValidation.getConnention("users");
			String emailId = req.getParameter("regEmail");
			String user = req.getParameter("regUser");
			String pswd = req.getParameter("regPassword");
			PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?)");
			ps.setString(1, null);
			ps.setString(2, user);
			ps.setString(3, emailId);
			ps.setString(4, pswd);
			ps.execute();
			resp.sendRedirect("Login.jsp");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}