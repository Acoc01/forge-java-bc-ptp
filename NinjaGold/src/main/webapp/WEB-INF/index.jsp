<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Tu puntuacion: ${ gold }</h1>
		<div class="row">
			<div class="col border">
				<h3>Granja</h3>	
				<p>Ganas 10 - 20 monedas</p>
				<form method="post" action="/granja">
					<input type="hidden" name="lugar" value="granja">
					<input type="submit" value="¡Encontrar Oro!" class="btn btn-success">
				</form>
			</div>
			<div class="col border">
				<h3>Cueva</h3>	
				<p>Ganas 5 - 10 monedas</p>
				<form method="post" action="/cueva">
					<input type="hidden" name="lugar" value="cueva">
					<input type="submit" value="¡Encontrar Oro!" class="btn btn-info">
				</form>
			</div>
			<div class="col border">
				<h3>Casa</h3>	
				<p>Ganas 2 - 5 monedas</p>
				<form method="post" action="/casa">
					<input type="hidden" name="lugar" value="casa">
					<input type="submit" value="¡Encontrar Oro!" class="btn btn-primary">
				</form>
			</div>
			<div class="col border">
				<h3>Casino</h3>	
				<p>Ganas/Pierdes 0 - 50 monedas</p>
				<form method="post" action="/casino">
					<input type="hidden" name="lugar" value="casino">
					<input type="submit" value="¡Encontrar Oro!" class="btn btn-danger">
				</form>
			</div>
			<div class="col border">
				<h3>SPA</h3>	
				<p>Pierdes 5 - 20 monedas</p>
				<form method="post" action="/spa">
					<input type="hidden" name="lugar" value="spa">
					<input type="submit" value="¡Encontrar Oro!" class="btn btn-danger">
				</form>
			</div>
		</div>

		<div class="row">
			<h2>Actividades</h2>
			<div class="card">
				<div class="card-body">
					<c:forEach items="${ historial }"	var="actividad">
						<c:if test="${ actividad.contains('ganaste') }">
							<p class="text-success">${ actividad }</p>
						</c:if>	
						<c:if test="${ actividad.contains('perdiste') }">
							<p class="text-danger">${ actividad }</p>
						</c:if>	
					</c:forEach>
				</div>	
			</div>
		</div>
	</div>
</body>
</html>