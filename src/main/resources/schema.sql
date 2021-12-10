create table if not exists users(
	id int not null primary key auto_increment,
	username varchar(50) not null,
	password varchar(50) not null,
	roles varchar(50) not null,
	active boolean not null
);


create table if not exists parking_spot(
	id int not null primary key auto_increment,
	area varchar(50) not null,
	pincode varchar(50) not null,
	latitude varchar(50) not null,
	longitude varchar(50) not null
);