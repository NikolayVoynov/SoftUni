USE fsd;

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
-- TODO FK
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

/* Problem 05 - Players */

SELECT first_name, age, salary 
FROM players
ORDER BY salary DESC;

 /* Problem 06 - Young offense players without contract */
 
 SELECT p.id, concat(first_name,' ', last_name) AS full_name, p.age, p.`position`, p.hire_date
 FROM players AS p
 JOIN skills_data AS sd
 ON  p.skills_data_id = sd.id
 WHERE p.position = 'A' AND p.age < 23 AND p.hire_date IS NULL AND sd.strength > 50
 ORDER BY salary ASC, age ASC;
 
 /* Problem 07 - Detail info for all teams */
 
 SELECT t.`name`, t.established, t.fan_base, count(p.id) AS count_of_players
 FROM teams AS t
 LEFT JOIN players AS p
 ON t.id = p.team_id
 GROUP BY t.id
 ORDER BY count_of_players DESC, t.fan_base DESC;
 
 /* Problem 08 - The fastest player by towns */
 
 SELECT max(sk.speed) AS max_speed, twn.`name` AS town_name
 FROM players AS p
 JOIN skills_data AS sk
 ON sk.id = p.skills_data_id
 RIGHT JOIN teams AS t
 ON t.id = p.team_id
 JOIN stadiums AS s
 ON t.stadium_id = s.id
 JOIN towns AS twn
 ON s.town_id = twn.id
 WHERE t.`name` != 'Devify'
 GROUP BY twn.`name`
 ORDER BY max_speed DESC, town_name;
 
 /* Problem 09 - Total salaries and players by country */
 
 SELECT cntr.`name` AS `name`, count(p.id) AS `total_count_of_players`, sum(salary) AS `total_sum_of_salaries`
 FROM players AS p
 RIGHT JOIN teams AS t
 ON p.team_id = t.id
 JOIN stadiums AS st
 ON t.stadium_id = st.id
 JOIN towns AS twn
 ON st.town_id = twn.id
 RIGHT JOIN countries AS cntr
 ON twn.country_id = cntr.id
 GROUP BY cntr.`name`
 ORDER BY total_count_of_players DESC, cntr.`name`;
 
 /* Problem 10 - Find all players that play on stadium */
 
DELIMITER $$
CREATE FUNCTION `udf_stadium_players_count`(stadium_name VARCHAR(30)) RETURNS int
    DETERMINISTIC
BEGIN
		DECLARE `count_players` INT;
		SET `count_players` :=( SELECT count(p.first_name) FROM players AS p
								RIGHT JOIN teams AS t ON p.team_id = t.id 
                                JOIN stadiums AS stm ON t.stadium_id = stm.id
								WHERE stm.`name` = `stadium_name`);
RETURN `count_players`;
END$$