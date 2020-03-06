<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Address BooksS</title>
</head>
<body>
	<form method = "post" action = "addressBookNavigationServlet">
		<table>
		<c:forEach items="${requestScope.allAddressBooks}" var="currentAddressBook">
		<tr>
		   <td><input type="radio" name="id" value="${currentAddressBook.id}"></td>
		   <td>${currentAddressBook.name}</td>
			    <c:forEach var = "listVal" items = "${currentAddressBook.contacts}">
		           <tr><td></td><td colspan="3">
		               ${listVal.firstName}, ${listVal.lastName}
		               </td>
			               <c:forEach var = "listValA" items = "${listVal.address}">
			           			<tr><td></td>
			           			<td colspan="3">
				               			${listValA.addressName}-
				               		</td>
			           				<td colspan="3">
				               			${listValA.city}, ${listValA.state}, ${listValA.zip}
				               		</td>
			           			</tr>
		 					</c:forEach>
		           </tr>
	 			</c:forEach>
		   </tr>
		   
		   
		</c:forEach>
		</table>
		<input type = "submit" value = "delete" name="doThisToItem">
		<input type="submit" value = "add" name = "doThisToItem">
	</form>
</body>
</html>