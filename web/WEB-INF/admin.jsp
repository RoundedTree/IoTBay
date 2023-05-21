<%-- 
    Document   : admin
    Created on : 21 May 2023, 1:44:28 pm
    Author     : Cynthia & Sarneet
--%>

<%@page import="java.util.List"%>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" type="text/css" href="basicstyle.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
    </head>
	<jsp:include page="header.jsp" />
    <body>
        <div class="container">
			<h1>Admin Management Screen</h1>
			<h2>Search Users</h2>
			<form method="GET" action="UserController">
				<input type="hidden" name="action" value="search">
				<input type="text" name="name" placeholder="Search by name">
				<button type="submit">Search</button>
			</form>
			<h2>New User</h2>
			<form method="POST" action="UserController">
				<input type="hidden" name="action" value="add">
				<input type="text" name="name" placeholder="Name">
				<input type="email" name="email" placeholder="Email">
				<input type="password" name="password" placeholder="Password">
				<select name="role">
					<option value="staff">Staff</option>
					<option value="customer">Customer</option>
					<option value="admin">Admin</option>
				</select>
				<select name="accountStatus">
					<option value="active">Active</option>
					<option value="cancelled">Cancelled</option>
				</select>
				<button type="submit">Add User</button>
			</form>
			<h2>Users</h2>
			<%
				List<User> users = (List<User>) session.getAttribute("users");
				if (users != null) {
					for (User user : users) {
			%>
			<div class="styled-table-admin">
				<form method="POST" action="UserController" class="form-admin">
					<input type="hidden" name="action" value="update">
					<input type="hidden" name="id" value="<%= user.getId()%>">
					<div class="form-field">
						<label>Name:</label>
						<input type="text" name="name" value="<%= user.getName()%>">
					</div>
					<div class="form-field">
						<label>Email:</label>
						<input type="email" name="email" value="<%= user.getEmail()%>">
					</div>
					<div class="form-field">
						<label>Password:</label>
						<input type="password" name="password" value="<%= user.getPassword()%>">
					</div>
					<div class="form-field">
						<label>Role:</label>
						<select name="role">
							<option value="staff" <%= "staff".equals(user.getRole()) ? "selected" : ""%>>Staff</option>
							<option value="customer" <%= "customer".equals(user.getRole()) ? "selected" : ""%>>Customer</option>
							<option value="admin" <%= "admin".equals(user.getRole()) ? "selected" : ""%>>Admin</option>
						</select>
					</div>
					<div class="form-field">
						<label>Account Status:</label>
						<select name="accountStatus">
							<option value="active" <%= "active".equals(user.getAccountStatus()) ? "selected" : ""%>>Active</option>
							<option value="cancelled" <%= "cancelled".equals(user.getAccountStatus()) ? "selected" : ""%>>Cancelled</option>
						</select>
					</div>
					<div class="form-field">
						<button type="submit">Update User</button>
					</div>
				</form>
				<form method="POST" action="UserController">
					<input type="hidden" name="action" value="delete">
					<input type="hidden" name="id" value="<%= user.getId()%>">
					<button type="submit">Delete User</button>
				</form>
			</div>
			<%
					}
				}
			%>
        </div>
    </body>
</html>
