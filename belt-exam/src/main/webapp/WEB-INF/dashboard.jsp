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
			<h1>¡Bienvenid@ ${user.nombre}!</h1>
			<a href="/logout" class="btn btn-danger">Cerrar Sesión</a>
		</nav>
		<div class="row">
			<h2>Cursos disponibles</h2>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Course</th>
						<th>Instructor</th>
						<th>Signups</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${courses}" var="course">
						<tr>
								<td><a href="/course/${course.id}">${course.nombre}</a></td>
								<td>${course.instructor}</td>
								<td>${course.students.size()}/${course.capacidad}</td>
								<td>
									<c:if test="${ course.students.size() == course.capacidad }">
										<c:choose>
											<c:when test="${course.students.contains(user)}">
												<div>Already Added</div>
											</c:when>
											<c:otherwise>
												<div>Full</div>
											</c:otherwise>
										</c:choose>
									</c:if>
									<c:if test="${ course.students.size() < course.capacidad }">
										<c:choose>
											<c:when test="${course.students.contains(user)}">
												<div>Already Added</div>
											</c:when>
											<c:otherwise>
												<a href="/add/${course.id}">Add</a>
											</c:otherwise>
										</c:choose>
									</c:if>
									
								</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<a class="btn btn-success" href="/courses/new">Add a course</a>
	</div>
</body>
</html>