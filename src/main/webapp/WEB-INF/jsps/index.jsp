<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>

<style>
h1 {
	color: #FF0000;
	text-align: center;
}

div {
	margin-left: 30%;
}

div a {
	background-color: yellow;
	color: black padding: 10px;
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
	<h1>Index Page</h1>

	<div class="container">

		<a href="/addVoterPage">Register Voter</a> <br /> 
		<a href="/vote">Vote for your party</a> <br />

	</div>
	<br />

	<a href="/showStats">Show Stats</a> <br />
	<a href="/viewVoterList">View Registered Voters</a> <br />
	<a href="/generateDummy">Generate Dummy Records</a> <br />

</body>
</html>