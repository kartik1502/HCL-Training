<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp"><button>Home</button></a><br><br>
	<form action="display" modelAttibute="book">
		Title:<input type="text" name="name"/><br><br>
		Author Name:<input type="text" name="authorName"><br><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>