<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Survey</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css/">
</head>
<body>
	<div class="container border border-black">
		<form action="/" method="POST">
			<div class="row">
				<p class="col">Nombre:</p>
				<input id="nombreId" type="text" name="nombre" placeholder="Escribe tu nombre" class="form-control col">
			</div>
			<div class="row">
				<p class="col">Ubicacion del Dojo:</p>
				<select class="col form-control" id="location" name="ubicacion">
					<option>San Jose</option>	
					<option>No se otras ubicaciones</option>
				</select>
			</div>
			<div class="row">
				<p class="col">Lenguaje Favorito:</p>
				<select class="col form-control" id="favorite" name="favorito">
					<option>Python</option>	
					<option>Java</option>
				</select>
			</div>
			<div class="">
				<label for="comment">Comment:</label>
				<textarea class="form-control" id="comment" name="comentario" rows="3"></textarea>
			</div>
			<input type="submit" value="Enviar" class="btn btn-success">
		</form>
	</div>
</body>
</html>