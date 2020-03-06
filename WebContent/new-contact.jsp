<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
th, td {
  padding: 1px;
  text-align: left; 
  vertical-align: center;
}
</style>
<title>Create Contact</title>
</head>
<body>
	<form action="addContactServlet" method="post">
		<table style="width: 30%">
			<tr>
				<th>First Name:</th>
				<td><input type="text" name="firstName" size="50" required></td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td><input type="text" name="lastName" size="50" required></td>
			</tr>
			<tr>
				<th>Assign Address(es) to Contact:</th>
				<td>
					<select name="allAddressesToAdd" multiple size="5">
						<c:forEach items="${requestScope.allAddresses}" var="currentAddress">
			  				<option value="${currentAddress.addressId}">${currentAddress.city}, ${currentAddress.state}</option>
						</c:forEach>
					</select>
					<br />
				</td>
			</tr>
			<tr>
				<th><input type="submit" value="Create Contact & Assign Address(es)"></th>
			</tr>
		</table>
		<br />
		<a href="index.html">Back to index</a>
	</form>
</body>
</html>