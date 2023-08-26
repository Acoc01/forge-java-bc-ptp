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
		<form:form action="/crear" method="post" modelAttribute="receta">
			<h1>Nueva Receta</h1>	
			<div>
				<form:label path="name">Nombre:</form:label>	
				<form:input path="name" class="form-control"/>
				<form:errors path="name" class="text-danger"/>
			</div>
			<div>
				<form:label path="duration">Duracion:</form:label>	
				<form:input path="duration" class="form-control"/>
				<form:errors path="duration" class="text-danger"/>
			</div>
			<div>
				<form:label path="description">Description:</form:label>	
				<form:input path="description" class="form-control"/>
				<form:errors path="description" class="text-danger"/>
			</div>
			<input type="submit" value="Guardar" class="btn btn-success mt-3" />
		</form:form>	
	</div>
</body>
</html>
