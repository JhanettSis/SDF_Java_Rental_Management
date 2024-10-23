## Drop Database RentManagement;
 
 ## Creating the Database: 
CREATE DATABASE RentManagement;

USE RentManagement;

## Creating the Clients Table: 
CREATE TABLE Clients (
  Client_No VARCHAR(10) PRIMARY KEY,
  Client_Name VARCHAR(50) NOT NULL
);

## Creating the Owners Table: 
CREATE TABLE Owners (
  Owner_No VARCHAR(10) PRIMARY KEY,
  Owner_Name VARCHAR(50) NOT NULL
);

## Creating the Properties Table: :
CREATE TABLE Properties (
  PropertyNo VARCHAR(10) PRIMARY KEY,
  Property_Address VARCHAR(255) NOT NULL,
  Monthly_Rent DECIMAL(10,2) NOT NULL,
  Owner_No VARCHAR(10),   FOREIGN KEY (Owner_No) REFERENCES Owners(Owner_No)
);

## Creating the Client_Properties Table:
CREATE TABLE Client_Properties (
  PropertyNo VARCHAR(10),
  Rent_Start DATE NOT NULL,
  Rent_Finish DATE NOT NULL,
  Client_No VARCHAR(10),
  FOREIGN KEY (PropertyNo) REFERENCES Properties(PropertyNo),
  FOREIGN KEY (Client_No) REFERENCES Clients(Client_No)
);

## insert information in table Clients
INSERT INTO Clients (Client_No, Client_Name)
VALUES ('CL-001', 'Jhanett Nicolas'),
       ('CL-002', 'Bob Smith'),
       ('CL-003', 'Charlie Brown'),
       ('CL-004', 'David Miller'),
       ('CL-005', 'Emily Garcia'),
       ('CL-006', 'Frank Hernandez'),
       ('CL-007', 'Grace Williams'),
       ('CL-008', 'Henry Moore'),
       ('CL-009', 'Isabella Lopez'),
       ('CL-010', 'Jackson Davis'),
       ('CL-011', 'Katherine Jones'),
       ('CL-012', 'Diana Taylor'),
       ('CL-013', 'Diego Garcia'),
       ('CL-014', 'Noah Wilson'),
       ('CL-015', 'Olivia Moore'),
       ('CL-016', 'Sophia Hernandez'),
       ('CL-017', 'William Jones'),
       ('CL-018', 'Durann Brown'),
       ('CL-019', 'Ethan Miller'),
       ('CL-020', 'Lily Garcia');


## for trying the info on table clients
Select * from Clients;

## Inserting Owners (10 Records):
INSERT INTO Owners (Owner_No, Owner_Name)
VALUES ('OW-001', 'Michael Thompson'),
       ('OW-002', 'David Lee'),
       ('OW-003', 'Sarah Wilson'),
       ('OW-004', 'Richard Garcia'),
       ('OW-005', 'Jennifer Hernandez'),
       ('OW-006', 'Charles Baker'),
       ('OW-007', 'Dana Johnson'),
       ('OW-008', 'Christopher Ramirez'),
       ('OW-009', 'Olivia Smith'),
       ('OW-0010', 'Matthew Walker');
       
## for trying the info on table owners
Select * from Owners;

## Inserting Properties (Sample Data):
INSERT INTO Properties (PropertyNo, Property_Address, Monthly_Rent, Owner_No)
VALUES ('PG-001', '10 Elm Street Glasgow', 500.00, 'OW-001'),
	   ('PG-002', '456 Elm St.', 1500.00, 'OW-002'),
       ('PG-003', '789 Oak Ave.', 1000.00, 'OW-003'),
       ('PG-004', '1011 Pine Blvd.', 800.00, 'OW-003'),
       ('PG-005', '1213 Maple St.', 1300.00, 'OW-005'),
       ('PG-006', '1415 Beach Dr.', 1800.00, 'OW-006'),
       ('PG-007', '1617 Park Ave.', 1100.00, 'OW-007'),
       ('PG-008', '1819 Mountain Rd.', 900.00, 'OW-008'),
       ('PG-009', '2021 Ocean View', 1600.00, 'OW-0010'),
       ('PG-010', '2223 City Center', 1400.00, 'OW-0010'),
       ('PG-011', '2425 Lakeside Dr.', 1200.00, 'OW-002'),
       ('PG-012', '2627 Riverside Ave.', 1000.00, 'OW-003'),
       ('PG-013', '2829 Sunset Blvd.', 800.00, 'OW-004'),
       ('PG-014', '3031 Valley Rd.', 1300.00, 'OW-001'),
       ('PG-015', '3233 Hillside Dr.', 1800.00, 'OW-003'),
       ('PG-016', '3435 Harbor View', 1100.00, 'OW-006'),
       ('PG-017', '3637 Forest Lane', 1500.00, 'OW-007'),
       ('PG-018', '3839 Meadow St.', 1000.00, 'OW-008'),
       ('PG-019', '4041 Country Club Rd.', 1200.00, 'OW-009'),
       ('PG-020', '4243 Downtown Ave.', 1400.00, 'OW-0010');


select * from Properties;

## Inserting Client-Property Relationships
INSERT INTO Client_Properties (PropertyNo, Rent_Start, Rent_Finish, Client_No)
VALUES 
    ('PG-001', '2024-01-15', '2025-01-15', 'CL-001'),  
    ('PG-002', '2022-12-01', '2023-12-31', 'CL-002'), 
    ('PG-004', '2023-07-01', '2024-06-30', 'CL-004'), 
    ('PG-005', '2026-01-01', '2027-01-31', 'CL-005'), 
    ('PG-005', '2021-02-01', '2023-12-31', 'CL-001'), 
    ('PG-006', '2020-08-15', '2021-08-31', 'CL-006'), 
    ('PG-007', '2027-01-01', '2028-01-31', 'CL-007'),
    ('PG-008', '2021-03-01', '2022-03-31', 'CL-008'), 
    ('PG-009', '2025-10-25', '2026-10-31', 'CL-009'),
    ('PG-002', '2020-07-01', '2021-07-31', 'CL-011'), 
    ('PG-005', '2024-04-15', '2025-04-30', 'CL-012'),
    ('PG-014', '2026-08-01', '2027-08-31', 'CL-013'), 
    ('PG-011', '2022-01-01', '2022-12-31', 'CL-014'), 
    ('PG-015', '2020-12-01', '2021-12-31', 'CL-015'),
    ('PG-010', '2020-08-15', '2021-08-31', 'CL-006'),  
    ('PG-016', '2027-01-01', '2028-01-31', 'CL-012'),
    ('PG-017', '2020-04-15', '2021-04-30', 'CL-004'), 
    ('PG-018', '2020-01-01', '2021-01-31', 'CL-011'),  
    ('PG-019', '2021-01-01', '2022-01-31', 'CL-011'),  
    ('PG-020', '2022-12-01', '2023-12-31', 'CL-010');

## ensure the info 
select * from Client_Properties;

##  1 ## Retrieve all clients along with their associated properties:
SELECT Clients.Client_No as No_Client, Clients.Client_name as Name, Properties.PropertyNo, 
			Properties.Property_Address as Address, Client_Properties.Rent_Start, Client_Properties.Rent_Finish
FROM Clients
JOIN Client_properties ON Clients.Client_No = Client_properties.Client_No
JOIN Properties ON Client_properties.PropertyNo = Properties.PropertyNo; 

##  2  ## List all properties rented out by all clients whose name begins with ‘D’:
SELECT Clients.Client_No, Clients.Client_Name, Properties.PropertyNo, Properties.Property_Address, Client_Properties.rent_start
FROM Clients
INNER JOIN Client_Properties ON Clients.Client_No = Client_Properties.Client_No
INNER JOIN Properties ON Client_Properties.PropertyNo = Properties.PropertyNo
WHERE Clients.Client_Name LIKE 'D%';

##  3  ## List all clients who have properties rented out for a specific duration, from the date 2023-02-20 to 2023-10-20:
SELECT Clients.Client_No, Clients.Client_Name, Client_Properties.Rent_Start, Client_Properties.Rent_finish
FROM Clients
INNER JOIN Client_Properties ON Clients.Client_No = Client_Properties.Client_No
WHERE Client_properties.Rent_start >= '2020-02-20' AND Client_properties.Rent_finish <= '2025-10-20';


##  4  ## Calculate the total monthly rent for each client:
SELECT Clients.Client_No, Clients.Client_Name, SUM(Properties.Monthly_Rent) AS Total_Monthly_Rent
FROM Clients
INNER JOIN Client_Properties ON Clients.Client_No = Client_Properties.Client_No
INNER JOIN Properties ON Client_Properties.PropertyNo = Properties.PropertyNo
GROUP BY Clients.Client_No, Clients.Client_Name;

##  5  ## Find the owner of a specific property:
SELECT Owners.Owner_Name, Properties.PropertyNo, Properties.Property_Address
FROM Properties
INNER JOIN Owners ON Properties.Owner_No = Owners.Owner_No
WHERE Properties.PropertyNo = 'PG-001'; 

##  6  ## Count the total number of properties owned by each owner:
SELECT Owners.Owner_No, Owners.Owner_Name, COUNT(Properties.PropertyNo) AS No_of_Property 
FROM Properties
INNER JOIN Owners ON Properties.Owner_No = Owners.Owner_No
GROUP BY Owner_Name;


##  7  ## Identify Clients Owning Multiple Properties (Using Client_Properties Table):
SELECT Clients.Client_No, Clients.Client_Name, COUNT(Client_properties.PropertyNo) AS Rented_Properties
FROM Clients
JOIN Client_properties ON Clients.Client_No = Client_properties.Client_No
GROUP BY Clients.Client_No, Clients.Client_Name
HAVING Rented_Properties >= 1;


##  8  ## List Clients with Total Annual Rent (Sorted by Lowest Rent):
SELECT Clients.Client_No, Client_Name, SUM(Monthly_rent) * 12 AS Annual_Rent 
FROM Clients
INNER JOIN Client_Properties ON Clients.Client_No = Client_Properties.Client_No
INNER JOIN Properties ON Client_Properties.PropertyNo = Properties.PropertyNo
GROUP BY Clients.Client_No
ORDER BY Annual_Rent ASC;

##  9  ## Find the Client Paying the Highest Monthly Rent:
SELECT Clients.Client_Name, MAX(Properties.Monthly_Rent) AS Highest_Monthly_Rent
FROM Clients
INNER JOIN Client_Properties ON Clients.Client_No = Client_Properties.Client_No
INNER JOIN Properties ON Client_Properties.PropertyNo = Properties.PropertyNo
WHERE Client_Properties.Rent_Start = ( SELECT MAX(Rent_Start)
  FROM Client_Properties AS cp2
  WHERE cp2.Client_No = Client_Properties.Client_No)
GROUP BY Clients.Client_No, Clients.Client_Name
ORDER BY Highest_Monthly_Rent DESC LIMIT 1;


##  10  ## List Properties with Rent Above Average Rent:
SELECT Property_Address, Monthly_Rent
FROM Properties 
where Monthly_Rent >= (SELECT AVG(Monthly_Rent) FROM Properties);
  