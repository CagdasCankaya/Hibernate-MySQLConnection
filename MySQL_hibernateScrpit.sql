use demo_jdbc;
create table Department (id int primary key, name varchar(45));
insert into Department (id,name) values(2,"name-1");
insert into Department (id,name) values(3,"name-3");

create table Employee (id int primary key, firstName varchar(45),lastName varchar(45) ,
					   department_id int, foreign key(department_id) references Department(id));
insert into Employee (id,firstName,lastName,department_id) values(1,"fname1","lname1",1);
select * from Employee;

drop table Department;
drop table Employee;

select * from Department;
select * from Employee;