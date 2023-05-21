<%-- 
    Document   : header
    Created on : 20 May 2023, 12:45:03 am
    Author     : Pluuskie
--%>

<%@page import="uts.isd.model.User"%>
<%@page import="java.util.Objects"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Header</title>
		<link rel="stylesheet" type="text/css" href="basicstyle.css">
	</head>
	<body>
		<div class="header">
			<div class="header-title">IoTBay</div>
			<div class="links">
				<%
					User user = (User) session.getAttribute("user");
					if (Objects.nonNull(user)) {
				%>
				<span class="welcome-text">Welcome <%=user.getName()%>!</span>
				<a href="main.jsp">Home</a>
				<a href="AccountController">Account</a>
				<a href="LogoutController">Logout</a>
				<% if ("admin".equals(((User) session.getAttribute("user")).getRole())) { %>
				<a href="UserController?action=loadAdmin">Manage Users</a>
				<% } %>
				<%
				} else {
				%>
				<a href="main.jsp">Home</a>
				<a href="login.jsp">Login</a>
				<a href="register.jsp">Register</a>
				<%
					}
				%>
			</div>
		</div>
	</body>
</html>



