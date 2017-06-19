<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ninja Gold</title>
	</head>
	<body>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<h1>Your Gold <%= session.getAttribute("gold") %></h1>
		<form action="/" method="post">
			Farm <input type="text" name="place" value="farm" style="display: none">
			<button>Find Gold!</button>
		</form>
		<form action="/" method="post">
			Cave <input type="text" name="place" value="cave" style="display: none">
			<button>Find Gold!</button>
		</form>
		<form action="/" method="post">
			House <input type="text" name="place" value="house" style="display: none">
			<button>Find Gold!</button>
		</form>
		<form action="/" method="post">
			Casino <input type="text" name="place" value="casino" style="display: none">
			<button>Find Gold!</button>
		</form>
		<% if (session.getAttribute("loot") != null) { %>
			<% if (Integer.parseInt(session.getAttribute("loot").toString()) >= 0) { %>
				<p style="color: green">you entered a <%= session.getAttribute("place") %> and earned <%= session.getAttribute("loot") %></p>
			<% } else { %>
				<p style="color: red">you entered a <%= session.getAttribute("place") %> and lost <%= session.getAttribute("loot") %></p>
			<% } %>
		<% } %>
		<c:forEach items="${history}" var="history">
		    <td><c:out value="${history}"/></td>
		</c:forEach>
		<%= session.getAttribute("history") %>
	</body>
</html>