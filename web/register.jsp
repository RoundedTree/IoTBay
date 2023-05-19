<%-- 
    Document   : register
    Created on : 29 Mar 2023, 9:36:31 am
    Author     : Pluuskie
--%>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Register</title>
		<link rel="stylesheet" type="text/css" href="basicstyle.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
	</head>
	<jsp:include page="header.jsp" />
	<body>
		<div class="title">Register</div>
		<form action="RegisterController" method="POST" class="container">
			<label for="name">Name</label>
			<input type="text" id="name" name="name" required>

			<label for="email">Email</label>
			<input type="text" id="email" name="email" required>

			<label for="password">Password</label>
			<input type="password" id="password" name="password" required>

			<input type="submit" name="action" value="Register">
		</form>
	</body>
</html>

