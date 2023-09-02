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
			<a href="/nuevo" class="btn btn-success">Nuevo Usuario</a>
		</header>	
		<form action="/busqueda" method="POST" class="row">
			<div class="col-10">
				<input type="text" name="palabra" class=" form-control" placeholder="Ingresar nombre">
			</div>
			<input type="submit" value="Buscar" class="col-2 btn btn-primary">
		</form>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Direccion</th>
					<th>Salon</th>
					<th>Hobbies</th>
					<th>Acciones</th>
				</tr>	
			</thead>
			<tbody>
				<c:forEach items="${ usuarios }" var ="usuario">
					<tr>
						<td>${ usuario.name }</td>
						<td>${ usuario.lastName }</td>
						<td>${ usuario.email }</td>
						<td>${ usuario.direccion.calle } ${ usuario.direccion.numero }</td>
						<td>${ usuario.salon.nombre }</td>
						<td>
							<ul>
								<c:forEach items="${ usuario.hobbies }" var = "hobby">
									<li>${ hobby.actividad }</li>	
								</c:forEach>	
							</ul>	
						</td>
						<td>
							<a href="/mostrar/${ usuario.id }" class="btn btn-info">Mostrar</a>	
							<a href="/editar/${ usuario.id }" class="btn btn-primary">Editar</a>
							<form action="/borrar/${ usuario.id }" method="post">
								<input type="hidden" name="_method" value="DELETE"/>
								<input type="submit" value="Eliminar" class="btn btn-danger"/>
							</form>
							<a href="/asignar/${usuario.id}"class="btn btn-warning">Asignar Hobby</a>
						</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>