<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit Book</title>
	</head>
	<body>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<c:out value="${language.name}"/>
		<c:out value="${language.creator}"/>
		<c:out value="${language.version}"/>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		<form:form method="POST" action="/languages/edit/${id}" modelAttribute="language">
			<div>
			    <form:label path="name">Name
			    <form:errors path="name"/>
			    <form:input path="name"/></form:label>
		    </div>
		    <div>
			    <form:label path="creator">Creator
			    <form:errors path="creator"/>
			    <form:textarea path="creator"/></form:label>
		    </div>
		    <div>
			    <form:label path="version">Version
			    <form:errors path="version"/>
			    <form:input path="version"/></form:label>
		    </div>
		    <div>
		    	<input type="submit" value="Submit"/>
		    </div>
		</form:form>
	</body>
</html>