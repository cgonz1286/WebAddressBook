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
	<form action = "addAddressBookServlet" method="post">
		<label for="name">Name of Address Book:</label><br>
		<input type ="text" name = "name"><br />
		
		<p>Available Contacts:</p><br />
		
		<select name="allContactsToAdd" multiple size="6">
		<c:forEach items="${requestScope.allContacts}" var="currentContact">
		   <option value = "${currentContact.contactId}">${currentContact.firstName} | ${currentContact.lastName}</option>
		</c:forEach>
		</select>
		<br />
		<input type = "submit" value="Create Address Book">
	</form>
	<a href = "index.html">Go Home.</a>
</body>
</html>