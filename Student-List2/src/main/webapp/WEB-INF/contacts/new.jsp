<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Contact</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>New Contact</h1>	
		<form:form action="/contacts/create" method="post" modelAttribute="contact">
			<div>
				<form:label path="student">Student:</form:label>
				<form:select path="student" class="form-select">
					<c:forEach items="${ students }" var="student">
						<form:option value="${ student.id }">
							${ student.name } ${ student.lastName }
						</form:option>
					</c:forEach>				
				</form:select>
			</div>
			<div>
				<form:label path="address">Address:</form:label>
				<form:input path="address" class="form-control"/>
				<form:errors path="address" class="text-danger"/>
			</div>
			<div>
				<form:label path="city">City:</form:label>
				<form:input path="city" class="form-control"/>
				<form:errors path="city" class="text-danger"/>
			</div>
			<div>
				<form:label path="state">State:</form:label>
				<form:input path="state"  class="form-control"/>
				<form:errors path="state" class="text-danger"/>
			</div>
			<input type="submit" value="Create" class="btn btn-success mt-3"/>
		</form:form>
	</div>
</body>
</html>
