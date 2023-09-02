<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
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
			<a href="/students/new" class="btn btn-success">New Student</a>
			<a href="/contacts/new" class="btn btn-success">New Contact</a>
			<a href="/dormitory/new" class="btn btn-success">New Dormitory</a>
		</header>	
		<table class="table table-hover">
			<thead>
				<th>Name</th>	
				<th>Age</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
				<th>Dormitory</th>
			</thead>
			<tbody>
				<c:forEach items="${ students }" var = "student">
					<tr>
						<td>
							${ student.name } ${ student.lastName }
						</td>	
						<td>
							${ student.age }
						</td>	
						<td>
							${ student.contact.address }
						</td>	
						<td>
							${ student.contact.city }
						</td>	
						<td>
							${ student.contact.state }
						</td>	
						<td>
							${ student.dormitory.name }
						</td>	
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table class="table table-hover mt-5">
			<thead>
				<th>Name</th>	
				<th>Students</th>
			</thead>
			<tbody>
				<c:forEach items="${ dorms }" var = "dorm">
					<tr>
						<td>
							<a href="/dormitory/${ dorm.id }">${ dorm.name }</a>	
						</td>	
						<td>
							${ dorm.students.size() }
						</td>	
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
