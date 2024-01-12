CREATE DATABASE BookingSystem;

USE BookingSystem;

CREATE TABLE Users (
  username VARCHAR(50) PRIMARY KEY NOT NULL,
  password VARCHAR(255) NOT NULL
);
CREATE TABLE Staffs (
  username VARCHAR(50) PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL,
  department VARCHAR(255) NOT NULL,
  salary INT NOT NULL,
  FOREIGN KEY (username) REFERENCES Users(username)
);
CREATE TABLE Customers (
  username VARCHAR(50) PRIMARY KEY NOT NULL,
  name VARCHAR(50) NOT NULL,
  phone_number INT NOT NULL,
  age INT NOT NULL,
  FOREIGN KEY (username) REFERENCES Users(username)
);
CREATE TABLE Admin (
  username VARCHAR(50) PRIMARY KEY NOT NULL,
  name VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES Users(username)
);




CREATE TABLE Movies (
  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  title VARCHAR(255) NOT NULL,
  director VARCHAR(255) NOT NULL,
  category VARCHAR(255) NOT NULL,
  age_require INT NOT NULL
) AUTO_INCREMENT = 100;
CREATE TABLE Actors (
  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name VARCHAR(255) NOT NULL
) AUTO_INCREMENT = 200;
CREATE TABLE MovieActor (
  movie_id INT,
  actor_id INT,
  PRIMARY KEY (movie_id, actor_id),
  FOREIGN KEY (movie_id) REFERENCES Movies(id),
  FOREIGN KEY (actor_id) REFERENCES Actors(id)
);
