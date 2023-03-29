<%-- 
    Document   : main
    Created on : 29 Mar 2023, 9:37:12 am
    Author     : Pluuskie
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
		<link rel="stylesheet" type="text/css" href="basicstyle.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
    </head>
    <body>
		<%
			User user = (User) session.getAttribute("user");
			if (user != null) {
		%>
		<h2>Welcome!</h2>
		<p>Your username is ${user.username} and your password is ${user.password}</p>
		<br><br>
		<p>Click <a href="logout.jsp">here</a> to logout. :)</p>
		<%
		} else {
		%>
		<p>Something has gone horribly wrong. Click <a href="index.jsp">here</a> to return.</p>
		<%
			}
		%>
    </body>
</html>
