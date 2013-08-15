<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a new Page</title>
</head>
<body>
	<h2>New Page</h2>
	
	<form:form action="/pages" method="POST" modelAttribute="page">
		<form:input path="title" />
		<form:errors path="title" />
		
		<form:textarea path="body" />
		<form:errors path="body" />
		
		<button type="submit">Save</button>
	</form:form>
</body>
</html>