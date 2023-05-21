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

INSERT INTO Payments (PaymentId, OrderId, PaymentMethod, CardNumber, CardName, ExpiryDate, CVV, DatePaid, OrderPrice) VALUES 
(1, 1, 'Credit Card', 1234123412341234,'John Doe','11/25', 123, '12/03/2023', 50.80),
(2, 3, 'Credit Card', 1234123412341234,'John Doe','11/25', 123, '05/10/2023', 120.45),
(2, 3, 'Credit Card', 1234123412341234,'John Doe','11/25', 123, '05/03/2023', 230.00),
(2, 3, 'Credit Card', 1234123412341234,'John Doe','11/25', 123, '05/10/2021', 34.56),
(2, 3, 'Credit Card', 1234123412341234,'John Doe','11/25', 123, '05/10/2020', 20.45),
(1, 1, 'Credit Card', 1234123412341234,'Edward Bishop','06/25', 123, '12/03/2023', 50.80),
(2, 3, 'Credit Card', 1234123412341234,'Edward Bishop','06/25', 123, '21/10/2023', 125.80.),
(2, 3, 'Credit Card', 1234123412341234,'Edward Bishop','06/25', 123, '16/10/2023', 125.45),
(2, 3, 'Credit Card', 1234123412341234,'Edward Bishop','06/25', 123, '13/10/2023', 10.45),
(2, 3, 'Credit Card', 1234123412341234,'Giles Corey','02/25', 123, '01/10/2021', 13.45),
(1, 1, 'Credit Card', 1234123412341234,'Giles Corey','02/25', 123, '25/03/2023', 54.80),
(2, 3, 'Credit Card', 1234123412341234,'Giles Corey','02/25', 123, '05/10/2019', 10.65),
(1, 1, 'Credit Card', 0987098709870987,'Jane Doe','07/24', 692, '09/08/2023', 69.72),
(1, 1, 'Credit Card', 0987098709870987,'Jane Doe','07/24', 692, '15/03/2023', 45.63),
(2, 3, 'Credit Card', 0987098709870987,'Jane Doe','07/24', 692, '05/12/2022', 4356.45),
(1, 1, 'Credit Card', 0987098709870987,'Jane Doe','07/24', 692, '12/03/2023', 45.72),
(2, 3, 'Credit Card', 4567456745674567,'Deodat Lawson','03/25', 390, '05/10/2023', 10.45),
(2, 3, 'Credit Card', 4567456745674567,'Deodat Lawson','03/25', 390, '06/10/2023', 12.65),
(2, 3, 'Credit Card', 4567456745674567,'Deodat Lawson','03/25', 390, '09/10/2023', 150.55),


