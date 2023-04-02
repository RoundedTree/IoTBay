<%-- 
    Document   : login
    Created on : 29 Mar 2023, 9:36:24 am
    Author     : Pluuskie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
		<link rel="stylesheet" type="text/css" href="basicstyle.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
    </head>
    <body>
        <div class="container">
			<h2>Login</h2>
			<form action="welcome.jsp" method="post">
				<label for="username">Username:</label>
				<input type="text" id="username" name="username">

				<label for="password">Password:</label>
				<input type="password" id="password" name="password">

				<input type="submit" value="Login">
			</form>
		</div>
    </body>
</html>
