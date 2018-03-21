<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
<title>Blog List</title>
</head>
<link rel="stylesheet"
	href="https://unpkg.com/spectre.css/dist/spectre.min.css">
<link rel="stylesheet"
	href="https://unpkg.com/spectre.css/dist/spectre-exp.min.css">
<link rel="stylesheet"
	href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
<link rel="stylesheet" href="css/blog-list.css">
<link rel="stylesheet" href="css/index.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript" src="scripts/basic.js"></script>
<script type="text/javascript" src="scripts/blog-list.js"></script>

<body>

	<!-- Body of blog list page. (Matthew 3/19) -->
	<div class="container">
		<div class="columns">
			<div class="column col-6 col-gapless col-mx-auto col-ml-auto">

				<header class="navbar"> <section class="navbar-section">
				<a href="list" class="navbar-brand mr-2"><h3>Private Blog</h3></a> <a
					href="new" class="btn btn-link">New</a> <a href="logout"
					class="btn btn-link">Logout</a> </section> <section class="navbar-section">
				<div class="input-group input-inline">
					<input id="keyword" class="form-input" type="text"
						placeholder="search">
					<button id="search" class="btn btn-primary input-group-btn">Search</button>
				</div>
				</section> </header>


				<ul>
					<c:forEach var="blog" items="${blogData}">
						<li><a href="view?blogid=${blog.id}"><h4 id="title">${blog.title}</h4></a>
							<span class="text-success">${ blog.createdDate }</span>
							<p>${ blog.content }</p></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>

