<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>	
			</thead>
			<tbody>
				<c:forEach items="${ languages }" var ="language">
					<tr>
						<td>
							<a href="/languages/${ language.id }">
								${ language.name }
							</a>
						</td>
						<td>${ language.creator }</td>
						<td>${ language.currentVersion }</td>
						<td>
							<a href="/languages/edit/${ language.id }" class="btn btn-info">Edit</a>	
							<form action="/delete/${ language.id }" method="post">
								<input type="hidden" name="_method" value="DELETE"/>
								<input type="submit" value="Delete" class="btn btn-danger"/>
							</form>
						</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
		<div class="row">
			<form:form action="/languages" method="post" modelAttribute="language">
				<h1>New Language</h1>	
				<div>
					<form:label path="name">Name:</form:label>	
					<form:input path="name" class="form-control"/>
					<form:errors path="name" class="text-danger"/>
				</div>
				<div>
					<form:label path="creator">Creator:</form:label>	
					<form:input path="creator" class="form-control"/>
					<form:errors path="creator" class="text-danger"/>
				</div>
				<div>
					<form:label path="currentVersion">Version:</form:label>	
					<form:input path="currentVersion" class="form-control"/>
					<form:errors path="currentVersion" class="text-danger"/>
				</div>
				<input type="submit" value="Guardar" class="btn btn-success mt-3" />
			</form:form>	
		</div>
	</div>
</body>
</html>