USE BookingSystem;

INSERT INTO Users(username,password) values ('admin','admin');
INSERT INTO Admin VALUES('admin', 'Vinh');


INSERT INTO Movies (title, director, category, age_require) VALUES
('Inception', 'Christopher Nolan', 'Sci-Fi', 13),
('The Shawshank Redemption', 'Frank Darabont', 'Drama', 18),
('The Dark Knight', 'Christopher Nolan', 'Action', 15);
select * from Movies;


INSERT INTO Movies (title, director, category, age_require) VALUES
('The Dark Knight', 'Christopher Nolan', 'Action', 15);


INSERT INTO Movies (title, director, category, age_require) VALUES
(?,?,?,?);

INSERT INTO Actors (name) VALUES ('Actor D');
select * from Actors;

INSERT INTO MovieActor (movie_id, actor_id) VALUES
(103,208),
(103,208),
(104,207);
SELECT * FROM MovieActor WHERE actor_id=300;

select * from MovieActor;


DELETE FROM MovieActor WHERE movie_id = 101;
DELETE FROM Movies WHERE id = 101;

DELETE FROM Actors WHERE id=201;
DELETE FROM MovieActor WHERE actor_id=201;



select * from MovieActor;

-- SELECT 
--     Movies.title AS movie_title,
--     GROUP_CONCAT(Actors.name ORDER BY Actors.name ASC) AS actor_names
-- FROM 
--     Movies
-- LEFT JOIN MovieActor ON Movies.id = MovieActor.movie_id
-- LEFT JOIN Actors ON MovieActor.actor_id = Actors.id
-- WHERE
--     Movies.id = 100
-- GROUP BY
--     Movies.id, Movies.title;

SELECT 
    Movies.id AS movie_id,
    Movies.title AS movie_title,
    Movies.director,
    Movies.category,
    Movies.age_require,
    GROUP_CONCAT(Actors.name ORDER BY Actors.name ASC) AS actor_names
FROM 
    Movies
LEFT JOIN MovieActor ON Movies.id = MovieActor.movie_id
LEFT JOIN Actors ON MovieActor.actor_id = Actors.id
GROUP BY
    Movies.id, Movies.title, Movies.director, Movies.category, Movies.age_require;
    
    
SELECT * FROM Actors;

INSERT INTO Cinemas (name, location) VALUES (?,?);

DELETE FROM Cinemas WHERE id=400;
DELETE FROM Cinemas WHERE id=303;

select * from staffs;

SELECT Schedule.id, Movies.title AS movie_title, Cinemas.name AS cinema_name, Schedule.date, Schedule.quantity
FROM Schedule
JOIN Movies ON Schedule.movie_id = Movies.id
JOIN Cinemas ON Schedule.cinema_id = Cinemas.id;

SELECT 
  Schedule.id, 
  Movies.title AS movie_title, 
  Cinemas.name AS cinema_name, 
  Schedule.date, 
  Schedule.quantity
FROM 
  Schedule
  JOIN Movies ON Schedule.movie_id = Movies.id
  JOIN Cinemas ON Schedule.cinema_id = Cinemas.id
WHERE 
  Schedule.movie_id=?
  AND Schedule.cinema_id=?;



select * from users;
select * from customers;

SELECT *
FROM Schedule
WHERE movie_id = 105 AND cinema_id = 304;


SELECT DISTINCT Cinemas.*
FROM Cinemas
JOIN Schedule ON Cinemas.id = Schedule.cinema_id
WHERE Schedule.movie_id = 115;


SELECT 
  Movies.id AS movie_id, 
  Movies.title AS movie_title, 
  Movies.director, 
  Movies.category, 
  Movies.age_require, 
  GROUP_CONCAT(
    Actors.name 
    ORDER BY 
      Actors.name ASC
  ) AS actor_names 
FROM 
  Movies 
  LEFT JOIN MovieActor ON Movies.id = MovieActor.movie_id 
  LEFT JOIN Actors ON MovieActor.actor_id = Actors.id 
WHERE 
  Movies.id = 115
GROUP BY 
  Movies.id, 
  Movies.title, 
  Movies.director, 
  Movies.category, 
  Movies.age_require;
  
SELECT 
  Schedule.id AS schedule_id,
  Movies.title AS movie_title,
  Cinemas.name AS cinema_name,
  Schedule.date,
  Schedule.quantity
FROM 
  Schedule
  JOIN Movies ON Schedule.movie_id = Movies.id
  JOIN Cinemas ON Schedule.cinema_id = Cinemas.id
WHERE 
  Schedule.id=?

