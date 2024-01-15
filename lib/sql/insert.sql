USE MovieSystem;

-- Insert Admin User
INSERT INTO Users (username, password) VALUES ('admin', 'admin');
INSERT INTO Admin (username, name) VALUES ('admin', 'This is a Admin of this Movie System');

-- Insert Movies
INSERT INTO Movies (title, director, category, age_require) VALUES
  ('Movie 1', 'Director 1', 'Action', 12),
  ('Movie 2', 'Director 2', 'Comedy', 18),
  ('Movie 3', 'Director 3', 'Drama', 16),
  ('Movie 4', 'Director 4', 'Sci-Fi', 12),
  ('Movie 5', 'Director 5', 'Thriller', 18);

-- Insert Actors
INSERT INTO Actors (name) VALUES
  ('Actor 1'),
  ('Actor 2'),
  ('Actor 3'),
  ('Actor 4'),
  ('Actor 5');

-- Associate Actors with Movies
INSERT INTO MovieActor (movie_id, actor_id) VALUES
  (100, 200),
  (100, 201),
  (100, 202),
  (101, 201),
  (101, 202),
  (102, 202),
  (103, 203),
  (104, 200),
  (104, 201),
  (104, 202),
  (104, 203),
  (104, 204);

-- Insert Cinemas
INSERT INTO Cinemas (name, location) VALUES
  ('Cinema A', 'Location A'),
  ('Cinema B', 'Location B'),
  ('Cinema C', 'Location C');

-- Insert Schedules
INSERT INTO Schedule (movie_id, cinema_id, date, quantity) VALUES
  (100, 301, '2024-01-20', 120),
  (100, 302, '2024-01-21', 80),
  (101, 302, '2024-01-22', 100),
  (101, 300, '2024-01-23', 150),
  (102, 301, '2024-01-24', 90),
  (102, 302, '2024-01-25', 110),
  (103, 300, '2024-01-26', 70),
  (103, 301, '2024-01-27', 120),
  (103, 302, '2024-01-28', 100),
  (104, 300, '2024-01-29', 180),
  (104, 301, '2024-01-30', 150),
  (104, 302, '2024-01-31', 120);
