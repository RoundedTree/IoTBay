# IoTBay

This project is a web-based application for browsing IoT products and serves as a point to purchase and track orders on these products. The application is built using Java Servlets and JSP and reads data from a MySQL database using JDBC.

## Features

- Online User Access Management (Thomas)
- IoT Device Catalogue Management (Dipesh)
- Order Management (Andy)
- Payment Management (Angela)
- Customer Information Management (Cynthia)
- Staff Information Management (Sarneet)

## Requirements

- JDK 8 or later
- MySQL
- Netbeans IDE

## Setup Instructions

1. Clone the repository: `git clone https://github.com/RoundedTree/IoTBay`
2. Import the project into your Netbeans
3. Set up a MySQL database and configure the `DBManager` class with your database credentials or use existing credentials found in DB.java
4. Run each of the SQL Files found in the SQL folder in project to create initial tables for the database
5. Run the project on a Glassfish 4.1 Server


## Usage Instructions

1. Access the application via `<your-server-url>/index.jsp`
2. Click the buttons on screen to navigate and use the application.

**Note:** Be sure to replace `<your-server-url>` with the actual URL of your server.
