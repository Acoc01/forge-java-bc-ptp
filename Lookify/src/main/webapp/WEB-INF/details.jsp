<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css/">
</head>
<body>
	<div class="container vh-100">
		<div class="d-flex justify-content-center align-items-center">
			<div class="row">
			
				<div class="d-flex justify-content-end">
					<a href="/dashboard" class="btn btn-success ml-auto">Dashboard</a>	
				</div>
				<p>Title: ${ song.title }</p>
				<p>Artist: ${ song.artist }</p>
				<p>Rating: ${ song.rating }</p>
				<form action="/delete/${ song.id }" method="post" class="mt-4" >
					<input type="hidden" name="_method" value="DELETE"/>
					<input type="submit" value="Eliminar" class="btn btn-danger"/>
				</form>
			</div>
		</div>
	</div>
</body>
</html>