<%-- 
    Document   : welcome
    Created on : 29 Mar 2023, 9:36:08 am
    Author     : Pluuskie
--%>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
		<link rel="stylesheet" type="text/css" href="basicstyle.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
    </head>
    <body>
		<%
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String confirmPassword = request.getParameter("confirmPassword");

			if (username != null && password != null && confirmPassword != null /*&& password.equals(confirmPassword)*/) {
				User user = new User(username, password);
				session.setAttribute("user", user);
		%>
		<p>Login/Registration successful! Click <a href="main.jsp">here</a> to proceed to main page.</p>
		<%
		} else {
		%>
		<p>Login/Registration unsuccessful! Click <a href="index.jsp">here</a> to return.</p>
		<%
			}
		%>
    </body>
</html>
