<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

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
			<th>Book Name</th>
			<th>Author Name</th>
			<th>Published Year</th>
			<th>Genre</th>
		</tr>
	<c:forEach var="book" items="${getBooks}">
			<tr>
				<td>${book.getName() }</td>
				<td>${book.getAuthorName() }</td>
				<td>${book.getPublishYear() }</td>
				<td>${book.getGenre() }
			</tr>
		</c:forEach>	</table>

</body>
</html>