CREATE DATABASE netfrix;

CREATE TABLE users (
  id serial PRIMARY KEY,
  email varchar(150) NOT NULL,
  password varchar(50) NOT NULL,
  name varchar(225) NOT NULL,
  is_admin boolean NOT NULL DEFAULT false,
  date_of_birth date
);

CREATE TABLE public.video
(
  id serial PRIMARY KEY,
  name character varying(250),
  description character varying(2000),
  year integer,
  duration integer,
  director character varying(150),
  main_actor character varying(150),
  main_age integer,
  registration_date date,
  image character varying(150),
  id_season integer,
  episode integer
);

INSERT INTO users ( name, email, password, is_admin ) VALUES ( 'Netfrix Admin', 'admin@netfrix.com.br', '123123123', true );
