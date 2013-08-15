<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<title>Wiki</title>
</head>
<body>
	<h2>Wikis</h2>

	<ul>
		<c:forEach var="wiki" items="${wikis}">
			<li><a href="/wikis/${wiki.id}/pages">${wiki.name}</a>
		</c:forEach>
	</ul>

	<a href="/wikis/new">Create a new wiki</a>
</body>
</html>
