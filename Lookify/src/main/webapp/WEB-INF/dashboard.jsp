<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<header class="d-flex justify-content-between align-items-center">
			<h1>¡Welcome to your Dashboard!</h1>	
		</header>	
		<div class="row justify-content-between">
			<a href="/songs/new" class="btn btn-success col-3">Add New</a>
			<a href="/search/topTen" class="btn btn-primary col-3">Top Ten</a>
			<div class="col-4">
				<form action="/search" method="POST" class="row">
					<div class="col-10">
						<input type="text" name="word" class=" form-control" placeholder="Ingresar nombre">
					</div>
					<input type="submit" value="Buscar" class="col-2 btn btn-primary">
				</form>
			</div>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Title</th>
					<th>Rating</th>
					<th>Action</th>
				</tr>	
			</thead>
			<tbody>
				<c:forEach items="${ songs }" var ="song">
					<tr>
						<td><a href="/songs/${song.id}">${ song.title }</a></td>
						<td>${ song.rating }</td>
						<td>
							<form action="/delete/${ song.id }" method="post" >
								<input type="hidden" name="_method" value="DELETE"/>
								<input type="submit" value="Eliminar" class="btn btn-danger"/>
							</form>
						</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
