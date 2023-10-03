<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ver Task</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<h2>Task: ${task.nombre }</h2>
			<p>Creator: ${task.host.nombre }</p>
			<p>Assignee: ${task.assignee.nombre }</p>
			<p>Priority: ${task.priority }</p>
		</div>
		<div class="row">
			<a href="/tasks/${task.id}/edit" class="btn btn-success">EDIT</a>
			<form action="/tasks/delete/${task.id }" method="post">
				<input type="hidden" name = "_method" value="DELETE"/>
				<input type="submit" value="DELETE" class="btn btn-danger"/>
			</form>
			<form action="/tasks/completed/${task.id }" method="post">
				<input type="submit" value="COMPLETED" class="btn btn-primary"/>
			</form>
		</div>
	</div>
</body>
</html>
