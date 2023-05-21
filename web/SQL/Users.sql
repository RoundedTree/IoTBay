/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Pluuskie
 * Created: 18 May 2023
 */

CREATE TABLE Users (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, 
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(255),
    account_status VARCHAR(20) NOT NULL DEFAULT 'active'
);

INSERT INTO Users (name, email, password, role) VALUES 
('John Doe', 'john.doe@example.com', 'johnpassword', 'customer'),
('Jane Smith', 'jane.smith@example.com', 'janepassword', 'customer'),
('Bob Jones', 'bob.jones@example.com', 'bobpassword', 'staff'),
('Admin User', 'admin@example.com', 'adminpassword', 'admin');
