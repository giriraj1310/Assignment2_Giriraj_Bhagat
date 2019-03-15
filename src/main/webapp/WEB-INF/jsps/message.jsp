<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message Page</title>

<style>
h1 {
	color: #FF0000;
	text-align: center;
}

div a {
	background-color: #0693cd;
	border: 0;
	border-radius: 5px;
	cursor: pointer;
	color: #fff;
	font-size: 18px;
	font-weight: bold;
	line-height: 1.4;
	padding: 10px;
	margin-left: 30%;
}
</style>

</head>
<body>
	<h1>${message}</h1>
	<div class="links">
		<a href="/">Link to Index Page</a> <br /> <br /> <a
			href="vote.jsp">Go back</a>
	</div>
</body>
</html>