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
    <link rel="stylesheet" type="text/css" href="basicstyle.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
    <%
        String id = request.getParameter("editOrderId");
        ArrayList<Cart> cart = (ArrayList<Cart>) session.getAttribute("cartItems");
        if(!cart.isEmpty()) {
            System.out.print("test");
        }
        
        %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Order #<%=id %></h1>
        <h2>Cart Details</h2>
        <%
            if(cart.isEmpty()) {
            System.out.print("erro");
            %>
            <p>
                 Empty cart! Add items!
            </p> 
            <%
            
            } else {
            %>
        <table>
            <tr>
                <th>Cart ID</th>
                <th>Order ID</th>
                <th>Product ID</th>
                <th>Edit</th>
            </tr>
        <%
                if(cart != null || !cart.isEmpty()) {
                    for (Cart car : cart) {
                %>
            <tr>
                <td><%=car.getCartID() %></td>
                <td><%=car.getOrderID() %></td>
                <td><%=car.getProductID() %></td>
                <td>
                    <form method="post" action="RemoveItemCartController">
                         <button type="submit" name="cartID" value="<%= car.getCartID() %>" > Delete</button>
                    </form>
                   
                </td>
            </tr>
        <%
                    }
                }
            }
                %>
        </table>
        <a href="orderManage.jsp">Back</a>
    </body>
</html>
