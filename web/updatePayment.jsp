<%-- 
    Document   : payment
    Created on : 16 May 2023, 5:53:35 pm
    Author     : angelaliang
--%>
<%@page import="uts.isd.model.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="basicstyle.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
        <title>Update Payment Page</title>
    </head>
    <jsp:include page="header.jsp" />
    <body>
        <h1>Payment Details</h1> 
        <p> Don't worry no scams ahead :) </p>
        <!-- Card payment table -->
       <div class="container"> 
           <form action="savedPayment.jsp" method="post" >
               
                <label>Credit card number:</label><br>
                <input type="text" placeholder="0000 0000 0000 0000" id="cardNumber" name="cardNumber" maxlength="16" required="true" ><br>
                <label>Name on card:</label><br>
                <input type="text" placeholder="Jon Doe" id="cardName" name="cardName" required><br>
                <label>Expiration date (MM/YY):</label><br>
                <input type="text" placeholder="MM/YY" id="expiryDate" name="expiryDate" maxlength="5"required ><br>
                <label>Security Code:</label><br>
                <input type="text" id="cvv" name="cvv" maxlength="3" required ><br>
                <br>
            <input type="submit" value="Update"><br>
            </form>
           <br>
           <br>
         
           <a href="main.jsp">Cancel</a>
         
        </div>
         
    </body>
</html>
