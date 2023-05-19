<%-- 
    Document   : logs
    Created on : 20 May 2023, 2:05:54 am
    Author     : Pluuskie
--%>

<%@page import="java.util.List"%>
<%@page import="uts.isd.model.UserActivityLog"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logs</title>
	<link rel="stylesheet" type="text/css" href='basicstyle.css"'>
	 <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
    </head>
	<jsp:include page="header.jsp" />
    <body>
        <div class="container">
            <h1 class="title">Activity Logs</h1>
            <form action="LogsController" method="get">
                <label for="startDate">Start Date:</label>
                <input type="date" id="startDate" name="startDate" />

                <label for="endDate">End Date:</label>
                <input type="date" id="endDate" name="endDate" />

                <input type="submit" class="button" value="Filter" />
            </form>
            <table class="styled-table">
                <thead>
                    <tr>
                        <th>Activity</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<UserActivityLog> logs = (List<UserActivityLog>) request.getAttribute("logs");
						for (UserActivityLog log : logs) {%>
                    <tr>
                        <td><%= log.getActivityType()%></td>
                        <td><%= log.getDate()%></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>


