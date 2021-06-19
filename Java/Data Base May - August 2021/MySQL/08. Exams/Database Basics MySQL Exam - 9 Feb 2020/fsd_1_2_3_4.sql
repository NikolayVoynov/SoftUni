CREATE DATABASE fsd_1_2_3_4;
USE fsd_1_2_3_4;

CREATE TABLE players(
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(10) NOT NULL,
last_name VARCHAR(20) NOT NULL,
age INT(11) NOT NULL DEFAULT 0,
position CHAR(1) NOT NULL,
salary DECIMAL(10,2) NOT NULL DEFAULT 0,
hire_date DATETIME,
skills_data_id INT NOT NULL,
team_id INT
);


CREATE TABLE players_coaches (
player_id INT,
coach_id INT,
CONSTRAINT `pk_players_coaches`
PRIMARY KEY (player_id, coach_id)
);

CREATE TABLE coaches(
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(10) NOT NULL,
last_name VARCHAR(20) NOT NULL,
salary DECIMAL(10,2) NOT NULL DEFAULT 0,
coach_level INT NOT NULL DEFAULT 0
);

CREATE TABLE skills_data(
id INT AUTO_INCREMENT PRIMARY KEY,
dribbling INT DEFAULT 0,
pace INT DEFAULT 0,
passing INT DEFAULT 0,
shooting INT DEFAULT 0,
speed INT DEFAULT 0,
strength INT DEFAULT 0
);

CREATE TABLE countries(
id INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(45) NOT NULL
);

CREATE TABLE towns(
id INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(45) NOT NULL,
country_id INT NOT NULL,
CONSTRAINT `fk_towns_countries`
FOREIGN KEY (country_id)
REFERENCES countries(id)
);

CREATE TABLE stadiums(
id INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(45) NOT NULL,
capacity INT NOT NULL,
town_id INT NOT NULL,
CONSTRAINT `fk_stadiums_towns`
FOREIGN KEY (town_id)
REFERENCES towns(id)
);

CREATE TABLE teams(
id INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(45) NOT NULL,
established DATE NOT NULL,
fan_base BIGINT NOT NULL DEFAULT 0,
stadium_id INT NOT NULL,
CONSTRAINT `fk_teams_stadiums`
FOREIGN KEY (stadium_id)
REFERENCES stadiums(id)
);

ALTER TABLE players
ADD CONSTRAINT `fk_players_skills`
FOREIGN KEY (skills_data_id)
REFERENCES skills_data(id);

ALTER TABLE players
ADD CONSTRAINT `fk_players_teams`
FOREIGN KEY (team_id)
REFERENCES teams(id);

ALTER TABLE players_coaches
ADD CONSTRAINT `fk_players_coaches_players`
FOREIGN KEY (player_id)
REFERENCES players(id);

ALTER TABLE players_coaches
ADD CONSTRAINT `fk_players_coaches_coaches`
FOREIGN KEY (coach_id)
REFERENCES coaches(id);

/* Problem 02 - Insert */

INSERT INTO coaches (first_name, last_name, salary, coach_level )
SELECT first_name, last_name, salary * 2, char_length(first_name)
FROM players
WHERE age >= 45;

/* Problem 03 - Update */

/* 1st solution */
UPDATE coaches
SET coach_level = coach_level + 1
WHERE first_name LIKE 'A%' 
AND id = (SELECT coach_id FROM players_coaches WHERE coach_id = id LIMIT 1);

/* 2nd solution */
UPDATE coaches
SET coach_level = coach_level + 1
WHERE first_name LIKE 'A%' 
AND id IN (SELECT coach_id FROM players_coaches WHERE count(player_id) > 0 GROUP BY coach_id);

/* Problem 04 - Delete */

DELETE FROM players
WHERE age >= 45;