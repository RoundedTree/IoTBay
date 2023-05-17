<%-- 
    Document   : orderManage
    Created on : 16/05/2023, 8:02:29 PM
    Author     : Andy
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<link rel="stylesheet" type="text/css" href="basicstyle.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<Order> orders = (ArrayList<Order>) session.getAttribute("orderList");
            
            %>
        
        <h1>Order Management</h1>
        <table>
            <tr>
              <th>Order ID</th>
              <th>Order Date</th>
              <th>Order Total</th>
              <th>View</th>
            </tr>
            <%
                if(orders != null) {
                    for (Order order : orders) {
                    if(order.getUserID() == 100) {
                
                %>
            <tr>
              <td><%=order.getOrderID() %></td>
              <td><%=order.getOrderDate() %></td>
              <td><%=order.getOrderTotal() %></td>
              <td>
                  <form action="CartSearchController" method="get">
                      <button type="submit" name="editOrderId" value="<%= order.getOrderID()%>">View Details</button>
                  </form>
              </td>
            </tr>
            <%
                        }
                    }
                }
                %>
        </table>
        <a href="main.jsp">Return Home</a>
    </body>
</html>
