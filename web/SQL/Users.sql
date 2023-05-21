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
('Hugh Jass', 'hugh.jass@example.com', 'hughpassword', 'customer'),
('Mike Hunt', 'mike.hunt@example.com', 'mikepassword', 'customer'),
('Amanda Hugginkiss', 'amanda.hugginkiss@example.com', 'amandapassword', 'customer'),
('Ben Dover', 'ben.dover@example.com', 'benpassword', 'customer'),
('Joe Mama', 'joe.mama@example.com', 'joepassword', 'customer'),
('Anita Dick', 'anita.dick@example.com', 'anitapassword', 'customer'),
('Jacques Strap', 'jacques.strap@example.com', 'jacquespassword', 'customer'),
('Dixie Rect', 'dixie.rect@example.com', 'dixiepassword', 'customer'),
('Mike Rotch', 'mike.rotch@example.com', 'mikepassword', 'customer'),
('Clea Torres', 'clea.torres@example.com', 'cleapassword', 'customer'),
('Peter File', 'peter.file@example.com', 'peterpassword', 'customer'),
('Moe Lester', 'moe.lester@example.com', 'moepassword', 'customer'),
('Ophelia Bush', 'ophelia.bush@example.com', 'opheliapassword', 'customer'),
('Ana Ly', 'ana.ly@example.com', 'anapassword', 'customer'),
('Norma Stits', 'norma.stits@example.com', 'normapassword', 'customer'),
('Lou Skunt', 'lou.skunt@example.com', 'loupassword', 'customer'),
('Jack Mehoff', 'jack.mehoff@example.com', 'jackpassword', 'customer'),
('Admin User', 'admin@example.com', 'adminpassword', 'admin');
