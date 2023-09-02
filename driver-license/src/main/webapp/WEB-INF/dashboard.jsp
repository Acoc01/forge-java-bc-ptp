<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<header class="d-flex justify-content-between align-items-center">
			<h1>¡Bienvenid@ a tu Dashboard!</h1>	
			<a href="/personas/new" class="btn btn-success">Nueva Persona</a>
			<a href="/licencias/new" class="btn btn-success">Nueva Licencia</a>
		</header>	
		<table class="table table-hover">
			<thead>
				<th>Nombre</th>	
				<th>Licencia</th>
			</thead>
			<tbody>
				<c:forEach items="${ personas }" var = "persona">
					<tr>
						<td>
							<a href="/personas/${ persona.id }">${ persona.name } ${ persona.lastName }</a>
						</td>	
						<td>
							${ persona.licencia.number }	
						</td>	
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>