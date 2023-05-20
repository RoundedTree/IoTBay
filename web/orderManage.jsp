<%-- 
    Document   : orderManage
    Created on : 16/05/2023, 8:02:29 PM
    Author     : Andy
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="basicstyle.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:include page="header.jsp" />
    <body>
        <%
            ArrayList<Order> orders = (ArrayList<Order>) session.getAttribute("orderList");
            ArrayList<Order> submittedOrders = (ArrayList<Order>) session.getAttribute("submittedOrders");
            
            
            User user = (User) session.getAttribute("user");
            int userID = 0;
            String userName = "Anonymous";
            
            if (user != null) {
            userID = user.getId();
            userName = user.getName();
            }
            
            %>
        
        <h1>Order Management for <%=userName%></h1>
        <% 
           if (user != null) {
           if (orders != null) { 
            if(orders.isEmpty()) {
            %>
            <p>
                 No orders found!
            </p> 
        <%

        } else {
        %>
        <h2>Saved Orders</h2>
        <table>
            <tr>
              <th>Order ID</th>
              <th>Order Date</th>
              <th>Order Total</th>
              <th>Edit Order</th>
            </tr>
            <%
                for (Order order : orders) {
                if(order.getUserID() == userID) {
                %>
            <tr>
              <td><%=order.getOrderID() %></td>
              <td><%=order.getOrderDate() %></td>
              <td><%=order.getOrderTotal() %></td>
              <td class="orderEditCell">
                  <form class="orderEditForm" action="CartSearchController" method="get">
                      <button type="submit" name="orderID" value="<%= order.getOrderID()%>">View Cart</button>
                  </form>
                  <form class="orderEditForm"action="RemoveOrderController" method="post">
                      <button type="submit" name="orderID" value="<%= order.getOrderID()%>">Delete Order</button>
                  </form>
              </td>
              <td>
                  <form method="post" action="SubmitOrderController" >
                      <button  type="submit" name="orderID" value="<%= order.getOrderID()%>" >Submit order</button>
                  </form>
              </td>
            </tr>
            <%
                    }
                }
                %>
        </table>
        <form action="AddOrderController" method="post">
            <button type="submit" name="userID" value="<%=userID%>">Create Order</button>
        </form>
                <%
                    }
                    %>
        
        <h3>Search</h3>
        <form method="get" action="OrderSearchController">
            <label>Order Id</label>
            <input name="searchID" placeholder="Order ID">
            <label>Order Date</label>
            <input name="searchDate" placeholder="mm/dd/yyyy">
            <button type="submit" name="userID" value=<%= userID %>>Search</button>
        </form>
        
        <h3>Placed Orders</h3>
        
        <table>
            <tr>
              <th>Order ID</th>
              <th>Order Date</th>
              <th>Order Total</th>
            </tr>
        <%
                for (Order order : submittedOrders) {
                if(order.getUserID() == userID) {
                %>
            <tr>
              <td><%=order.getOrderID() %></td>
              <td><%=order.getOrderDate() %></td>
              <td><%=order.getOrderTotal() %></td>
              
            </tr>
            <%
                    }
                }
                %>
        </table>
        <%
            } else {
            %>
        <p>Server Error! Could not fetch orders!</p>
        <%
            }
        } else {
%>
           
            Unregistered
            
            <%
                }
                %>
       
        
    </body>
</html>
