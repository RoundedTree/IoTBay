<%-- 
    Document   : paymentSucess
    Created on : 21 May 2023, 7:47:10 pm
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
        <title>Payment Success Page</title>
    </head>
    <jsp:include page="header.jsp" />
    <body>
        <%-- <%
            User user = (User) session.getAttribute("user");
            int userID = 0;
            String userName = "Anonymous";
            
            if (user != null) {
            userID = user.getId();
            userName = user.getName();
        %> --%>
        
        
        
        <div class="container" >
            
            <h1>Hello <%--<%=User=%>--%>  </h1>
            
            <h2>Purchase#</h2>                                                     
            <h1>Congratulations your order and payment have been confirmed!</h1>                                  
            <p> We will notify you when your order is ready for collection from our store through your email address.</p>        

            <br> 
            <p> <a class = button href ="paymentSearch.jsp">Search Payment</a></p>    

        </div>
        
    </body>
</html>
