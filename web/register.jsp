<%-- 
    Document   : register
    Created on : 29 Mar 2023, 9:36:31 am
    Author     : Pluuskie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
		<link rel="stylesheet" type="text/css" href="basicstyle.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
    </head>
    <body>
        <h1 class="title">Register</h1>
		<div class="container">
			<h2>Registration Form</h2>
			<form action="welcome.jsp" method="post">
				<label for="username">Username:</label>
				<input type="text" id="username" name="username">

				<label for="password">Password:</label>
				<input type="password" id="password" name="password">

				<label for="confirmPassword">Confirm Password:</label>
				<input type="password" id="confirmPassword" name="confirmPassword">

				<input type="submit" value="Submit">
			</form>
		</div>
    </body>
</html>
