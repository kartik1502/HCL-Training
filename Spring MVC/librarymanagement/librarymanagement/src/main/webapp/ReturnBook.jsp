<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp"><button>Home</button></a>
	<form action="returnBook">
		<table>
			<tr>
				<td><label for="user">User Id:</label></td>
				<td><input type="number" name="userId"/></td>
			</tr>
			<tr>
				<td><label for="book">Book Id:</label></td>
				<td><input type="number" name="bookId"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>