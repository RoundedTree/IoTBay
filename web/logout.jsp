<%-- 
    Document   : logout
    Created on : 29 Mar 2023, 9:36:42 am
    Author     : Pluuskie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
		<link rel="stylesheet" type="text/css" href="basicstyle.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
    </head>
    <body>
        <h1>You've been logged out</h1>
		<p>Click <a href="index.jsp">here</a> to return.
		<% session.invalidate(); %>
    </body>
</html>
