<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- This will allow me the form binding -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {
	color: #FF0000;
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Vote for your favorite party</h1>

	</div>

	<c:url var="url" value="/updateVoted" />

	<form:form action="${url }" method="POST" modelAttribute="vote">

		Choose a party:<form:select path="votes" items="${parties}" />
		
		<br /> 
		<input type="hidden" name="sin" value=${sin } /> 
	
		<input type="submit" value="Vote" />
		
	</form:form>

	<div class="links">
		<a href="/">Link to Index Page</a>
	</div>
</body>
</html>