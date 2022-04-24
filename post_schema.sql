create table post (
	id int primary key,
	name varchar(100),
	text varchar,
	link varchar(300) unique,
	created timestamp
);