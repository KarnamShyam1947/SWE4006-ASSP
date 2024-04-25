create database if not exists assp;

use assp;

drop table if exists student;

create table student(
    id int auto_increment,
    name varchar(20),
    email varchar(30),
    phone varchar(15),
    reg_no varchar(15),
    unique(email),
    unique(reg_no),
    primary key(id)
);