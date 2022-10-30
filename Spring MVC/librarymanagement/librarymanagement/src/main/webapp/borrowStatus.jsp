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
	<a href="BorrowBook.jsp"><button>Update Borrow Book Status</button></a>
	<table>
		<tr>
			<th>Book Name</th>
			<th>User Name</th>
			<th>Due Date</th>
			<th>Borrowed Date</th>
			<th>Status</th>
		</tr>
		<c:forEach var="book" items="${getStatus}">
			<tr>
				<td>${book.getBook().getName() }</td>
				<td>${book.getUser().getName() }</td>
				<td>${book.getDueDate() }</td>
				<td>${book.getBorrowDate() }</td>
				<td>${book.getStatus() }</td>
			</tr>
		</c:forEach>	
	</table>
</body>
</html>