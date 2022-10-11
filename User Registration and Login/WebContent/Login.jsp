<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Login" method=post>
		<label for="loginEmail">Email ID:</label>
		<input type="email" name="loginEmail" id="loginEmail"><br><br>
		<label for="loginPassword">Password:</label>
		<input type="password" name="loginPassword" id="loginPassword"><br><Br>
		<input type="reset" value="Reset"><br><input type="submit" value="Submit"><br>
		<a href="Registration.jsp">Click here to register.....</a>
	</form>
</body>
</html>