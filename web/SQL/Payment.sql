/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  angelaliang
 * Created: 21 May 2023
 */

-- tables for payment management
CREATE TABLE Payments(
    PaymentId INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
    -- ORDERID will be foreign key to USER TABLE
    OrderId INTEGER,
    PaymentMethod VARCHAR (20),
    CardNumber INTEGER,
    Cardname VARCHAR (20),
    ExpiryDate VARCHAR (20),
    CVV INTEGER (3),
    DatePaid DATE,
    OrderPrice DOUBLE
);

INSERT INTO Payments (name, email, password, role) VALUES 
(1, 1, 'Credit Card', 1234123412341234,'John Doe','11/25', 123, '12/03/2023', 50.80),
(2, 3, 'Credit Card', 1234123412341234,'John Doe','11/25', 123, '05/10/2023', 120.45),
