-- create database mydb;



create table login(
    id serial not null primary key,
    username varchar(45),
    password varchar(45)
);


insert into login values (1, 'abc', 123), (2, 'xyz', 456);

