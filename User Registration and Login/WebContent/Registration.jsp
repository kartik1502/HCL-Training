<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<form action="Registration" method=post>
		<label for="registerUser">Username:</label>
		<input type="text" name="regUser" id="registerUser"><br><br>
		<label for="registerEmail">Email ID:</label>
		<input type="email" name="regEmail" id="registerEmail"><br><br>
		<label for="registerPassword">Password:</label>
		<input type="password" name="regPassword" id="registerPassword"><br><Br>
		<input type="reset" value="Reset"><br><input type="submit" value="Submit"><br>
		<a href="Login.jsp">Already Registered Login?</a>
	</form>
</body>
</html>