<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Books</title>
	</head>
	<body>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<!-- ... -->
		<table>
		<c:forEach items="${books}" var="book">
		    <tr>      
		        <td><c:out value="${book.title}"/></td>
		        <td><c:out value="${book.description}"/></td>
		        <td><c:out value="${book.language}"/></td>
		        <td><c:out value="${book.numberOfPages}"/></td>
		    </tr>
		</c:forEach>
		</table>
	</body>
</html>