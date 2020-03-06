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
	<form method = "post" action = "addressNavigationServlet">
		<table>
		<c:forEach items="${requestScope.allContacts}" var="currentContact">
		<tr>
		   <td><input type="radio" name="id" value="${currentContact.contactId}"></td>
		   <td>${currentContact.firstName}</td>
		   <td>${currentContact.lastName}</td>
			    <c:forEach var = "listVal" items = "${currentContact.address}">
		           <tr><td></td><td colspan="3">
		               ${listVal.city}, ${listVal.state}
		               </td>
		           </tr>
	 			</c:forEach>
		   </tr>
		   
		   
		</c:forEach>
		</table>
		<input type = "submit" value = "edit" name="doThisToItem">
		<input type = "submit" value = "delete" name="doThisToItem">
		<input type="submit" value = "add" name = "doThisToItem">
	</form>
</body>
</html>