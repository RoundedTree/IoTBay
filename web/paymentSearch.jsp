<%-- 
    Document   : paymentSearch
    Created on : 18 May 2023, 5:40:33 pm
    Author     : angelaliang
--%>
<%@page import="uts.isd.model.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="basicstyle.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
        <title>JSP Page</title>
    </head>
     <jsp:include page="header.jsp" />
    <body>
        <%--<%  
            User user = (User) session.getAttribute("user");
            int userID = 0;
            String userName = "Anonymous";
            
            if (user != null) {
            userID = user.getId();
            userName = user.getName();
            }
            
            %> --%>
            
        <h1>Payment History for <%--<%=user=%>--%> </h1>
        
        <table class="styled-table" <%--action="SubmitPaymentController"--%> method="post" >
            <tr>
                <th>PaymentID</th>
                <th>Order</th>
                <th>Date</th>
                <th>Payment Method</th>
                <th>Total</th>
            </tr>
            <tr>
                <td>001</td>
                <td>011</td>
                <td>01/05/2023</td>
                <td>Credit Card</td>
                <td>$12.00</td>
            </tr>
          
            <tr>
                <td>002</td>
                <td>015</td>
                <td>01/11/2023</td>
                <td>Credit Card</td>
                <td>$50.65</td>
            </tr>
        </table>
        
    </body>
</html>
