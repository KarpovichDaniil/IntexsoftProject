CREATE SEQUENCE users_seq INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;
CREATE SEQUENCE roles_seq INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;
CREATE SEQUENCE cities_seq INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;
CREATE SEQUENCE categories_seq INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;
CREATE SEQUENCE goods_seq INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;

CREATE TABLE users (
	id integer DEFAULT NEXTVAL('users_seq') UNIQUE,
	username varchar(100) NOT NULL UNIQUE,
	password varchar(64) NOT NULL,
	email varchar(100) NOT NULL UNIQUE,
	enabled boolean NOT NULL DEFAULT FALSE,
	CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE TABLE roles (
	id integer DEFAULT NEXTVAL('roles_seq') UNIQUE,
	name varchar(100) NOT NULL UNIQUE,
	description varchar(1000) NOT NULL UNIQUE,
	CONSTRAINT roles_pk PRIMARY KEY (id)
);

CREATE TABLE cities (
	id integer DEFAULT NEXTVAL('cities_seq') UNIQUE,
	name varchar(100) NOT NULL,
	CONSTRAINT cities_pk PRIMARY KEY (id)
);

CREATE TABLE categories (
	id integer DEFAULT NEXTVAL('categories_seq') UNIQUE,
	name varchar(100) NOT NULL,
	CONSTRAINT categories_pk PRIMARY KEY (id)
);

CREATE TABLE goods (
	id integer DEFAULT NEXTVAL('goods_seq') UNIQUE,
	title varchar(1000) NOT NULL,
	description varchar(5000) NOT NULL,
	city_id integer NOT NULL,
	user_id integer NOT NULL,
	phone varchar(100) NOT NULL,
	price double precision NOT NULL,
	created_date TIMESTAMP NOT NULL,
	category_id integer NOT NULL,
	CONSTRAINT goods_pk PRIMARY KEY (id),
	FOREIGN KEY (city_id) REFERENCES cities(id),
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE users_roles (
	user_id integer NOT NULL,
	role_id integer NOT NULL,
	CONSTRAINT user_roles_pk PRIMARY KEY (user_id, role_id),
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (role_id) REFERENCES roles(id)
);