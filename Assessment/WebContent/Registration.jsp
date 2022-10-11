<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form action="RegisterData" method=post>
		<h2>Registration</h2>
		<table>
			<tr>
				<td><label for="fName">First Name:</label></td>
				<td><input id="fName" name="firstName" type="text" required></td>
			</tr>
			<tr>
				<td><label for="lName">Last Name:</label></td>
				<td><input id="lName" name="lastName" type="text" required></td>
			</tr>
			<tr>
				<td><label for="pnumber">Phone Number:</label></td>
				<td><input id="pnumber" name="phoneNumber" type="tel" pattern="[6-9][0-9]{9}" required></td>
			</tr>
			<tr>
				<td><label for="email">Email Id:</label></td>
				<td><input id="email" name="emailId" type="email" required></td>
			</tr>
			<tr>
				<td><label for="language">Languages:</label></td>
				<td><input id="C" type="checkbox" name="lang" value="C"><label for="C">C</label><br>
					<input id="C++" type="checkbox" name="lang" value="C++"><label for="C++">C++</label><br>
					<input id="Java" type="checkbox" name="lang" value="Java"><label for="Java">Java</label><br>
				</td>
			</tr>
			<tr>
				<td><input value="Reset" type="reset"></td>
				<td><input value="Submit" type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>