CREATE DATABASE MovieSystem;
GO

USE MovieSystem;
GO

CREATE TABLE Users (
  username VARCHAR(50) PRIMARY KEY NOT NULL,
  password VARCHAR(255) NOT NULL
);
GO

CREATE TABLE Staffs (
  username VARCHAR(50) PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL,
  department VARCHAR(255) NOT NULL,
  salary INT NOT NULL,
  FOREIGN KEY (username) REFERENCES Users(username)
);
GO

CREATE TABLE Customers (
  username VARCHAR(50) PRIMARY KEY NOT NULL,
  name VARCHAR(50) NOT NULL,
  phone_number INT NOT NULL,
  age INT NOT NULL,
  FOREIGN KEY (username) REFERENCES Users(username)
);
GO

CREATE TABLE Admin (
  username VARCHAR(50) PRIMARY KEY NOT NULL,
  name VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES Users(username)
);
GO

CREATE TABLE Movies (
  id INT PRIMARY KEY IDENTITY(100,1) NOT NULL,
  title VARCHAR(255) NOT NULL,
  director VARCHAR(255) NOT NULL,
  category VARCHAR(255) NOT NULL,
  age_require INT NOT NULL
);
GO

CREATE TABLE Actors (
  id INT PRIMARY KEY IDENTITY(200,1) NOT NULL,
  name VARCHAR(255) NOT NULL
);
GO

CREATE TABLE MovieActor (
  movie_id INT,
  actor_id INT,
  PRIMARY KEY (movie_id, actor_id),
  FOREIGN KEY (movie_id) REFERENCES Movies(id),
  FOREIGN KEY (actor_id) REFERENCES Actors(id)
);
GO

CREATE TABLE Cinemas (
  id INT PRIMARY KEY IDENTITY(300,1) NOT NULL,
  name VARCHAR(255) NOT NULL,
  location VARCHAR(255) NOT NULL
);
GO

CREATE TABLE Schedule (
  id INT PRIMARY KEY IDENTITY(400,1) NOT NULL,
  movie_id INT,
  cinema_id INT,
  date DATE NOT NULL,
  quantity INT NOT NULL,
  FOREIGN KEY (movie_id) REFERENCES Movies(id),
  FOREIGN KEY (cinema_id) REFERENCES Cinemas(id)
);
GO

CREATE TABLE Billing (
  schedule_id INT,
  username VARCHAR(50),
  amount INT NOT NULL,
  price INT NOT NULL,
  PRIMARY KEY (schedule_id, username),
  FOREIGN KEY (schedule_id) REFERENCES Schedule(id),
  FOREIGN KEY (username) REFERENCES Users(username)
);
GO
