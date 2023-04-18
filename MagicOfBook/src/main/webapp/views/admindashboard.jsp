<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminDashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Magic Of Book</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="admindash/logout">Logout</a></li>
					<li class="nav-item"><a class="nav-link active" href="insertbook">Add
							Book </a></li>

				</ul>

				
			</div>
		</div>
	</nav>
	<div>
		<form method="get" action="/adminsearch">
			<input style="margin-left: 5px; margin-top: 5px; border-radius: 9px" type="text"
				name="query" placeholder="Search..."> <a
				class="fa fa-search"
				style="color: black; margin-left: -25px; text-decoration: none"></a>&nbsp;<select style="margin-left: 5px"
				name="category">
				<option value="all">All</option>
				<option value="author">Author</option>
				<option value="id">Id</option>
			</select>
			<button type="submit">Search</button>
		</form>
	</div>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Book Name</th>
					<th scope="col">Genre</th>
					<th scope="col">Author</th>
					<th scope="col">Publication</th>
					<th scope="col">Price</th>
					<th scope="col">Remove/Edit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books }" var="book">
					<tr>
						<td>${book.bookname }</td>
						<td>${book.genre }</td>
						<td>${book.author }</td>
						<td>${book.publication }</td>
						<td>${book.price }</td>
						<td><a style="margin: 7.5%" href="remove/${book.id }"><i
								class="fa fa-trash" style="color: black"></i></a>
								<a href="edit/${book.id }"><i
								class="fa fa-edit" style="color:black"></i></a>
								</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

</body>
</html>