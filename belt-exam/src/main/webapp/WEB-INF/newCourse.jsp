<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Course</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Create a new course</h1>	
		<form:form action="/courses/create" method="POST" modelAttribute="course" >
			<div>
				<form:label path="nombre">Name:</form:label>
				<form:input path="nombre" class="form-control"/>	
				<form:errors path="nombre" class="text-danger"/>
			</div>	
			<div>
				<form:label path="instructor">Instructor:</form:label>
				<form:input path="instructor" class="form-control"/>	
				<form:errors path="instructor" class="text-danger"/>
			</div>	
			<div>
				<form:label path="capacidad">Capacity:</form:label>
				<form:input path="capacidad" class="form-control"/>	
				<form:errors path="capacidad" class="text-danger"/>
			</div>	
			<form:hidden value="${ user.id }" path="host"/>
			<input type="submit" value="Create" class="btn btn-success"/>
		</form:form>
	</div>
</body>
</html>