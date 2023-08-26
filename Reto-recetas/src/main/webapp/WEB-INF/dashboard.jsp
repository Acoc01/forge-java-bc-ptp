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
			<h1>¡Bienvenid@ a tu Dashboard!</h1>	
			<a href="/nuevo" class="btn btn-success">Nueva Receta</a>
		</header>	
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Duracion</th>
					<th>Descripcion</th>
					<th>Acciones</th>
				</tr>	
			</thead>
			<tbody>
				<c:forEach items="${ recetas }" var ="usuario">
					<tr>
						<td>${ usuario.name }</td>
						<td>${ usuario.duration } minutos</td>
						<td>${ usuario.description }</td>
						<td>
							<a href="/mostrar/${ usuario.id }" class="btn btn-info">Mostrar</a>	
						</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
