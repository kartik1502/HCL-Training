<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Calculator" method=post>
		Number One:<input type="number" name="numberOne" required><br><br>
		Number Two:<input type="number" name="numberTwo" required><br><br>
		<label for="op">Operator:</label>
		<select name="operator" required>
			<option selected disabled>operator</option>
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
			<option value="%">%</option>
		</select><br><Br>
		<input type="submit" value="Submit"><br><br>
		<input type="reset" value="Reset"><br><br>
	</form>
</body>
</html>