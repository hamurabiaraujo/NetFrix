CREATE DATABASE netfrix;

CREATE TABLE users (
  id serial PRIMARY KEY,
  email varchar(150) NOT NULL,
  password varchar(50) NOT NULL,
  name varchar(225) NOT NULL,
  is_admin boolean NOT NULL DEFAULT false,
  date_of_birth date
);

INSERT INTO users ( name, email, password, is_admin ) VALUES ( 'Netfrix Admin', 'admin@netfrix.com.br', '123123123', true );
