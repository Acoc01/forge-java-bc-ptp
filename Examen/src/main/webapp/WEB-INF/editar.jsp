<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
			
			<form:form action="/edit/${task.id }" method="post" modelAttribute="task">
				<h1>Edit ${ task.nombre }</h1>
				<input type="hidden" name="_method" value="PUT">
				<div>
					<form:label path="nombre">Task:</form:label>
					<form:input path="nombre" class="form-control" />
					<form:errors path="nombre" class="text-danger" />
				</div>
				<div>
					<form:label path="assignee">Assignee</form:label>
					<form:select path="assignee" class="form-select">
						<c:forEach items="${usuarios}" var="usuario">
							<form:option value="${usuario.id}">${usuario.nombre}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div>
					<form:label path="priority">Priority</form:label>
					<form:select path="priority" class="form-select">
						<form:option value="High">High</form:option>
						<form:option value="Medium">Medium</form:option>
						<form:option value="Low">Low</form:option>
					</form:select>
				</div>
				<form:hidden value="${usuarioEnSesion.id}" path="host" />
				<input type="submit" value="EDIT" class="btn btn-success" />
			</form:form>
	</div>
</body>
</html>
