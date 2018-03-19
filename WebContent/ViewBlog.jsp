<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<<<<<<< HEAD
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${ blog.title }</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	    <script type="text/javascript" src="scripts/view-blog.js"></script>
	</head>
<body>
<div id="manage">
	<input id="edit_btn" type="submit" value="Edit" /><br />
	<input id="delete_btn" type="submit" value="Delete" />
</div>
<input id="blog_id" type="hidden" value="${ blog.id }" />
=======
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${ blog.title }</title>
</head>
<body>
>>>>>>> 6ccf5e89bdbbb925a47f9b15f3618d2057336a84
<label id="title">${ blog.title }</label><br />
<label id="created_time">${ blog.createdDate }</label><br />
<p id="content">${ blog.content }</p>
</body>
</html>