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
</head>
<body>
	<div class="container">
	<h1>Vote for your favorite party</h1>
	<p>Please enter your SIN for the system to verify</p>
</div>

	<c:url var="url" value="/verifySin" />

	<form:form action="${url }" method="POST" modelAttribute="voter">
		
		SIN<form:input type="number" path="sin" id="sin"  /> <br />
		
		<input type="submit" value="Submit" />
	</form:form>
	
	<div class="links">
		<a href="/">Link to Index Page</a>
	</div>
</body>
</html>