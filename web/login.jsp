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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="basicstyle.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
    </head>
    <body>
        <%
            String regUsername = request.getParameter("regUsername");
            String regPassword = request.getParameter("regPassword");
            String confirmPassword = request.getParameter("confirmPassword");

            if (regUsername != null && regPassword != null && confirmPassword != null && regPassword.equals(confirmPassword)) {
                User user = new User(regUsername, regPassword, false);
                session.setAttribute("user", user);
            }
        %>
        <div class="container">
            <h2>Login</h2>
            <form action="welcome.jsp" method="post">
                <label for="loginUsername">Username:</label>
                <input type="text" id="loginUsername" name="loginUsername">

                <label for="loginPassword">Password:</label>
                <input type="password" id="loginPassword" name="loginPassword">

                <input type="submit" value="Login">
            </form>
        </div>
    </body>
</html>
