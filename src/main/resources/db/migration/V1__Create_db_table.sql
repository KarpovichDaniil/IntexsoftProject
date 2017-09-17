﻿CREATE TABLE users (
	id bigserial NOT NULL,
	username varchar(100) NOT NULL UNIQUE,
	password varchar(64) NOT NULL,
	email varchar(100) NOT NULL UNIQUE,
	enabled BOOLEAN NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
);



CREATE TABLE roles (
	id bigserial NOT NULL,
	name varchar(100) NOT NULL UNIQUE,
	description varchar(1000) NOT NULL UNIQUE,
	CONSTRAINT roles_pk PRIMARY KEY (id)
);



CREATE TABLE cities (
	id bigserial NOT NULL,
	name varchar(100) NOT NULL,
	CONSTRAINT cities_pk PRIMARY KEY (id)
);



CREATE TABLE goods (
	id bigserial NOT NULL,
	title varchar(1000) NOT NULL,
	description varchar(5000) NOT NULL,
	price money NOT NULL,
	city_id integer NOT NULL,
	user_id integer NOT NULL,
	created_date TIMESTAMP NOT NULL,
	category_id integer NOT NULL,
	CONSTRAINT goods_pk PRIMARY KEY (id),
	FOREIGN KEY (city_id) REFERENCES cities(id),
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (category_id) REFERENCES categories(id)
);



CREATE TABLE categories (
	id bigserial NOT NULL,
	name varchar(100) NOT NULL,
	CONSTRAINT categories_pk PRIMARY KEY (id)
);



CREATE TABLE users_roles (
	user_id integer NOT NULL,
	role_id integer NOT NULL,
	CONSTRAINT user_roles_pk PRIMARY KEY (user_id, role_id),
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (role_id) REFERENCES roles(id)
);

