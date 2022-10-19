<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action=saveCustomer modelAttribute=customer method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="Name"/></td>
			</tr>
			
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
		</table>
	</form>
</body>
</html>