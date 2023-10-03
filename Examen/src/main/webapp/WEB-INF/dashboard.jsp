<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<nav class="d-flex justify-content-between align-items-center">
			<h1>¡Bienvenid@ ${usuarioEnSesion.nombre}!</h1>
			<a href="/logout" class="btn btn-danger">Cerrar Sesión</a>
		</nav>
		<div class="row">
			<h2>Tareas</h2>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Task</th>
						<th>Creator</th>
						<th>Assignee</th>
						<th>Priority</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tasks}" var="task">
						<tr>
							<td><a href="/tasks/${task.id}">${task.nombre}</a></td>
							<td>${task.host.nombre}</td>
							<td>${task.assignee.nombre}</td>
							<td>${task.priority}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<a href="/tasks/new" class="btn btn-success">Create Task</a>
	</div>
</body>
</html>
