<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>${ persona.name } ${ persona.lastName }</h1>	
		<div class="mt-3">
			<p>License Number: ${ persona.licencia.number }</p>	
			<p>State: ${ persona.licencia.state }</p>
			<p>Expiration Date: ${ persona.licencia.expiration_date }</p>
		</div>
		<a href="/dashboard" class="btn btn-primary">Dashboard</a>
	</div>
</body>
</html>