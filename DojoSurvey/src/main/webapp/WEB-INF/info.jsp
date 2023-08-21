<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css/">
</head>
<body>
	<div class="container border border-black margin-auto">
		<div class="row justify-content-center align-items-center m-auto">
			<h3>Submitted info</h3>
			<div class="d-flex justify-content-around">
				<p class="col-6">Name: </p>
				<p class="col-6"><c:out value="${ surveyName }"/></p>
			</div>
			<div class="d-flex">
				<p class="col-6">Dojo Location: </p>
				<p class="col-6"><c:out value="${ surveyLocation }"/></p>
			</div>
			<div class="d-flex">
				<p class="col-6">Favorite Language: </p>
				<p class="col-6"><c:out value="${ surveyFav }"/></p>
			</div>
			<div class="d-flex">
				<p class="col-6">Comment: </p>
				<p class="col-6"><c:out value="${ surveyComment }"/></p>
			</div>
		</div>
	</div>
</body>
</html>