<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Title</th>
					<th>Rating</th>
					<th>Action</th>
				</tr>	
			</thead>
			<tbody>
				<c:forEach items="${ songs }" var ="song">
					<tr>
						<td><a href="/songs/${song.id}">${ song.title }</a></td>
						<td>${ song.rating }</td>
						<td>
							<form action="/delete/${ song.id }" method="post" >
								<input type="hidden" name="_method" value="DELETE"/>
								<input type="submit" value="Eliminar" class="btn btn-danger"/>
							</form>
						</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>