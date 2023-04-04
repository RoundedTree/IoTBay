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
            User user = (User) session.getAttribute("user");
            String loginUsername = request.getParameter("loginUsername");
            String loginPassword = request.getParameter("loginPassword");
            if (user.getUsername().equals(loginUsername) && user.getPassword().equals(loginPassword)) {
            user.setLoggedIn(true);
        %>
        <p>Login successful! Click <a href="main.jsp">here</a> to proceed to main page.</p>
        <% } else { 
            user.setLoggedIn(false);
        %>
        <p>Login failed! Click <a href="index.jsp">here</a> to try again.</p>
        <%
            }
        %>
    </body>
</html>
