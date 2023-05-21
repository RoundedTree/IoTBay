/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Pluuskie
 * Created: 20 May 2023
 */

CREATE TABLE UserActivityLog (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, 
    user_id INT NOT NULL,
    activity_type VARCHAR(50),
    date DATE DEFAULT CURRENT_DATE
);

INSERT INTO UserActivityLog (user_id, activity_type, date) VALUES
(1, "Login", 2023-05-20),
(1, "Logout", 2023-05-20),
(2, "Login", 2023-05-20),
(2, "Logout", 2023-05-20),
(3, "Login", 2023-05-20),
(3, "Logout", 2023-05-20),
(4, "Login", 2023-05-20),
(4, "Logout", 2023-05-20),
(5, "Login", 2023-05-20),
(5, "Logout", 2023-05-20),
(6, "Login", 2023-05-20),
(6, "Logout", 2023-05-20),
(7, "Login", 2023-05-20),
(7, "Logout", 2023-05-20),
(8, "Login", 2023-05-20),
(8, "Logout", 2023-05-20),
(9, "Login", 2023-05-20),
(9, "Logout", 2023-05-20),
(10, "Login", 2023-05-20),
(10, "Logout", 2023-05-20);

