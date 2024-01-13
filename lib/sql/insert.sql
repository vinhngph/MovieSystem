USE MovieSystem;

-- Inserting sample data into Users and Admin table 
INSERT INTO Users(username,password) values ('admin','admin');
INSERT INTO Admin VALUES('admin', 'Admin dep trai');

-- Inserting sample data into Actors table
INSERT INTO Actors (name) VALUES
('Morgan Freeman'),
('Marlon Brando'),
('Heath Ledger'),
('John Travolta'),
('Tom Hanks');

-- Inserting sample data into Cinemas table
INSERT INTO Cinemas (name, location) VALUES
('Cineplex 1', 'Downtown'),
('AMC Theatres 2', 'Midtown'),
('Regal Cinemas 3', 'Uptown'),
('Vue Cinema 4', 'Westside'),
('Odeon 5', 'Eastside');
