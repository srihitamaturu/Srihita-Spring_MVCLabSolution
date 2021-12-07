<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Student List</title>
</head>

<body>

	<div class="container">
		<h1 style="background-color: Voilet;">STUDENTS ENROLLED</h1>
		<hr>

		<!-- Add a button -->

		<a href="/StudentDebateEvent/students/showFormForAdd"
			class="btn btn-primary btn-sm mb-3">Add Student</a>

		<!-- Display table user interface -->
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Student Id</th>
					<th>Name</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="i">
					<tr>
						<td><c:out value="${i.id}" /></td>
						<td><c:out value="${i.name}" /></td>
						<td><c:out value="${i.department}" /></td>
						<td><c:out value="${i.country}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/StudentDebateEvent/students/showFormForUpdate?id=${i.id}"
							class="btn btn-info btn-sm">Update</a> <!-- Add "delete" button/link -->
							<a href="/StudentDebateEvent/students/delete?id=${i.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
