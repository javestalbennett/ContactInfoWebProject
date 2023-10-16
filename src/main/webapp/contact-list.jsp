<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact List</title>
</head>
<body>

	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allContacts}" var="currentcontact">
				<tr>
					<td><input type="radio" name="id" value="${currentcontact.id}"></td>
					<td>${currentcontact.name}</td>
					<td>${currentcontact.phoneNumber}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToItem"> <input
			type="submit" value="delete" name="doThisToItem"> <input
			type="submit" value="add" name="doThisToItem">
	</form>

	<table>

	</table>
</body>
</html>