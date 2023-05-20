<%-- 
    Document   : saved payment details
    Created on : 16 May 2023, 12:02:34 pm
    Author     : angelaliang
--%>
<%@page import="uts.isd.model.Payment"%>
<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="basicstyle.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir"> 
        <title>Saved Payment</title>
    </head>
    <body>
        <%
         //bugg -- 16 digit integer is too big and jsp does not support Long for cardnumber  
            //Long cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
         
         Integer cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
         Integer cvv = Integer.parseInt(request.getParameter("cvv"));
         String cardName = request.getParameter("cardName");
         String expiryDate = request.getParameter("expiryDate");
         String datePaid = request.getParameter("datePaid");     
         
         
         Payment payment = new Payment(cardNumber, cvv, cardName, expiryDate, datePaid);
         Payment pay = (Payment) session.getAttribute("payment");
         String updated = request.getParameter("updated");
         session.setAttribute("payment", payment);
         
         
         %>
       
         <h1>Saved Payment Card <span><%=(updated != null) ? "Update was successful":"" %></span> </h1>
        
        <div class="container" >
            <form action="updatePayment.jsp" method="post" >
                <table  id="paymentInfo_table" >
                    
                <tr><td>Name:</td><td>${payment.cardName}</td></tr><br>
                <tr><td>Card number:</td><td>${payment.cardNumber}</td></tr><br>
                <tr><td>Expiry date:</td><td>${payment.expiryDate}</td></tr><br>
                <tr><td>Security code:</td><td>${payment.cvv}</td></tr><br>
                </table>
                <br>
                <input type="submit" value="Update Details">
                <input type="hidden" name="updated" value="updated">
                  

            </form>
                <p><a class= "button" style="center" href="main.jsp">Home</a></p>
        </div>
        
        <!-- test if values from updatePayment stored -->
        <%-- 
        <p>Name: <%= cardName %></p>
        <p>Card number: <%= cardNumber %></p>
        <p>Expiry date: <%= expiryDate %></p>
        <p>CVV: <%= cvv %></p>
        --%>
        
    </body>
</html>
