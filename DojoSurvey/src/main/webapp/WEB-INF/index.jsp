<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Dojo Survey</title>
	</head>
	<body>
		<form action="/survey" method="post">
			<p>Your Name: <input type="text" name="name"></p>
	        <p>Dojo Location: <input type="text" name="location"></p>
	        <p>Favorite Language: 
				<select name="language">
					<option value="Python">Python</option>
					<option value="JavaScript">JavaScript</option>
					<option value="TypeScript">TypeScript</option>
					<option value="Java">Java</option>
				</select>
			</p>
			<textarea rows="40" cols="40" name="comment"></textarea>
	        <button>Button</button>
		</form>
	</body>
</html>