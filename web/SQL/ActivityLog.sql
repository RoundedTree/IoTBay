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

