<%-- 
    Document   : logs
    Created on : 20 May 2023, 2:05:54 am
    Author     : Pluuskie
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Logs</title>
        <link rel="stylesheet" type="text/css" href="basicstyle.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="container">
            <h2>User Logs</h2>
            <%
				List<String> logs = (List<String>) request.getAttribute("logs");
				if (logs != null && !logs.isEmpty()) {
					for (String log : logs) {
						out.println("<p>" + log + "</p>");
					}
				} else {
					out.println("<p>No logs to show.</p>");
				}
            %>
        </div>
    </body>
</html>

