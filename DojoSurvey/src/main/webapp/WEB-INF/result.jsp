<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Survey Result</title>
	</head>
	<body>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<h1>Submitted info</h1>
		<p>Name : <c:out value="${name}"/>
		<p>Language : <c:out value="${language}"/>
		<p>Location : <c:out value="${location}"/>
		<p>Comment : <c:out value="${comment}"/>
	</body>
</html>