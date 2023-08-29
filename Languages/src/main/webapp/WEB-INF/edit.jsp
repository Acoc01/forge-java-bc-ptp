<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Edit ${ language.name }</h1>	
		<a href="/languages" class="btn btn-success">Dashboard</a>
		<form action="/delete/${ language.id }" method="post">
			<input type="hidden" name="_method" value="DELETE"/>
			<input type="submit" value="Delete" class="btn btn-danger"/>
		</form>
		<form:form action="/languages/${ language.id }" method="post" modelAttribute="language">
		<input type="hidden" name="_method" value="put">
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
</body>
</html>