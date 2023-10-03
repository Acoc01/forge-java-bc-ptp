<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
			
			<form:form action="/evento/${ evento.id }/edit" method="post" modelAttribute="evento">
				<h1>Editar Evento</h1>
				<input type="hidden" name="_method" value="PUT">
				<div>
					<form:label path="nombre">Nombre:</form:label>
					<form:input path="nombre" class="form-control" />
					<form:errors path="nombre" class="text-danger" />
				</div>
				<div>
					<form:label path="fecha">Fecha:</form:label>
					<form:input type="date" path="fecha" class="form-control" />
					<form:errors path="fecha" class="text-danger" />
				</div>
				<div>
					<form:label path="ubicacion">Ubicación:</form:label>
					<form:input path="ubicacion" class="form-control" />
					<form:errors path="ubicacion" class="text-danger" />
				</div>
				<div>
					<form:label path="estado">Estado</form:label>
					<form:select path="estado" class="form-select">
						<c:forEach items="${estados}" var="state">
							<form:option value="${state}">${state}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<form:hidden value="${usuarioEnSesion.id}" path="host" />
				<!--TODOS LOS ERRORES: <form:errors path="*" class="text-danger" />  -->
				<input type="submit" value="Crear Evento" class="btn btn-success" />
			</form:form>
	</div>
</body>
</html>