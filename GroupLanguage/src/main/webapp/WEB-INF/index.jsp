<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Languages</title>
	</head>
	<body>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<table>
		<c:forEach items="${languages}" var="language" varStatus="loop">
		    <tr>      
		        <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
		        <td><c:out value="${language.creator}"/></td>
		        <td><c:out value="${language.version}"/></td>
		        <td><a href="/languages/delete/${language.id}">Delete</a> <a href="/languages/edit/${language.id}">Edit</a></td>
		    </tr>
		</c:forEach>
		</table>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		<form:form method="POST" action="/languages" modelAttribute="language">
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