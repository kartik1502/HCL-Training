<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	th,td{
		border: 1px solid black;
	}
</style>
<body>
	<a href="index.jsp"><button>Home</button></a>
	<a href="User.jsp"><button>Add User</button></a>
	<table>
		<tr>
			<th>User Name</th>
			<th>Contact Number</th>
			
		</tr>
		<c:forEach var="user" items="${getUsers}">
			<tr>
				<td>${user.getName() }</td>
				<td>${user.getContactNumber() }</td>
				
			</tr>
		</c:forEach>	
	</table>
</body>
</html>