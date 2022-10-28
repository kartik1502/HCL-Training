<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp"><button>Home</button></a>
	<form action="updateDetails" modelAttribute="book">
		<table>
		<tr>
				<td><label for="name">Book Id:</label></td>
				<td><input type="number" name="bookId" value = ${bookId } ></td>
			</tr>
			<tr>
				<td><label for="name">Book Title:</label></td>
				<td><input type="text" name="name" value = ${bookTitle }></td>
			</tr>
			<tr>
				<td><label for="authorName">Author Name:</label></td>
				<td><input type="text" name="AuthorName" value = ${authorName }></td>
			</tr>

			<tr>
				<td><label for="publishYear">Published Year:</label></td>
				<td><input type="number" name="publishYear" value = ${publishYear }></td>
			</tr>

			<tr>
				<td><label for="genre">Genre:</label></td>
				<td><input type="text" name="Genre" value = ${genre }></td>
			</tr>
		</table>
		<input type="submit" value="Sub mit">
	</form> 
	</body>
</html>