CREATE DATABASE library;

USES library;

create table authors (id int auto_increment primary key, firstname varchar(255), lastname varchar(255), pseudo varchar(255));
create table editors (id int auto_increment primary key, name varchar(255), adress varchar(255));
create table books (id int auto_increment primary key, title varchar(255), authors int, editors int, parution date);

insert into authors(firstname,lastname,pseudo) values('jean-baptiste','poquelin','moliere');
insert into authors(firstname,lastname) values('victor','hugo');
insert into authors(firstname,lastname) values('isaac','asimov');
insert into authors(firstname,lastname) values('emile','zola');
insert into authors(firstname,lastname) values('allan','huxley');
insert into authors(firstname,lastname,pseudo) values('anne','dugael','gudule');
insert into authors(firstname,lastname) values('terry','pratchett');
insert into authors(firstname,lastname,pseudo) values('anonyme','anonyme','anonyme');
insert into authors(firstname,lastname) values('boris','vian');
insert into authors(firstname,lastname) values('melanie','fazzi');

insert into editors(name, adress) values ('albin michel','XXX');
insert into editors(name, adress) values ('pocket','XXX');
insert into editors(name, adress) values ('poche sf','XXX');
insert into editors(name, adress) values ('le point','XXX');

insert into books(title,authors,editors,parution) values('le bourgeois gentilhomme',1,1,'2001-01-10');
insert into books(title,authors,editors,parution) values('les fourberies de scapin',1,2,'2012-03-10');
insert into books(title,authors,editors,parution) values('les fondations',3,3,'2001-01-10');
insert into books(title,authors,editors,parution) values('le cycle des robots',3,3,'2001-01-10');
insert into books(title,authors,editors,parution) values('l assomoir',4,2,'2001-01-10');
insert into books(title,authors,editors,parution) values('notre dame de paris',2,1,'2001-01-10');
insert into books(title,authors,editors,parution) values('le meilleur des mondes',5,3,'2001-01-10');
insert into books(title,authors,editors,parution) values('tyran',5,2,'2001-01-10');
insert into books(title,authors,editors,parution) values('la huitieme couleur',7,3,'2001-01-10');
insert into books(title,authors,editors,parution) values('l hivernier',7,3,'2001-01-10');
insert into books(title,authors,editors,parution) values('marcel et les rats savants',7,3,'2001-01-10');
insert into books(title,authors,editors,parution) values('la huitieme fille',7,3,'2001-01-10');
insert into books(title,authors,editors,parution) values('le huitieme sortilllege',7,3,'2001-01-10');
insert into books(title,authors,editors,parution) values('l arrache coeur',9,1,'2001-01-10');
insert into books(title,authors,editors,parution) values('l herbe rouge',9,2,'2001-01-10');
insert into books(title,authors,editors,parution) values('serpentine',10,4,'2001-01-10');
insert into books(title,authors,editors,parution) values('anonymous',8,4,'2001-01-10');
insert into books(title,authors,editors,parution) values('anonymous2',8,4,'2001-01-10');