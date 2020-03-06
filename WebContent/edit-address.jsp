<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Address</title>
</head>
<body>
	<form action = "editAddressServlet" method="post">
	
		<input type = "hidden" name = "id" value="${toEdit.addressId}">
		
		<label for="city">City:</label><br>
		<input type ="text" name = "city" value = "${toEdit.city}"><br>
		
		<label for="state">State:</label><br>
		<input type ="text" name = "state" value = "${toEdit.state}"><br>
		
		<label for="zip">Zip Code:</label><br>
		<input type ="text" name = "zip" value = "${toEdit.zip}"><br>
		
		<label for="addressName">Address Name:</label><br>
		<input type ="text" name = "addressName" value = "${toEdit.addressName}"><br>
		
		<input type = "submit" value="Save Edited Address">
	</form>
	<br />
	<a href = "index.html">Back to index</a>
</body>
</html>