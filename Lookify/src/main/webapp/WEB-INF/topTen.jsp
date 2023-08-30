<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top 10</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<header class="d-flex justify-content-between align-items-center">
			<h1>Top Ten Songs</h1>	
			<a href="/dashboard" class="btn btn-success ml-auto">Dashboard</a>	
		</header>	
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Title</th>
					<th>Rating</th>
				</tr>	
			</thead>
			<tbody>
				<c:forEach items="${ songs }" var ="song">
					<tr>
						<td><a href="/songs/${song.id}">${ song.title }</a></td>
						<td>${ song.rating }</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
