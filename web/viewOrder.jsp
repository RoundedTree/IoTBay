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
        String id = request.getParameter("orderID");
        ArrayList<Cart> cart = (ArrayList<Cart>) session.getAttribute("cartItems");
        System.out.print(session.getAttribute("submit"));
        
        %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:include page="header.jsp" />
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
                <%
                    if (Boolean.FALSE == session.getAttribute("submit")) {
                    %>
                <td class="td">
                    <form method="post" action="RemoveItemCartController">
                         <button class="button" type="submit" name="cartID" value="<%= car.getCartID() %>" > Delete</button>
                    </form>
                </td>
                <%
                    }
                    %>
            </tr>
        <%
                    }
                }
            }
                %>
        </table>
        <%
           if (Boolean.FALSE == session.getAttribute("submit")) {
            %>
        <form method="post" action="AddItemCartController">
            <input class="input" name="productID" placeholder="Enter product ID">
            <button class="button" type="submit" name="orderID" value="<%= id %>" > Add to cart</button>
        </form>
        <%
            }
            %>
        <p><a class="button" href="orderManage.jsp">Back</a></p>
    </body>
</html>
