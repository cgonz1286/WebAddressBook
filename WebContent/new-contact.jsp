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
	<form action = "addContactServlet" method="post">
		<label for="firstName">First Name:</label><br>
		<input type ="text" name = "firstName"><br />
		<label for="city">Last Name:</label><br>
		<input type ="text" name = "lastName"><br />
		
		<p>Available Address:</p><br />
		
		<select name="allAddressesToAdd" multiple size="6">
		<c:forEach items="${requestScope.allAddresses}" var="currentAddress">
		   <option value = "${currentAddress.addressId}">${currentAddress.city} | ${currentAddress.state}</option>
		</c:forEach>
		</select>
		<br />
		<input type = "submit" value="Create List and Add Items">
	</form>
	<a href = "index.html">Go add new items instead.</a>
</body>
</html>