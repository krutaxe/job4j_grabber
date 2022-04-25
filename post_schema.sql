create table post (
	id serial primary key,
	name varchar(100),
	text varchar,
	link varchar(300) unique,
	created timestamp
);