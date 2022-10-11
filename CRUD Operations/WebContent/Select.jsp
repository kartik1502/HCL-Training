<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.training.jdbc.JdbcValidation"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	th,td{
		border: 1px solid black;
	}
</style>
<body>
	<%
		try{
			Connection con = JdbcValidation.getConnention("student");
			PreparedStatement ps = con.prepareStatement("select * from Student");
			ResultSet rs = ps.executeQuery();
			%>
			<table>
				<tr>
					<th>USN</th>
					<th>Name</th>
					<th>Email Id</th>
					<th>Phone Number:</th>
				</tr>
			<%
			while(rs.next()){%>
				<tr>
					<td><%=rs.getString("usn")%></td>
					<td><%=rs.getString("name")%></td>
					<td><%=rs.getString("emailid")%></td>
					<td><%=rs.getString("phone")%></td>
				</tr>
			<%}%>
			</table>
		<%}
				catch(Exception e){
					e.printStackTrace();
				}%>
</body>
</html>