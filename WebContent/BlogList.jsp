<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blog List</title>
</head>
<body>

<!-- Body of blog list page. (Matthew 3/19) -->
	<h1>Blogs</h1>
	<ul>
		<c:forEach var="blog" items="${blogData}">
			<li>
				<p><a href="${blog.url}">"${blog.name}"</a></p>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
