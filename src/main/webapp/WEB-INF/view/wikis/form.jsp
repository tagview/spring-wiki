<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a new Wiki</title>
</head>
<body>
	<h2>New Wiki</h2>
	
	<form:form action="/wikis" method="POST" modelAttribute="wiki">
		<form:input path="name" />
		<form:errors path="name" />
				
		<button type="submit">Save</button>
	</form:form>
</body>
</html>