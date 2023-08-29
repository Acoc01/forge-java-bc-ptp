<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>${ language.name }</h1>	
		<div class="row">
			<p>Creator: ${ language.creator }</p>
			<p>Version: ${ language.currentVersion }</p>
		</div>
		<a href="/languages/edit/${ language.id }" class="btn btn-info">Edit</a>	
		<a href="/languages" class="btn btn-success">Dashboard</a>
		<form action="/delete/${ language.id }" method="post">
			<input type="hidden" name="_method" value="DELETE"/>
			<input type="submit" value="Delete" class="btn btn-danger"/>
		</form>
	</div>
</body>
</html>