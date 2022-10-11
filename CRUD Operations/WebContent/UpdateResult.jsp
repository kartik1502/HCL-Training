<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="DataUpdate" method=post>
		<table>
			<tr>
				<td><label for="USN">USN:</label></td>
				<td><input type="text" name="usn" id="USN" value= <%=request.getParameter("usn")%> readonly ></td>
			</tr>
			<tr>
				<td><label for="NAME">Name:</label></td>
				<td><input type="text" name="name" id="NAME" value= <%=request.getParameter("name") %>  ></td>
			</tr>
			<tr>
				<td><label for="EMAIL">Email Id:</label></td>
				<td><input type="email" name="emailid" id="EMAIL" value= <%=request.getParameter("email") %>></td>
			</tr>
			<tr>
				<td><label for="PHONE">Phone Number:</label></td>
				<td><input type="number" name="phone" id="PHONE" pattern="[9876]{1}[0-9]{9}" value=<%=request.getParameter("phone") %>></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
				<td><input type="reset" value="Reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>