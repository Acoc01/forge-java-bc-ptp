<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nueva Licencia</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>New License</h1>	
		<form:form action="/licencias/create" method="post" modelAttribute="licencia">
			<div>
				<form:label path="persona">Person:</form:label>
				<form:select path="persona" class="form-select">
					<c:forEach items="${ personas }" var="persona">
						<form:option value="${ persona.id }">
							${ persona.name } ${ persona.lastName }
						</form:option>
					</c:forEach>				
				</form:select>
			</div>
			<div>
				<form:label path="state">State:</form:label>
				<form:input path="state" class="form-control"/>
				<form:errors path="state" class="text-danger"/>
			</div>
			<div>
				<form:label path="number">Number:</form:label>
				<form:input path="number" class="form-control"/>
				<form:errors path="number" class="text-danger"/>
			</div>
			<div>
				<form:label path="expiration_date">Expiration Date:</form:label>
				<form:input path="expiration_date" type="date" class="form-control"/>
				<form:errors path="state" class="text-danger"/>
			</div>
			<input type="submit" value="Create" class="btn btn-success mt-3"/>
		</form:form>
	</div>
</body>
</html>
