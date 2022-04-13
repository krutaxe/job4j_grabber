CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company (id, name)
values (1, 'APPLE'),
	   (2, 'GOOGLE'),
	   (3, 'INTEL'),
	   (4, 'AMD'),
	   (5, 'META');
	   
insert into person (id, name, company_id)
values (1, 'Anna', 1),
	   (2, 'Alex', 1),
	   (3, 'Elena', 2),
	   (4, 'Dima', 3),
	   (5, 'Misha', 3),
	   (6, 'Tim', 3),
	   (7, 'Bob', 4),
	   (8, 'Marina',4),
	   (9, 'Tema', 4),
	   (10, 'Roma', 5);	   
	   
select * from person;
select * from company;

1. В одном запросе получить

- имена всех person, которые не состоят в компании с id = 5;

- название компании для каждого человека.

select p.name, c.name
from person p
join company c
on p.company_id = c.id
where c.id != 5;


2. Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании
(нужно учесть, что таких компаний может быть несколько).

select c.name, count(p.company_id)
from company as c
join person as p
on p.company_id = c.id
group by c.name
order by 2 desc
limit 1;
