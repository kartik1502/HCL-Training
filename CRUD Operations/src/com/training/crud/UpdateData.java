package com.training.crud;

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

@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usn = request.getParameter("usn");
		try{
			Connection con = JdbcValidation.getConnention("student");
			PreparedStatement ps = con.prepareStatement("select * from Student where usn = ?");
			ps.setString(1, usn);
			ResultSet rs = ps.executeQuery();
			rs.next();
			response.sendRedirect("UpdateResult.jsp?usn="+rs.getString("usn")+"&name="+rs.getString("name")+"&email="+rs.getString("emailid")+"&phone="+rs.getString("phone"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
