<%-- 
    Document   : index
    Created on : 29 Mar 2023, 9:36:02 am
    Author     : Pluuskie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="basicstyle.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
        <title>Home</title>
    </head>
    <body>
        <h1 class="index-title">IoTBay</h1>
		<div class="buttoncontainer">
			<form action="login.jsp" method="get">
				<button class="button" type="submit">Login</button>
			</form>
			<form action="register.jsp" method="get">
				<button class="button" type="submit">Register</button>
			</form>
		</div
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
