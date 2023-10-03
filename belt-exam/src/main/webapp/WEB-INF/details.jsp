<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	
		<h1>${ course.nombre }</h1>
		<div class="row">
			<div>Instructor: ${course.instructor }</div>	
			<div>Sign Ups: ${ course.students.size() }</div>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>	
					<th>Sign Up Date</th>	
					<th>Action</th>	
				</tr>	
			</thead>	
			<tbody>
				<c:forEach items="${ students }" var="student">
					<tr>
						<td>${ student.nombre }</td>	
						<td>No pude obtener la fecha</td>	
						<c:if test="${ student.id == user.id }">
							<td><a href="/quitar/${ student.id }">Remove</a></td>
						</c:if>
					</tr>	
				</c:forEach>	
			</tbody>
		</table>
		<c:if test="${ course.host.id == user.id }">
			<form action="/course/delete/${ course.id }" method="post">
				<input type="hidden" name="_method" value="DELETE"/>
				<input type="submit" value="DELETE" class="btn btn-danger"/>
			</form>
			<a href="/courses/${course.id }/edit" class="btn btn-primary">EDIT</a>
		</c:if>
	</div>
</body>
</html>