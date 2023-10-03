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
			
			<form:form action="/course/${ course.id }/edit" method="post" modelAttribute="course">
				<h1>Edit ${ course.nombre }</h1>
				<input type="hidden" name="_method" value="PUT">
				<div>
					<form:label path="nombre">Name:</form:label>
					<form:input path="nombre" class="form-control" />
					<form:errors path="nombre" class="text-danger" />
				</div>
				<div>
					<form:label path="instructor">Instructor:</form:label>
					<form:input path="instructor" class="form-control" />
					<form:errors path="instructor" class="text-danger" />
				</div>
				<div>
					<form:label path="capacidad">Capacity:</form:label>
					<form:input path="capacidad" class="form-control" />
					<form:errors path="capacidad" class="text-danger" />
				</div>
				<form:hidden value="${usuarioEnSesion.id}" path="host" />
				<!--TODOS LOS ERRORES: <form:errors path="*" class="text-danger" />  -->
				<input type="submit" value="Update" class="btn btn-success" />
			</form:form>
	</div>
</body>
</html>