create database Pet_Pals;

use Pet_Pals;

create table Pets
(
Pet_ID int primary key,
Name varchar(15),
Age int,
Breed varchar(20),
Type varchar(20),
Available_For_Adoption enum('YES', 'NO'),
Owner_ID int
);

insert into Pets (Pet_ID, Name, Age, Breed, Type, Available_For_Adoption, Owner_ID) values
(2001, 'Buddy', 3, 'GoldenRetriever', 'Dog', 'YES', 101),
(2002, 'Whiskers', 2, 'Siamese', 'Cat', 'NO', 102),
(2003, 'Chirpy', 1, 'Parakeet', 'Bird', 'YES', 103),
(2004, 'Spike', 5, 'Bulldog', 'Dog', 'YES', 104),
(2005, 'Mittens', 4, 'Persian', 'Cat', 'NO', 105),
(2006, 'Nibbles', 1, 'Guinea Pig', 'Rodent', 'YES', 106),
(2007, 'Flash', 2, 'Husky', 'Dog', 'YES', 107),
(2008, 'Shadow', 7, 'Labrador', 'Dog', 'NO', 108),
(2009, 'Sassy', 3, 'Tabby', 'Cat', 'YES', 109),
(2010, 'Fluffy', 6, 'Angora', 'Rabbit', 'YES', 110);

select * from Pets;

create table Shelters
(
Shelter_ID int primary key,
Name varchar(40),
Location varchar(50)
);

insert into Shelters (Shelter_ID, Name, Location) values
(3001, 'Happy Tails Shelter', '123 Main St, Springfield'),
(3002, 'Furry Friends Haven', '456 Elm St, Riverside'),
(3003, 'Safe Paws Rescue', '789 Oak Ave, Centerville'),
(3004, 'Pets Haven', '321 Pine Rd, Greenfield'),
(3005, 'Hopeful Hearts Shelter', '111 Birch Blvd, Riverdale'),
(3006, 'Rescue Me', '222 Willow St, Plainview'),
(3007, 'Pawsitive Vibes', '333 Maple Ave, Springfield'),
(3008, 'Four Paws Shelter', '444 Cedar Dr, Rivertown'),
(3009, 'Animal Angels', '555 Pine Ln, Westview'),
(3010, 'Faithful Friends', '666 Oakwood Dr, Northfield');

select * from Shelters;

SHOW TABLES;

create table Donations
(
Donation_ID int primary key,
Donar_Name varchar(20),
Donation_Type Enum('CASH','ITEM'),
Donation_Amount decimal(10,2),
Donation_Item varchar(20),
Donation_Date date
);

insert into Donations (Donation_ID, Donar_Name, Donation_Type, Donation_Amount, Donation_Item, Donation_Date) values
(4001, 'John', 'CASH', 100.00, 'N/A', '2024-11-01'),
(4002, 'Jane', 'ITEM', 0.00, 'Dog Food', '2024-11-05'),
(4003, 'Emily', 'CASH', 200.00, 'N/A', '2024-11-07'),
(4004, 'Michael', 'ITEM', 0.00, 'Cat Toys', '2024-11-10'),
(4005, 'Sarah', 'CASH', 50.00, 'N/A', '2024-11-12'),
(4006, 'David', 'ITEM', 0.00, 'Dog Beds', '2024-11-13'),
(4007, 'Lucy Kim', 'CASH', 75.00, 'N/A', '2024-11-15'),
(4008, 'Robert Martinez', 'ITEM', 0.00, 'Cat Food', '2024-11-17'),
(4009, 'Laura Chen', 'CASH', 120.00, 'N/A', '2024-11-18'),
(4010, 'James Allen', 'ITEM', 0.00, 'Dog Toys', '2024-11-19');

select * from Donations;

create table Adoption_Events
(
Event_ID int primary key,
Event_Name varchar(50),
Event_Date date,
Location varchar(40)
);

insert into Adoption_Events (Event_ID, Event_Name, Event_Date, Location) values
(5001, 'Paws for Love Adoption Fair', '2024-12-01', 'Community Park'),
(5002, 'Happy Tails Adoption Day', '2024-12-1', 'Shelter Grounds'),
(5003, 'Forever Homes Event', '2024-12-20', 'City Mall Courtyard'),
(5004, 'Find A Friend', '2025-01-05', 'Green Park'),
(5005, 'Rescue & Rehome', '2025-01-10', 'Downtown Shelter'),
(5006, 'Pet Adoption Drive', '2025-01-12', 'Community Hall'),
(5007, 'Fur-ever Friends', '2025-01-20', 'Westside Plaza'),
(5008, 'Open Hearts Adoption', '2025-01-25', 'Public Library'),
(5009, 'Shelter Showcase', '2025-01-30', 'City Square'),
(5010, 'Adopt A Paw', '2025-02-05', 'Eastwood Community Center');

select * from Adoption_Events;

create table Participants
(
Participant_ID int primary key,
Participant_Name varchar(30),
Participant_Type varchar(30),
Event_ID int,
foreign key (Event_ID) references Adoption_Events(Event_ID)
);

insert into Participants (Participant_ID, Participant_Name, Participant_Type, Event_ID) values
(9001, 'Happy Tails Shelter', 'Shelter', 5002),
(9002, 'Jane Smith', 'Adopter', 5009),
(9003, 'Furry Friends Haven', 'Shelter', 5001),
(9004, 'Emily Brown', 'Adopter', 5002),
(9005, 'Safe Paws Rescue', 'Shelter', 5004),
(9006, 'Michael Johnson', 'Adopter', 5003),
(9007, 'Pawsitive Vibes', 'Shelter', 5008),
(9008, 'John Doe', 'Adopter', 5003),
(9009, 'Pets Haven', 'Shelter', 5008),
(9010, 'Sarah Lee', 'Adopter', 5002);

select * from Participants;


