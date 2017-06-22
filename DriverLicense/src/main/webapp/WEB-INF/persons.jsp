<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Persons</title>
	</head>
	<body>
		<a href="/persons/new">Register New Person</a>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<table>
			<c:forEach items="${persons}" var="person">
				<tr>
					<td><c:out value="${person.firstName}"></c:out></td>
					<td><c:out value="${person.lastName}"></c:out></td>
					<td><a href="/persons/delete/${person.id}">Delete</a> <a href="/persons/edit/${person.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>