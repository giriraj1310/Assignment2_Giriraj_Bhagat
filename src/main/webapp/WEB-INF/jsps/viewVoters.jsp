<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Voters</title>
<style>

table {
	border-collapse: collapse;
	width: 100%;
}

th {
	text-align: left;
	background-color: #4CAF50;
	color: whitebackground-color: #4CAF50;
	color: white;
	padding: 8px;
}

td {
	text-align: left;
	padding: 8px;
}

td .voted {
	
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<h1>Registered Voters</h1>

	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>BirthDate</th>
				<th>Address</th>
				<th>SIN</th>
				<th>Voted</th>
			</tr>

		</thead>
		<tbody>
			<c:forEach items="${voterList}" var="item">
				<tr>
					<td>${item.firstName }</td>
					<td>${item.lastName }</td>
					<td>${item.birthDate }</td>
					<td>${item.address }</td>
					<td>${item.sin }</td>
					<td class="voted">${item.voted }</td>
					
					<td><a href="<c:url value="/delete/${item.sin }" />">Delete</a></td>
					<td><a href="<c:url value="/update/${item.sin }" />">Update</a></td>
					
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<div class="links">
		<a href="<c:url value="/" />">Index Page</a>
	</div>

	<script>
		var elements = document.getElementsByClassName("voted");
		for (var i = 0, len = elements.length; i < len; i++) {
			
			if (elements[i].innerHTML == "Yes") {
				elements[i].style = "color:green"
			} else {
				elements[i].style = "color:red"
			}

		}
	</script>
</body>

</html>