USE MovieSystem;

-- Insert Admin User
INSERT INTO Users (username, password) VALUES ('admin', 'admin');
INSERT INTO Admin (username, name) VALUES ('admin', 'This is a Admin of this Movie System');

-- Insert Actors
INSERT INTO Actors (name) VALUES
  ('Actor 1'),
  ('Actor 2'),
  ('Actor 3'),
  ('Actor 4'),
  ('Actor 5');

-- Insert Cinemas
INSERT INTO Cinemas (name, location) VALUES
  ('Cinema A', 'Location A'),
  ('Cinema B', 'Location B'),
  ('Cinema C', 'Location C');