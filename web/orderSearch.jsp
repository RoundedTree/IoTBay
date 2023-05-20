<%-- 
    Document   : orderSearch
    Created on : 18/05/2023, 12:25:55 AM
    Author     : Andy
--%>

<%@page import="uts.isd.model.*"%>
<%@page import="java.util.ArrayList"%>
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
    <%
            ArrayList<Order> orders = (ArrayList<Order>) session.getAttribute("searchedOrders");
            User user = (User) session.getAttribute("user");
            int userID = user.getId();
            String errorID = (String) session.getAttribute("orderSearchErrID");
            String errorDate = (String) session.getAttribute("orderSearchErrDate");
            %>
    <body>
        <h1>Search Results!</h1>
        <%
            if(errorID == null  &&  errorDate==null) {
                if(orders.isEmpty()) {
            %>
            <p>
                 No results found! 
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
                      <button type="submit" name="orderID" value="<%= order.getOrderID()%>">View Cart</button>
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
            } else {
            if (errorID != null) {
            %>
            <p><%=errorID%></p>
            <%}
            if (errorDate != null) {
            %>
            <p><%=errorDate%></p>
        <%}
            }
            %>
            <p><a href="orderManage.jsp">Search again?</a></p>
            
    </body>
</html>
