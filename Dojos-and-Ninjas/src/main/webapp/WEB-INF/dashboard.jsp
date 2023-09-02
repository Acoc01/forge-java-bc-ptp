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
			<h1>¡Welcome to your Dashboard!</h1>	
			<a href="/dojos/new" class="btn btn-success">New Dojo</a>
			<a href="/ninjas/new" class="btn btn-success">New Ninja</a>
		</header>	
		<table class="table table-hover">
			<thead>
				<th>Dojo</th>
				<th>Students</th>
			</thead>	
			<tbody>
				<c:forEach items="${ dojos }" var="dojo">
					<tr>
						<td>
							<a href="/dojos/${ dojo.id }">${ dojo.name }</a>	
						</td>
						<td>${ dojo.ninjas.size() }</td>
					</tr>	
				</c:forEach>	
			</tbody>
		</table>
	</div>

</body>
</html>