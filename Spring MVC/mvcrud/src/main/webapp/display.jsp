<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="index.jsp"><button>Home</button></a>
	<table>
		<tr>
			<th>Customer Id</th>
			<th>Customer Name</th>
			<th>Customer Email</th>
			<th>Delete Customer</th>
			<th>Update Customer</th>
		</tr>
		<c:forEach var="customer" items="${getCustomer}">
			<tr>
				<td>${customer.getId() }</td>
				<td>${customer.getName() }</td>
				<td>${customer.getEmail() }</td>
				<td><a href="update?id=${customer.getId() }"><button>Update</button></a></td>
				<td><a href="delete?id=${customer.getId() }"><button>Delete</button></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>