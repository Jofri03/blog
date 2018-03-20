<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>${ blog.title }</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="scripts/view-blog.js"></script>
    <script type="text/javascript" src="scripts/basic.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
	<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-exp.min.css">
	<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
	<link rel="stylesheet" href="css/index.css">

</head>
<body>

<div class="container">
  		<div class="columns">
  		<div class="column col-6 col-gapless col-mx-auto col-ml-auto">
  		
<header class="navbar">
  <section class="navbar-section">
    <a href="list" class="navbar-brand mr-2">Private Blog</a>
    <a href="new" class="btn btn-link">New</a>
  </section>
  <section class="navbar-section">
    <div class="input-group input-inline">
      <input class="form-input" type="text" placeholder="search">
      <button class="btn btn-primary input-group-btn">Search</button>
    </div>
  </section>
</header>
<input id="blog_id" type="hidden" value="${ blog.id }" />
<a href="view?blogid=${blog.id}"><h3 id="title">${blog.title}</h3></a>
				<span class="text-success">${ blog.createdDate }</span>
				
<p id="content">${ blog.content }</p>


<div id="manage">
	<button id="edit_btn" class="btn btn-success">Edit</button>
<button id="delete_btn" class="btn btn-error">Delete</button>
</div>

</div></div></div>
<div id="loading" class="loading loading-lg"></div>
</body>
</html>