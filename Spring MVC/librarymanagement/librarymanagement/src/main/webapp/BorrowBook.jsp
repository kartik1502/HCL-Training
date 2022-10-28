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
	<form action="borrowed">
		<table>
			<tr>
				<td><label for="name">User Id:</label></td>
				<td><input type="number" name="userId"></td>
			</tr>

			<tr>
				<td><label for="publishYear">Book Id:</label></td>
				<td><input type="number" name="bookId"></td>
			</tr>
			
			<tr>
				<td><label for="publishYear">Status:</label></td>
				<td><input type="text" name="status"></td>
			</tr>

		</table>
		<input type="submit"> <input type="reset">
	</form>
</body>
</html>