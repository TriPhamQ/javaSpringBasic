<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit Person</title>
	</head>
	<body>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		<form:form method="put" action="/persons/edit/${person.id}" modelAttribute="person">
			<div>
				<form:label path="firstName">First Name</form:label>
				<form:input path="firstName"/>
				<form:errors path="firstName"></form:errors>
			</div>
			<div>
				<form:label path="lastName">Last Name</form:label>
				<form:input path="lastName"/>
				<form:errors path="lastName"></form:errors>
			</div>
			<div>
				<form:hidden path="createdAt"></form:hidden>
			</div>
			<div>
				<button>Submit</button>
			</div>
		</form:form>
	</body>
</html>