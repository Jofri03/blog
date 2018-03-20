<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Blog Success</title>
</head>
<body>
	<h2>Edit blog success!</h2>
	<h3>You can check this blog by clicking this link:</h3>
	<a href="view?blogid=${ blog.id }">${ blog.title }</a>
	<h3>Or you can go back to the blog list:</h3>
	<a href="list">View the blog list</a>
</body>
</html>