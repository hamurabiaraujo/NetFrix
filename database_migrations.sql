CREATE DATABASE netfrix;

CREATE TABLE users (
  id serial PRIMARY KEY,
  email varchar(150) NOT NULL,
  password varchar(50) NOT NULL,
  name varchar(225) NOT NULL,
  is_admin boolean NOT NULL DEFAULT false,
  date_of_birth date
);

CREATE TABLE series (
	id serial PRIMARY KEY,
	name VARCHAR(150)
);

CREATE TABLE seasons (
	id serial PRIMARY KEY,
	number INT,
	series_id INT,
	CONSTRAINT FK_series
		FOREIGN KEY (series_id) REFERENCES series (id)
);

CREATE TABLE videos (
    id serial PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    description VARCHAR(2000) NOT NULL,
    year INT NOT NULL,
    duration INT NOT NULL,
    director VARCHAR(150) NOT NULL,
    main_actor VARCHAR(150) NOT NULL,
    min_age INT NOT NULL,
    registration_date DATE NOT NULL,
    image VARCHAR(150) NOT NULL,
    season_id INT,
    episode INT,
    CONSTRAINT FK_seasons
		FOREIGN KEY (season_id) REFERENCES seasons (id)
);

CREATE TABLE categories (
	id serial PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE video_category (
	video_id INT, 
	category_id INT,
	CONSTRAINT FK_video
		FOREIGN KEY (video_id) REFERENCES videos (id),
	CONSTRAINT FK_category
		FOREIGN KEY (category_id) REFERENCES categories (id)
);

INSERT INTO users ( name, email, password, is_admin ) VALUES ( 'Netfrix Admin', 'admin@netfrix.com.br', '123123123', true );
