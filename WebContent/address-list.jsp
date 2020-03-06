<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Addresses</title>
</head>
<body>
	<form method = "post" action = "addressNavigationServlet">
		<table>
		<c:forEach items="${requestScope.allAddresses}" var="currentAddress">
		<tr>
		   <td><input type="radio" name="id" value="${currentAddress.addressId}"></td>
		   <td>${currentAddress.addressName}</td>
		   <td>${currentAddress.city}</td>
		   <td>${currentAddress.state}</td>
		   <td>${currentAddress.zip}</td>
		   
		   </tr>
		</c:forEach>
		</table>
		<input type = "submit" value = "edit" name="doThisToItem">
		<input type = "submit" value = "delete" name="doThisToItem">
		<input type="submit" value = "add" name = "doThisToItem">
	</form>
	<br />
	<a href = "index.html">Back to index</a>
</body>
</html>
