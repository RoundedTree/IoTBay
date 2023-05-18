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
            //TODO Add orders and cart items
            ArrayList<Order> orders = (ArrayList<Order>) session.getAttribute("orderList");
            //TODO get User object session attribute when USER object implemented to get userID
            int userID = (Integer) session.getAttribute("tempUserid");
            
            %>
        
        <h1>Order Management</h1>
        <%
            if(orders.isEmpty()) {
            %>
            <p>
                 No orders found!
            </p> 
        <%

        } else {
        %>
        <table>
            <tr>
              <th>Order ID</th>
              <th>Order Date</th>
              <th>Order Total</th>
              <th>Edit Order</th>
            </tr>
            <%
                if(orders != null) {
                    for (Order order : orders) {
                    if(order.getUserID() == userID) {
                
                %>
            <tr>
              <td><%=order.getOrderID() %></td>
              <td><%=order.getOrderDate() %></td>
              <td><%=order.getOrderTotal() %></td>
              <td class="orderEditCell">
                  <form class="orderEditForm" action="CartSearchController" method="get">
                      <button type="submit" name="editOrderId" value="<%= order.getOrderID()%>">View Cart</button>
                  </form>
                  <form class="orderEditForm"action="RemoveOrderController" method="post">
                      <button type="submit" name="orderID" value="<%= order.getOrderID()%>">Delete Order</button>
                  </form>
              </td>
            </tr>
            <%
                        }
                    }
                }
                %>
        </table>
                <%
                    }
                    %>
        
        <h3>Search</h3>
        <form method="get" action="OrderSearchController">
            <label>OrderId</label>
            <input name="searchID" placeholder="Order ID">
            <label>Order Date</label>
            <input name="searchDate" placeholder="mm/dd/yyyy">
            <button type="submit">Search</button>
        </form>
        
       
        <a href="main.jsp">Return Home</a>
    </body>
</html>
