<%-- 
    Document   : account
    Created on : 20 May 2023, 1:40:21 am
    Author     : Pluuskie
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account</title>
        <link rel="stylesheet" type="text/css" href="basicstyle.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="container">
            <h2>Account Details</h2>
			<%
				User user = (User) session.getAttribute("user");
			%>
			<p>Current Name: <%=user.getName()%></p>
			<p>Current Email: <%=user.getEmail()%></p>
			<form action="UpdateAccountController" method="post">
				<label for="name">Name</label>
				<input type="text" id="name" name="name" placeholder="Enter new name or leave blank to keep current" />
				<label for="email">Email</label>
				<input type="email" id="email" name="email" placeholder="Enter new email or leave blank to keep current" />
				<label for="password">Password</label>
				<input type="password" id="password" name="password" placeholder="Enter new password or leave blank to keep current" />
				<input type="submit" value="Update Account" />
			</form>
			<a href="LogsController" class="button">View Logs</a>
			<a href="orderManage.jsp" class="button">Order Management</a>
			<a href="updatePayment.jsp" class="button">Update Payment</a>
			<form action="cancelAccount" method="post">
				<input type="submit" value="Cancel Account" class="button" style="background-color: red"/>
			</form>
        </div>
    </body>
</html>

