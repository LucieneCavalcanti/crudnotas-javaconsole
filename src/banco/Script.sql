create database BDLPI
USE BDLPI
create table tbnotas(
id int not null primary key
identity,
aluno varchar(200) not null,
disciplina varchar(100) not null,
nota decimal(8,2) not null
)

select * from tbnotas