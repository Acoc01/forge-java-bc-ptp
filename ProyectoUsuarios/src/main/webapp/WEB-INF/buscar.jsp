<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Busqueda: ${ palabra }</h1>	
		<table class="table table-striped">
			<thead>
				<th>Nombre</th>	
				<th>Apellido</th>	
				<th>Email</th>	
			</thead>	
			<tbody>
				<c:forEach items="${ usuarios }" var="usuario">
					<tr>
						<td>${ usuario.name }</td>	
						<td>${ usuario.lastName }</td>	
						<td>${ usuario.email }</td>	
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/dashboard" class="btn btn-primary">Regresar a Dashboard</a>
	</div>
</body>
</html>