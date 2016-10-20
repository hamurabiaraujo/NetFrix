CREATE DATABASE netfrix;

CREATE TABLE users (
  id serial PRIMARY KEY,
  email VARCHAR(150) NOT NULL,
  password VARCHAR(50) NOT NULL,
  name VARCHAR(225) NOT NULL,
  is_admin BOOLEAN NOT NULL DEFAULT false,
  date_of_birth DATE
);

CREATE TABLE series (
	id serial PRIMARY KEY,
	name VARCHAR(150)
);

CREATE TABLE seasons (
	id serial PRIMARY KEY,
	number INT NOT NULL,
	series_id INT NOT NULL,
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
	name VARCHAR(50) NOT NULL
);

CREATE TABLE video_category (
	video_id INT, 
	category_id INT,
	CONSTRAINT PK_video_category 
		PRIMARY KEY(video_id, category_id), 
	CONSTRAINT FK_video
		FOREIGN KEY (video_id) REFERENCES videos (id),
	CONSTRAINT FK_category
		FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE favorite_videos (
	video_id INT, 
	user_id INT,
	CONSTRAINT PK_favorite_videos
		PRIMARY KEY (video_id, user_id),
	CONSTRAINT FK_video
		FOREIGN KEY (video_id) REFERENCES videos (id),
	CONSTRAINT FK_user
		FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE favorite_series (
	series_id INT, 
	user_id INT,
	CONSTRAINT PK_favorite_series
		PRIMARY KEY (series_id, user_id),
	CONSTRAINT FK_series
		FOREIGN KEY (series_id) REFERENCES series (id),
	CONSTRAINT FK_user
		FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO users ( name, email, password, is_admin ) VALUES ( 'Netfrix Admin', 'admin@netfrix.com.br', '123123123', true );
INSERT INTO users ( name, email, password, is_admin ) VALUES ( 'John Doe', 'john@doe.com', '123123123', false);

INSERT INTO series (name) VALUES ('Vikings');
INSERT INTO series (name) VALUES ('Flash');
INSERT INTO series (name) VALUES ('Arrow');
INSERT INTO series (name) VALUES ('Two and a half men');

INSERT INTO seasons("number", series_id) VALUES (1, 1);
INSERT INTO seasons("number", series_id) VALUES (2, 1);
INSERT INTO seasons("number", series_id) VALUES (3, 1);
INSERT INTO seasons("number", series_id) VALUES (1, 2);
INSERT INTO seasons("number", series_id) VALUES (1, 3);
INSERT INTO seasons("number", series_id) VALUES (2, 3);
INSERT INTO seasons("number", series_id) VALUES (3, 3);
INSERT INTO seasons("number", series_id) VALUES (4, 3);
INSERT INTO seasons("number", series_id) VALUES (1, 4);
INSERT INTO seasons("number", series_id) VALUES (2, 4);

INSERT INTO videos(
            name, description, year, duration, director, main_actor, 
            min_age, registration_date, image, season_id, episode)
    VALUES ('Episodio 1', 'A hist�ria come�a', 2012, 40, 'Charlie Sheen', 'Katy Perry', 
            12, CURRENT_DATE, '#', 1, 1);
INSERT INTO videos(
            name, description, year, duration, director, main_actor, 
            min_age, registration_date, image, season_id, episode)
    VALUES ('Episodio 2', 'A hist�ria continua', 2012, 40, 'Charlie Sheen', 'Katy Perry', 
            12, CURRENT_DATE, '#', 1, 2);
INSERT INTO videos(
            name, description, year, duration, director, main_actor, 
            min_age, registration_date, image, season_id, episode)
    VALUES ('Episodio 3', 'A hist�ria continua novamente', 2012, 40, 'Charlie Sheen', 'Katy Perry', 
            12, CURRENT_DATE, '#', 1, 3);
INSERT INTO videos(
            name, description, year, duration, director, main_actor, 
            min_age, registration_date, image, season_id, episode)
    VALUES ('Apenas mais um de zueira', 'Nesse v�deo o cara cai de cara com a cara no ch�o', 2012, 2, 'Chao Lin', 'Ant�nio Bandeiras', 
            16, CURRENT_DATE, '#', null, null);
INSERT INTO videos(
            name, description, year, duration, director, main_actor, 
            min_age, registration_date, image, season_id, episode)
    VALUES ('Frozen', 'Filme legal pra crian�a', 2016, 121, 'Branca de Neve', 'Elza', 
            0, CURRENT_DATE, '#', null, null);

INSERT INTO categories(name) VALUES ('Humor');
INSERT INTO categories(name) VALUES ('Terror');
INSERT INTO categories(name) VALUES ('Suspense');
INSERT INTO categories(name) VALUES ('Drama');
INSERT INTO categories(name) VALUES ('Infantil');
INSERT INTO categories(name) VALUES ('A��o');

INSERT INTO favorite_series (series_id, user_id) VALUES (1, 2);
INSERT INTO favorite_series (series_id, user_id) VALUES (2, 2);

INSERT INTO favorite_videos (video_id, user_id) VALUES (4, 2);
INSERT INTO favorite_videos (video_id, user_id) VALUES (5, 2);

INSERT INTO video_category(video_id, category_id) VALUES (4, 1);
INSERT INTO video_category(video_id, category_id) VALUES (5, 5);