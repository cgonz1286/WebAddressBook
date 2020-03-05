<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "addAddressServlet" method="post">
	<label for="city">City:</label><br>
	<input type ="text" name = "city"><br>
	<label for="state">State:</label><br>
	<input type ="text" name = "state"><br>
	<label for="zip">Zip Code:</label><br>
	<input type ="text" name = "zip"><br>
	<label for="addressName">Address Name:</label><br>
	<input type ="text" name = "addressName"><br>

<br />
<input type = "submit" value="Create New Address">
</form>
<a href = "index.html">Go home</a>
</body>
</html>