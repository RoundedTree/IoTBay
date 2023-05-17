<%-- 
    Document   : viewOrder
    Created on : 17/05/2023, 1:52:48 PM
    Author     : Andy
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String id = request.getParameter("editOrderId");
        ArrayList<Cart> cart = (ArrayList<Cart>) session.getAttribute("cartItems");
        
        %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Order #<%=id %></h1>
        <h2>Cart Details</h2>
        <table>
            <tr>
                <th>Order ID</th>
                <th>Product ID</th>
                <th>Edit</th>
            </tr>
        <%
                if(cart != null) {
                    for (Cart car : cart) {
                
                %>
            <tr>
                <td><%=car.getOrderID() %></td>
                <td><%=car.getProductID() %></td>
            </tr>
                <%
                        }
                    }
                %>
        </table>
        <a href="orderManage.jsp">Back</a>
    </body>
</html>
