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
	<h1>ENTER THE BOOK DETAILS</h1>
	<form action="addBook" modelAttribute="book">
		<table>
			<tr>
				<td><label for="name">Book Title:</label></td>
				<td><input type="text" name="name"></td>
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
		</table>
		<input type="submit"> <input type="reset">

	</form>
</body>
</html>