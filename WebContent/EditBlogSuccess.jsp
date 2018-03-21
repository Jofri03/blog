<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
 <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
	<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-exp.min.css">
	<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
	<link rel="stylesheet" href="css/index.css">
	<style>
		div.container>div>div {
			text-align:center;
		}
	</style>
	
  </head>
<body>
  <div class="container">
  	<div class="columns">
  		<div class="column col-6 col-gapless col-mx-auto col-ml-auto">
			<h4 class="text-success">Congratulations! You have created a blog!</h4></br></br>
			<span>You can check this blog by clicking this link:</span>
			<a href="view?blogid=${ blog.id }">${ blog.title }</a></br>
			<span>Or you can go back to the blog list:</span>
			<a href="list">Blog list</a>
		</div>
	</div>
</div>
</body>
</html>