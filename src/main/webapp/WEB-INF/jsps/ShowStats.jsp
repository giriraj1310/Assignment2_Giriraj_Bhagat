<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Statistics</title>
<style>
	span{
	color:red}
</style>

</head>

<body>
	<h1>The percentage of vote each party won</h1>
	<ul>
		<li>Liberal Party: ${liberal }</li>
		<li>Conservative Party: ${conservative }</li>
		<li>New Democratic Party: ${democratic }</li>
		<li>Bloc Quebecois: ${bloc }</li>
		<li>Green Party: ${green }</li>
	</ul>
	<p>The percentage of eligible voters that did vote is:
		<span>${eligibleVotersThatDidVote }</span></h1>

	 <p>The percentage of eligible voters that voted in the age
		bracket 18 - 30 --> <span>${age18 }</span></p>
	<p>The percentage of eligible voters that voted in the age
		bracket 30 - 45 --> ${age45 }</p>
	<p>The percentage of eligible voters that voted in the age
		bracket 45 - 60 --> ${age59 }</p>
	<p>The percentage of eligible voters that voted in the age
		bracket 60 --> ${age60 }</p>
		
		<div class="links">
			<a href="/">Link to Index Page</a>
		</div>
</body>
</html>