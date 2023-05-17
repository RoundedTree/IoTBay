<%-- 
    Document   : orderSearch
    Created on : 18/05/2023, 12:25:55 AM
    Author     : Andy
--%>

<%@page import="uts.isd.model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
            ArrayList<Order> orders = (ArrayList<Order>) session.getAttribute("searchedOrders");
            
            %>
    <body>
        <h1>Search Results!</h1>
        <%
            if(orders.isEmpty()) {
            %>
            <p>
                 No results found! 
                 <a href="orderManage.jsp">Search again?</a>
            </p> 
            <%
            
            } else {
            %>
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
        <%
            }
            %>
        <a href="main.jsp">Return Home</a>
    </body>
</html>
