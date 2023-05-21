<%-- 
    Document   : product
    Created on : 20 May 2023, 10:36:14 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
        <link rel="stylesheet" type="text/css" href="basicstyle.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
    </head>
    <body>
        <div class="title">Register Product</div>
		<form action="ProductController" method="POST" class="container">
                    <table>
                        <tr><td>ProductID:</td><td><input type="number" placeholder="Enter ID" name="id" ></td></tr>
                        <tr><td>Name of Product:</td><td><input type="text" placeholder="Enter Name" name="name" ></td></tr>
                        <tr><td>Type:</td><td><input type="text" placeholder="Enter type" name="type"></td></tr>
                        <tr><td>Price($):</td><td><input type="number" step="0.01" placeholder="Price" name="price" ></td></tr>
                        <tr><td>Quantity:</td><td><input type="number" placeholder="Quantity" name="quantity"></td></tr>
                    </table>
                    <div>
                        <a class = "button" href="header.jsp">Cancel</a>
                        
                        <input class ="submit-container" type="submit" value="Add Product">
                    </div>>
		</form>
        <div>
            
        </div>
    </body>
</html>
