<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<title>${wiki.name}</title>
</head>
<body>
	<h2>Pages</h2>

	<ul>
		<c:forEach var="page" items="${pages}">
			<li><a href="/wikis/${wiki.id}/pages/${page.id}">${page.title}</a>
		</c:forEach>
	</ul>

	<a href="/wikis/${wiki.id}/pages/new">Create a new page</a>
</body>
</html>
