CREATE DATABASE vote_system;

USE vote_system;

CREATE TABLE admins (
	user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE nominee (
	nominee_id INT AUTO_INCREMENT PRIMARY KEY,
    nominee_name VARCHAR(50) UNIQUE,
    slogan VARCHAR(50)
);

CREATE TABLE voter (
	vote_id INT AUTO_INCREMENT PRIMARY KEY,
    voter_id VARCHAR(10),
    nominee_id INT,
    FOREIGN KEY(nominee_id) REFERENCES nominee(nominee_id) ON DELETE CASCADE
);

INSERT INTO admins (username, password) values ("yash", "pass123");