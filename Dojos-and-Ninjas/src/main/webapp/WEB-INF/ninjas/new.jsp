<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>New Ninja</h1>	
		<form:form action="/ninjas/create" method="POST" modelAttribute="ninja">
			<div>
				<form:label path="dojo">Dojo:</form:label>	
				<form:select path="dojo" class="form-select">
					<c:forEach items="${ dojos }" var="dojo">
						<form:option value="${ dojo.id }">
							${ dojo.name }	
						</form:option>	
					</c:forEach>	
				</form:select>
			</div>	
			<div>
				<form:label path="name">Name:</form:label>	
				<form:input path="name" class="form-control"/>
				<form:errors path="name" class="text-danger"/>	
			</div>
			<div>
				<form:label path="lastName">Last Name:</form:label>	
				<form:input path="lastName" class="form-control"/>
				<form:errors path="lastName" class="text-danger"/>	
			</div>
			<div>
				<form:label path="age">Age:</form:label>	
				<form:input path="age" class="form-control"/>
				<form:errors path="age" class="text-danger"/>	
			</div>
			<input type="submit" value="Save" class="btn btn-success mt-3"/>
		</form:form>
	</div>
</body>
</html>