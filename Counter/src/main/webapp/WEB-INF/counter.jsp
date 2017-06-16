<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Counter</title>
	</head>
	<body>
		<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<p>You have visited this page <span id="counter"><c:out value="${counter}"/></span> times </p>
		<a href="/">Test another visit?</a>
		<br>
		<a href="/reset">Reset Counter</a>
	</body>
</html>