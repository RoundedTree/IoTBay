<%-- 
    Document   : customerCreate
    Created on : 21 May 2023, 6:40:54 am
    Author     : aucyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Information Management</title>
        <link rel="stylesheet" type="text/css" href="basicstyle.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Avenir">
    </head>
    <jsp:include page="header.jsp" />
    <body>
        <div class="title">Customer Information Management</div>
        
        <div class="title2">Create Customer</div>
        <div class="container">
            <form action="CreateCustomerServlet" method="POST" class="login-form">
                <label for="name">Name:</label>
                <input type="text" name="name" required><br>

                <label for="email">Email:</label>
                <input type="email" name="email" required><br>

                <label for="address">Address:</label><br>
                <textarea name="address" rows="4" cols="30" required></textarea><br><br>
                
                
                <label for="type">Type:</label>
                <select name="type" required>
                    <option value="company">Company</option>
                    <option value="individual">Individual</option>
                </select><br><br>


                <input type="submit" value="Create Customer">
            </form>
        </div>

        <div class="title2">Search Customers</div>
        <div class="container">
            <form action="index.jsp" method="GET">
                <label for="search">Search by Name:</label>
                <input type="text" name="search" required>
                <input type="submit" value="Search">
            </form>
        </div>

        <div class="title2">Customer List</div>
        <div class="container">
            <table class="styled-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Type</th>
                        <th>Address</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${filteredCustomers}" var="customer">
                        <tr>
                            <td>${customer.id}</td>
                            <td>${customer.name}</td>
                            <td>${customer.email}</td>
                            <td>${customer.type}</td>
                            <td>${customer.address}</td>
                            <td>${customer.status}</td>
                            <td>
                                <a href="EditCustomerServlet?id=${customer.id}">Edit</a> |
                                <a href="DeleteCustomerServlet?id=${customer.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>