USE BookingSystem;

INSERT INTO Users(username,password) values ('admin','admin');
INSERT INTO Admin VALUES('admin', 'Vinh');


INSERT INTO Movies (title, director, category, age_require) VALUES
('Inception', 'Christopher Nolan', 'Sci-Fi', 13),
('The Shawshank Redemption', 'Frank Darabont', 'Drama', 18),
('The Dark Knight', 'Christopher Nolan', 'Action', 15);
select * from Movies;

INSERT INTO Actors (name) VALUES ('Actor D');
select * from Actors;

INSERT INTO MovieActor (movie_id, actor_id) VALUES
(101,204),
(101,205),
(102,204);
SELECT * FROM MovieActor WHERE actor_id=300;

DELETE FROM MovieActor WHERE movie_id = 100;
DELETE FROM Movies WHERE id = 100;

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


