<%-- 
    Document   : payment
    Created on : 17 May 2023, 8:38:58 pm
    Author     : angelaliang
--%>
<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="basicstyle.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
        <title>Payment Page</title>
    </head>
    <jsp:include page="header.jsp" />
    <body>

        <h1>Payment Details</h1>
        <form action=confirmPayment.jsp method="post">
        
        
            <div class="container"> 
            
            <h1>Payment Details</h1>
                <b><label for name="paymentMethod">Payment Method</label></b>
                       <select id="paymentMethod" name="paymentMethod">
                           <option value="Credit Card" >Credit Card</option>
                           <option value="Paypal ">Paypal</option>
                       </select>
                <br><br>

                   <b><label for name="datePaid">Date Paid</label></b>
                       <input type="date" id="datePaid" name="datePaid" placeholder="Date Paid" required/> 
                       <br>
            <h2>Card Details</h2>
          
           
                <label>Credit card number:</label><br>
                <input type="text" placeholder="0000 0000 0000 0000" id="cardNumber" name="cardNumber" maxlength="16" required="true" ><br>
                <label>Name on card:</label><br>
                <input type="text" placeholder="Jon Doe" id="cardName" name="cardName" required><br>
                <label>Expiration date (MM/YY):</label><br>
                <input type="text" placeholder="MM/YY" id="expiryDate" name="expiryDate" maxlength="5"required ><br>
                <label>Security Code:</label><br>
                <input type="text" id="cvv" name="cvv" maxlength="3" required ><br>
                <br>
             
             <input type="submit" value="Pay now">
        </form>
        
            <br>
            <p><a class= "button" style="center" href="main.jsp">Cancel</a></p>
                
        </div>
    </body>
</html>
