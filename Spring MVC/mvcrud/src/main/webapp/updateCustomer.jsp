<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="updateCustomer" modelAttribute="update">
<form:input path="id"  /><br><br>
<form:input path= "name"/><br><br>
<form:input path = "email"/><br><br>
<button>UPDATE</button>
</form:form>
</body>
</html>