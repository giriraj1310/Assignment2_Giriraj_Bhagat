<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- This will allow me the form binding -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Voter</title>

<style>
h1 {
	text-align: center;
	color: red;
}

input {
	border: none;
	border-bottom: 2px solid red;
}

input [type=date] {
	border: none;
}

input[type=submit] {
	background-color: #0693cd;
	border: 0;
	border-radius: 5px;
	cursor: pointer;
	color: #fff;
	font-size: 18px;
	font-weight: bold;
	line-height: 1.4;
	padding: 10px;
	
}
</style>
</head>
<body>

	<div class="container">
		<h1>Voter Information</h1>
		<p>Please fill in the information to be a registered voter</p>
	</div>
	
	<c:url var="url" value="/addVoter" />
	<form:form action="${url }" method="POST" modelAttribute="voter">

		First Name<form:input path="firstName" /><br /> 
		Last Name<form:input path="lastName" id="lastName"  /> <br /> 
		BirthDate<form:input path="birthDate" type="date" id="birthDate"  /> <br /> 
		Address<form:input path="address" id="address"  /> <br /> 
		SIN<form:input path="sin" type="number" id="sin"  /> <span>${sin }</span>
		<br /> 
		
		<input type="submit" value="Register" />
		
	</form:form>

	<div class="links">
		<a href="/">Link to Index Page</a>
	</div>
	<!-- <script src="./js/main.js"></script> -->
</body>
</html>