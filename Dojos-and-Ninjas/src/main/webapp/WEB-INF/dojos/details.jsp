<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>${ dojo.name } List</h1>
		<table class="table table-hover">
			<thead>
				<th>Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</thead>	
			<tbody>
				<c:forEach items="${ dojo.ninjas }" var="ninja">
					<tr>
						<td>
							${ ninja.name }
						</td>
						<td>${ ninja.lastName }</td>
						<td>${ ninja.age }</td>
					</tr>	
				</c:forEach>	
			</tbody>
		</table>
	</div>
</body>
</html>