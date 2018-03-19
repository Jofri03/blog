<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Edit Blog</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="scripts/edit-blog.js"></script>

</head>
<body>
  <input type="hidden" id="blogid" value="${ blog.id }" />
  <input type="text" id="title" value="${ blog.title }" /><br  />
  <textarea id="content">${ blog.content }</textarea><br />
  <input type="submit" id="submit" value="Save" />
</body>
</html>