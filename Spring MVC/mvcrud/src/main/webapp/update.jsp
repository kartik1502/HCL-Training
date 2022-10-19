<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
		<table>
			<tr>
				<td>Customer Id:</td>
				<td><input type="number" name="id"/></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="hidden" name="Name" /></td>
			</tr>
			
			<tr>
				<td>Email:</td>
				<td><input type="hidden" name="email"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"/></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>