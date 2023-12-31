<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form:form action="/crear" method="post" modelAttribute="usuario">
			<h1>Nuevo Usuario</h1>	
			<div>
				<form:label path="name">Nombre:</form:label>	
				<form:input path="name" class="form-control"/>
				<form:errors path="name" class="text-danger"/>
			</div>
			<div>
				<form:label path="lastName">Apellido:</form:label>	
				<form:input path="lastName" class="form-control"/>
				<form:errors path="lastName" class="text-danger"/>
			</div>
			<div>
				<form:label path="email">Email:</form:label>	
				<form:input path="email" class="form-control"/>
				<form:errors path="email" class="text-danger"/>
			</div>
			<div>
				<form:label path="password">Password:</form:label>	
				<form:password path="password" class="form-control"/>
				<form:errors path="password" class="text-danger"/>
			</div>
			<div>
				<form:label path="salon">Salon</form:label>
				<form:select path="salon" class="form-select">
					<c:forEach items="${ salones }" var="salon">
						<form:option value="${ salon.id }">
							${ salon.nombre }	
						</form:option>
					</c:forEach>
				</form:select>
			</div>
			<input type="submit" value="Guardar" class="btn btn-success mt-3" />
		</form:form>	
	</div>
</body>
</html>