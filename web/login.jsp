<%-- 
    Document   : login
    Created on : 29 Mar 2023, 9:36:24 am
    Author     : Pluuskie
--%>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="basicstyle.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
	</head>
	<body>
		<div class="title">Login</div>
		<div class="container">
                    <form action="LoginController" method="POST" class="login-form">
                        <label for="email">Email</label>
                        <input type="text" id="email" name="email" required>

                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" required>

                        <div class="submit-container">
                            <input type="submit" name="action" value="Login">
                            <span class="error">${errorInfo}</span>
                        </div>
                    </form>
                </div>
	</body>
</html>


