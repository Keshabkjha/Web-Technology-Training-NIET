create database empdb;
use empdb;
create table emp2(id int auto_increment primary key, name varchar(50), city varchar(50));
insert into emp2 (name, city) values("Jerry", "London");
select * from emp2;


create database empdb;
use empdb;
create table emp2(id int auto_increment primary key, name varchar(50), city varchar(50));
insert into emp2 (name, city) values("Jerry", "London");
select * from emp2;
update emp2 set city="Singapore" where id=1;
select * from emp2;









select * from emp;
insert into emp values(1, 'Raj', 'Hyderabad');
create table emptbl(id int not null, 
name varchar(50), 
city varchar(50),
PRIMARY KEY(id)
);

insert into emptbl values(1, 'Raj', 'Hyderabad'),
(2, 'Ravi', 'Hyderabad'),
(3, 'Ram', 'Chennai');

select * from emptbl;


create database demodb;
use demodb;