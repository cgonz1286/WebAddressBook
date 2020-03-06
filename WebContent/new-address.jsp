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
<title>Create Address</title>
</head>
<body>
	<form action="addAddressServlet" method="post">
		<table style="width: 25%">
			<tr>
				<th>City:</th>
				<td><input type="text" name="city" size="30" required></td>
			</tr>
			<tr>
				<th>State:</th>
				<td><input type="text" name="state" size="20" required></td>
			</tr>
			<tr>
				<th>Zip Code:</th>
				<td><input type="text" name="zip" size="10" required></td>
			</tr>
			<tr>
				<th>Type of Address:</th>
				<td><input type="text" name="addressType" size="30" required></td>
			</tr>
		</table>
		<br />
		<input type="submit" value="Create Address">
		<br /><br />
		<a href = "index.html">Back to index</a>
	</form>
</body>
</html>