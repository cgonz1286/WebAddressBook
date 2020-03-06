<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Contacts</title>
</head>
<body>
	<form method = "post" action = "contactNavigationServlet">
		<table>
		<c:forEach items="${requestScope.allContacts}" var="currentContact">
		<tr>
		   <td><input type="radio" name="id" value="${currentContact.contactId}"></td>
		   <td>${currentContact.firstName} ${currentContact.lastName}</td>
			    <c:forEach var = "listVal" items = "${currentContact.address}">
		           <tr><td></td><td colspan="3">
		               ${listVal.addressName}: ${listVal.city}, ${listVal.state}
		               </td>
		           </tr>
	 			</c:forEach>
		   </tr>
		   
		   
		</c:forEach>
		</table>
		<input type = "submit" value = "delete" name="doThisToItem">
		<input type="submit" value = "add" name = "doThisToItem">
	</form>
	<br />
	<a href = "index.html">Back to index</a>
</body>
</html>