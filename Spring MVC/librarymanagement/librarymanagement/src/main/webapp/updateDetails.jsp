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
<h3>*Fill the fields which needs to be changed</h3>
	<form action="updateDetails" modelAttribute="book">
		<table>
		<tr>
				<td><label for="name">Book Id:</label></td>
				<td><input type="number" name="bookId" value = ${bookId } ></td>
			</tr>
			<tr>
				<td><label for="name">Book Title:</label></td>
				<td><input type="text" name="name" ></td>
			</tr>
			<tr>
				<td><label for="authorName">Author Name:</label></td>
				<td><input type="text" name="AuthorName"></td>
			</tr>

			<tr>
				<td><label for="publishYear">Published Year:</label></td>
				<td><input type="number" name="publishYear"></td>
			</tr>

			<tr>
				<td><label for="genre">Genre:</label></td>
				<td><input type="text" name="Genre"></td>
			</tr>
			<tr>
				<td><label for="noOfCopies">No of Copies:</label></td>
				<td><input type="text" name="noOfCopies"></td>
			</tr>
		</table>
		<input type="submit" value="Sub mit">
	</form> 
	</body>
</html>