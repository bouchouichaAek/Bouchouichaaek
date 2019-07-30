drop database `hotelmanagementsystem`;
create database `hotelmanagementsystem`;
use `hotelmanagementsystem`;


create table Room (
RomeId int not null auto_increment,
RomeNumber long not null,
RomeType varchar(10) not null,
RoomCapacity int not null,
FloorNumber int not null,
RomePhone varchar(15) not null,
RoomPrice int not null,
RoomStatus varchar(15),
constraint Room_pk primary key (RomeId)
);

create table customer(
customerID int not null auto_increment,
firtname varchar (20) not null,
lastname varchar (20) not null,
Email varchar(50) not null,
phoneNumber varchar (20) not null,
addres varchar (50) not null,
constraint customer_pk primary key (customerID)
);

create table Reservation (
ReservationId int not null auto_increment,
RomeID int not null,
CustomerID int not null,
CustomerType varchar(20) not null,
Duration int not null,
StartDate varchar(50) not null,
EndDate varchar(50) not null,
NumberOfPeople int not null,
Price int not null,
constraint Reservation_pk primary key (ReservationId),
foreign key (RomeID) references Room (RomeID),
foreign key (CustomerID) references customer (customerID)

);
describe Room;
describe Reservation;
describe customer;


CREATE TABLE hotelsection(
sectionID int not null auto_increment,
sectionname varchar (25) not null,
primary key (sectionID)
);

CREATE TABLE empeloye(
empeloyeID int not null auto_increment,
sectionID int not null ,
fullname varchar(50)not null,
addrres varchar (50) not null,
phoneNumber varchar(15)not null,
salary int not null,
primary key (empeloyeID),
foreign key (sectionID) references hotelsection (sectionID)
);

describe hotelsection;
describe empeloye



